package com.example;

public class TarjetaCredito implements Serializable {
    private String nombreTitular;//nombre del titular de la tarjeta
    private String numeroTarjeta;//numero de la tarjeta
    private String fechaCaducidad;//fecha de caducidad de la tarjeta

    public TarjetaCredito(String nombreTitular, String numeroTarjeta, String fechaCaducidad) {    
        if (!validarNumero(numeroTarjeta)) {
            throw new IllegalArgumentException("El número de tarjeta debe tener exactamente 16 dígitos.");
        }
        if (nombreTitular == null || nombreTitular.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular no puede estar vacío.");
        }
        if (!validarFecha(fechaCaducidad)) {
            throw new IllegalArgumentException("La fecha de caducidad debe tener el formato MM/YY.");
        }

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

    //Metodo para validar el numero de la tarjeta de credito. El numero de la tarjeta debe tener exactamente 16 digitos numericos.
    private boolean validarNumeroTarjeta(String numeroTarjeta){
        if (numeroTarjeta == null || numeroTarjeta.length() != 16) {
            return false;
        }for (char c: numeroTarjeta.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
                }
            }
        }
        return true;
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