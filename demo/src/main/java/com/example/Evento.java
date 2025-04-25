package com.example;

import java.time.LocalDateTime;

public class Evento {
    private String titulo; //nombre del evento
    private String tipo; //tipo de evento (concierto, obra de teatro, etc.)
    private String descripcion; //descripcion del evento
    private String lugar; //lugar del evento
    private LocalDateTime fecha; //fecha y hora del evento  
    private double precio; //precio del evento
    private String direccionImagen; //direccion de la imagen del evento
    private double calificacion; //calificacion del evento (1-5)

    // Constructor
    public Evento(String titulo, String tipo, String descripcion, String lugar, LocalDateTime fecha, double precio, String direccionImagen, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.direccionImagen = direccionImagen;
        this.calificacion = calificacion;
    }

    // Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    //Metodo para validar los datos del evento. Este metodo lanza una excepción si alguno de los datos no es válido o si no se ha introducido
    public void validarEvento() {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        else if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío.");
        }
        else if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        else if (lugar == null || lugar.isEmpty()) {
            throw new IllegalArgumentException("El lugar no puede estar vacío.");
        }
        else if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        else if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        else if (direccionImagen == null || direccionImagen.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la imagen no puede estar vacía.");
        }
        else if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
    }

    //Metodo para calcular el promedio de nota del evento. 

    // Método toString para mostrar el evento
    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", lugar='" + lugar + '\'' +
                ", fecha=" + fecha +
                ", precio=" + precio +
                ", direccionImagen='" + direccionImagen + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}