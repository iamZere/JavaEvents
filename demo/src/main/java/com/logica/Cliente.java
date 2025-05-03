package com.logica;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;//Nombre del cliente
    private String correo;//Correo del cliente
    private String clave;//Clave del cliente
    private String telefono;//Telefono asociado al cliente
    private Boolean esVip;//Indica si el cliente es parte del grupo VIP o no
    private final List<ReservaEntradas> reservas;//Lista de reservas asociadas al cliente
    private Direccion direccion;//Direccion asociada al cliente

    // Constructor
    public Cliente(String nombre, String correo, String clave, String telefono, Direccion direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();//Crea una lista vacia de reservas para el cliente
        this.esVip = false; //De manera predeterminada, todos los usuarios NO forman parte del grupo VIP
        this.direccion = direccion;
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

    public void setEsVip(Boolean esVip) {
        this.esVip = esVip;
    }

    public List<ReservaEntradas> getReservas() {
        return reservas;
    }

    public void anadirReserva(ReservaEntradas reserva) {
        reservas.add(reserva);//Anade una reserva a la lista de reservas del cliente
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", telefono='" + telefono + '\'' +
                ", reservas=" + reservas +
                ", vip=" + esVip +
                '}';
        }
}
