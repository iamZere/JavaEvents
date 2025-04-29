package com.app;

import java.util.ArrayList;

import com.logica.Administrador;
import com.logica.Cliente;
import com.logica.Evento;


public class JavaEvents {

    // Atributos
    private ArrayList<Evento> reservaEventos;
    private Cliente cliente;
    private Administrador administrador;

    // Constructor
    public JavaEvents(ArrayList<Evento> reservaEventos) {
        this.reservaEventos = reservaEventos;
    }

    // Metodos

    //1º metodo: permite buscar eventos por ciudad. Se espera que la ciudad sea un String y se devuelve una lista de eventos que coinciden con la ciudad proporcionada.
    public ArrayList<Evento> buscarEventosPorCiudad(String ciudad) {
        ArrayList<Evento> eventosEncontrados = new ArrayList<>(); // Lista para almacenar los eventos encontrados
        for (Evento evento : reservaEventos) { 
            if (evento.getLugar().equalsIgnoreCase(ciudad)) { // Compara el lugar del evento con la ciudad proporcionada
                eventosEncontrados.add(evento); // Si coinciden, agrega el evento a la lista de eventos encontrados
            }
        }
        return eventosEncontrados; 
    }

    //2º metodo: permite buscar eventos por tipo, siendo Concierto, Deporte, Musical o Teatro las opciones posibles.
    public ArrayList<Evento> buscarEventosPorTipo(String tipo) {
        ArrayList<Evento> eventosPorTipo = new ArrayList<>(); 
        for (Evento evento : reservaEventos) { 
            if (evento.getTipo().equalsIgnoreCase(tipo)) { // Compara el tipo del evento con el tipo proporcionado
                eventosPorTipo.add(evento); // Si coinciden, agrega el evento a la lista de eventos encontrados
            }
        }
        return eventosPorTipo;
    }
}