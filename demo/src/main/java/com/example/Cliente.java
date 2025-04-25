package com.example;

public class Cliente {

    private String nombre;//nombre del cliente
    private String correo;//correo del cliente
    private String clave;//clave del cliente
    private String telefono;//telefono asociado al cliente
    private Boolean esVip;//Inidica si el cliente es parte del grupo VIP o no

    // Constructor
    public Cliente(String nombre, String correo, String clave, String telefono, Boolean esVip) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.telefono = telefono;
        this.esVip = false; //de manera predeterminada, todos los usuarios NO forman parte del grupo VIP
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean esVip() {
        return esVip;
    }

    public void setesVip(Boolean esVip) {
        this.esVip = esVip;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", telefono='" + telefono + '\'' +
                ", vip=" + esVip +
                '}';
        }
}
