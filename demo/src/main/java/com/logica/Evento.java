package com.logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
    private String titulo; // nombre del evento
    private String tipo; // tipo de evento (concierto, obra de teatro, etc.)
    private String descripcion; // descripcion del evento
    private String lugar; // lugar del evento
    private List<LocalDateTime> fechas; // lista de fechas y horas del evento  
    private double precio; // precio del evento
    private String direccionImagen; // direccion de la imagen del evento
    private double calificacion; // calificacion del evento (1-5)
    private static final List<String> TIPOS_VALIDOS = List.of("Concierto", "Deporte", "Musical", "Teatro");
    private String nombre; // nombre del evento para su búsqueda por metodo palabra clave

    // Constructor
    public Evento(String titulo, String tipo, String descripcion, String lugar, List<LocalDateTime> fechas, double precio, String direccionImagen, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fechas = fechas != null ? fechas : new ArrayList<>(); // Asegura que la lista de fechas no sea null
        this.precio = precio;
        this.direccionImagen = direccionImagen;
        this.calificacion = calificacion;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo de evento no puede estar vacío.");
        }
        if (!TIPOS_VALIDOS.contains(tipo)) {
            throw new IllegalArgumentException("El tipo de evento debe ser uno de los siguientes: " + TIPOS_VALIDOS);
        }
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.isEmpty()) {
            throw new IllegalArgumentException("El lugar no puede estar vacío.");
        }
        this.lugar = lugar;
    }

    public List<LocalDateTime> getFechas() {
        return fechas;
    }

    public void setFechas(List<LocalDateTime> fechas) {
        if (fechas == null || fechas.isEmpty()) {
            throw new IllegalArgumentException("La lista de fechas no puede estar vacía.");
        }
        this.fechas = fechas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        if (direccionImagen == null || direccionImagen.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la imagen no puede estar vacía.");
        }
        this.direccionImagen = direccionImagen;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // Método para validar los datos del evento
    public void validarEvento() {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        if (lugar == null || lugar.isEmpty()) {
            throw new IllegalArgumentException("El lugar no puede estar vacío.");
        }
        if (fechas == null || fechas.isEmpty()) {
            throw new IllegalArgumentException("La lista de fechas no puede estar vacía.");
        }
        // Validar que las fechas no sean nulas o pasadas
        for (LocalDateTime fecha : fechas) {
            if (fecha == null) {
                throw new IllegalArgumentException("Una de las fechas no puede ser nula.");
            }
            if (fecha.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("Una de las fechas no puede ser en el pasado.");
            }
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (direccionImagen == null || direccionImagen.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la imagen no puede estar vacía.");
        }
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
    }

    // Método toString para mostrar el evento
    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", lugar='" + lugar + '\'' +
                ", fechas=" + fechas +
                ", precio=" + precio +
                ", direccionImagen='" + direccionImagen + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
