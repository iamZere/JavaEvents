package com.example;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
    private String titulo; // nombre del evento
    private String tipo; // tipo de evento (concierto, obra de teatro, etc.)
    private Direccion direccion; // direccion del evento
    private List<LocalDateTime> fechas; // lista de fechas y horas del evento  
    private double precio; // precio del evento
    private String portada; // direccion de la imagen del evento
    private double calificacion; // calificacion del evento (1-5)

    // Constructor
    public Evento(String titulo, String tipo, Direccion direccion, List<LocalDateTime> fechas, double precio, String portada, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fechas = new ArrayList<>(fechas);
        this.precio = precio;
        this.portada = portada;
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
        this.tipo = tipo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección no puede ser nula.");
        }
        this.direccion = direccion;
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

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        if (portada == null || portada.isEmpty()) {
            throw new IllegalArgumentException("La dirección de la imagen no puede estar vacía.");
        }
        this.portada = portada;
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

    // Método para validar los datos del evento
    public void validarEvento() {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede estar vacío.");
        }
        if (direccion == null) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
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
        if (portada == null || portada.isEmpty()) {
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
                ", direccion=" + direccion +
                ", fechas=" + fechas +
                ", precio=" + precio +
                ", portada='" + portada + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
