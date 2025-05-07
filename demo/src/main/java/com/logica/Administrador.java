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
}