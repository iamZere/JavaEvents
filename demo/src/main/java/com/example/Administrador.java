package com.example;

import java.util.Map; // Permite manejar pares clave-valor, como en la busqueda de eventos y clientes por criterios específicos

public class Administrador{
    private String correo;//Correo unico del administrador
    private String clave;//Clave asociada al administrador


    private Administrador(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
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

    // Gestion de eventos
    public void crearEvento(Evento evento) {
        // Lógica para crear un evento
    }

    public void eliminarEvento(Evento evento) {
        // Lógica para eliminar un evento
    }

    public void modificarEvento(Evento evento) {
        // Lógica para modificar un evento
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