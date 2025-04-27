package com.example;

import java.io.Serializable;

public class Resena implements Serializable {
    private Evento evento; // Evento que está siendo resenado
    private Cliente cliente; // Cliente que escribe la reseña
    private double calificacion; // Calificacion del 1 a 5
    private String comentario; // Comentario opcional

    // Constructor
    public Resena(Evento evento, Cliente cliente, double calificacion, String comentario) {     
        this.evento = evento;
        this.cliente = cliente;
        this.calificacion = calificacion;
        this.comentario = comentario; // Si el comentario es nulo, asignamos cadena vacia
    }

    // Getters y Setters
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario; // Si el comentario es nulo, se le asigna una cadena vacia de manera predeterminada
    }

    // Método toString para mostrar la reseña
    @Override
    public String toString() {
        return "Resena{" +
                "evento=" + evento.getTitulo() + // Solo se muestra el titulo del evento
                ", cliente=" + cliente.getNombre() + // Solo se muestra el nombre del cliente
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
