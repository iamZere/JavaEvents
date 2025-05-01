package com.logica;

import java.util.ArrayList;

public class Administrador{
    private String correo;//Correo unico del administrador
    private String clave;//Clave asociada al administrador
    private final ArrayList<Cliente> clientes;
    
    // Constructor
    public Administrador(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
        this.clientes = new ArrayList<>(); // Inicializa la lista de clientes
    }

    //Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Gestion de eventos
    public void crearEvento(Evento nuevoEvento) {
    }

    public void eliminarEvento(Evento borrarEvento) {
    }

    public void modificarEvento(Evento cambiarEvento) {
    }

    // Consulta de eventos
    public void verEventos() {
        // Lógica para ver eventos
    }

    public void buscarEventosPorCriterios(Map<String, String> criterios) {
        // Implementación para buscar eventos combinando varios criterios
    }

    // Consulta de usuarios
    public void darVipCliente(Cliente cliente) {
        // Lógica para dar VIP a un cliente
    }

    public void verClientes(Cliente cliente) {
        // Lógica para ver clientes
    }
    public void buscarClientesPorCriterios(Map<String, String> criterios) {
        // Implementación para buscar clientes combinando varios criterios
    }

    // Consulta de reservas
    public void verReservas() {
        // Lógica para ver reservas (tienen que estar ordenadas por fecha)
    }
    // Opcion volutaria - seleccionar todas las reservas o solo a partir de una fecha específica (fecha en la que se hizo la reserva)
}