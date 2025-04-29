package com.logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// La clase gestiona la compra de entradas para eventos. Incluye los métodos encontrados, genera una factura en un archivo de texto 
// y almacena los datos de la reserva. Algunos métodos son placeholders que requieren implementación adicional.
public class NoBorrar {
    public void buscarEventosPorCiudad(String ciudad) {
        // Implementación para buscar eventos por ciudad
    }

    public void buscarEventosPorTipo(String tipo) {
        // Implementación para buscar eventos por tipo
    }

    public void buscarEventosPorCriterios(Map<String, String> criterios) {
        // Implementación para buscar eventos combinando varios criterios
    }

    public void seleccionarEvento(String eventoId) {
        // Implementación para seleccionar un evento y mostrar su información
    }

    public void seleccionarFecha(String fecha) {
        // Implementación para seleccionar una fecha del evento
    }

    public double calcularPrecioConDescuento(double precio, boolean esVip) {
        if (esVip) {
            return precio * 0.9; // Aplica el 10% de descuento
        }
        return precio;
    }

    public void procesarPago(String tarjetaCredito, double importe) {
        // Implementación para procesar el pago con tarjeta de crédito
    }

    public void generarFactura(String cliente, String evento, String fecha, double importe) {
        String factura = "Cliente: " + cliente + "\nEvento: " + evento + "\nFecha: " + fecha + "\nImporte: " + importe;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("factura.txt"))) {
            writer.write(factura);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void almacenarReserva(String cliente, String evento, String fecha, double importe) {
        // Implementación para almacenar los datos de la reserva en la aplicación
    }

    // Método para reservar un evento (comprar)
    public void reservarEvento(Cliente cliente, String evento, String fecha, double precioPorEntrada, int cantidadEntradas, String tarjetaCredito) {
        // Calcula el precio total con descuento si el cliente es VIP
        double importeTotal = calcularPrecioConDescuento(precioPorEntrada * cantidadEntradas, cliente.esVip());

        procesarPago(tarjetaCredito, importeTotal);

        generarFactura(cliente.getNombre(), evento, fecha, importeTotal);

        // Crea una nueva reserva y la añade al cliente para que la pueda ver en su perfil
        ReservaEntradas nuevaReserva = new ReservaEntradas(evento, fecha, cantidadEntradas, importeTotal);
        cliente.anadirReserva(nuevaReserva);

        // Almacena la reserva
        almacenarReserva(cliente.getNombre(), evento, fecha, importeTotal);

        System.out.println("Reserva realizada con éxito para el cliente: " + cliente.getNombre());
    }
}