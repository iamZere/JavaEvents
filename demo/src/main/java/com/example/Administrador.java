package com.example;

public class Administrador{
    private String correo;//correo unico del administrador
    private String clave;//clave asociada al administrador
    private 

    public Administrador(String correo, String clave) {
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

    public void crearEvento(Evento evento) {
        // Lógica para crear un evento
    }

    public void eliminarEvento(Evento evento) {
        // Lógica para eliminar un evento
    }

    public void modificarEvento(Evento evento) {
        // Lógica para modificar un evento
    }

    public void verEventos() {
        // Lógica para ver eventos
    }

    public void darVipCliente(Cliente cliente) {
        // Lógica para dar VIP a un cliente
    }

}