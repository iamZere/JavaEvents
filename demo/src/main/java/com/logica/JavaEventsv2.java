package com.logica;

import java.util.ArrayList;

public class JavaEventsv2 {

    // Atributos
    private final ArrayList<Evento> reservaEventos;
    private Cliente cliente;
    private Administrador administrador;
    private TarjetaCredito tarjetaCredito;

    // Constructor
    public JavaEventsv2(ArrayList<Evento> reservaEventos) {
        this.reservaEventos = reservaEventos;
    }

    // Metodos
    
    //12º metodo: permite al admin ver todos los eventos, mostrando su información
    public String verEventos() {
    StringBuilder eventosInfo = new StringBuilder();
    for (Evento evento : reservaEventos) {
        eventosInfo.append("Título: ").append(evento.getTitulo()).append("\n")
                   .append("Tipo: ").append(evento.getTipo()).append("\n")
                   .append("Descripción: ").append(evento.getDescripcion()).append("\n")
                   .append("Lugar: ").append(evento.getLugar()).append("\n")
                   .append("Fechas disponibles: ").append(evento.getFechas()).append("\n")
                   .append("Precio: ").append(evento.getPrecio()).append("\n")
                   .append("Calificación: ").append(evento.getCalificacion()).append("\n\n");
                   }
    return eventosInfo.toString(); // Devuelve la información como un String
    }
}