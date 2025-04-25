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

    public Integer getPrecio() {
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String mostrarInformacion() {
        return "Título: " + titulo + "\n" + "Tipo: " + tipo + "\n" + "Dirección: " + direccion + "\n" +"Fecha: " + fecha.toString() + "\n" +"Precio: $" + precio + "\n" +"Calificación: " + calificacion + "/5";
    }       
}