package com.example;

import java.io.Serializable;

public class TarjetaCredito implements Serializable {
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaCaducidad;

    public TarjetaCredito(String nombreTitular, String numeroTarjeta, String fechaCaducidad) {    
        if (!validarNumeroTarjeta(numeroTarjeta)) {
            throw new IllegalArgumentException("El número de tarjeta debe tener exactamente 16 dígitos numéricos.");
        }
        if (!validarNombreTitular(nombreTitular)) {
            throw new IllegalArgumentException("El nombre del titular no puede estar vacío.");
        }
        if (!validarFechaCaducidad(fechaCaducidad)) {
            throw new IllegalArgumentException("La fecha de caducidad debe tener el formato MM/YY.");
        }

        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
    }

    // Método para validar el número de la tarjeta de crédito
    private boolean validarNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            return false;
        }
        for (char c : numeroTarjeta.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    // Método para validar el nombre del titular
    private boolean validarNombreTitular(String nombreTitular) {
        return nombreTitular != null && !nombreTitular.trim().isEmpty();
    }

    // Método para validar la fecha de caducidad
    private boolean validarFechaCaducidad(String fechaCaducidad) {
        if (fechaCaducidad == null || fechaCaducidad.length() != 5) {
            return false;
        }
        return fechaCaducidad.matches("(0[1-9]|1[0-2])/\\d{2}");
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

