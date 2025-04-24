package com.example;

public class TarjetaCredito{
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaCaducidad;

    public TarjetaCredito(String nombreTitular, String numeroTarjeta, String fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Getters y Setters
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "nombreTitular='" + nombreTitular + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaCaducidad='" + fechaCaducidad + '\'' +
                '}';
    }
}