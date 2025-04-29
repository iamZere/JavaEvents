package com.logica;

public class ReservaEntradas {
    private final String evento;
    private final String fecha;
    private final int cantidadEntradas;
    private final double importeTotal;

    public ReservaEntradas(String evento, String fecha, int cantidadEntradas, double importeTotal) {
        this.evento = evento;
        this.fecha = fecha;
        this.cantidadEntradas = cantidadEntradas;
        this.importeTotal = importeTotal;
    }

    public String getEvento() {
        return evento;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "evento='" + evento + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantidadEntradas=" + cantidadEntradas +
                ", importeTotal=" + importeTotal +
                '}';
    }
}