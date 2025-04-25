package com.example;

public class Administrador{
    private String correo;//correo unico del administrador
    private String clave;//clave asociada al administrador

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

}