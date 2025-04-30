package com.logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JavaEvents {

    // Atributos
    private ArrayList<Evento> reservaEventos;
    private Cliente cliente;
    private Administrador administrador;
    private TarjetaCredito tarjetaCredito;

    // Constructor
    public JavaEvents(ArrayList<Evento> reservaEventos) {
        this.reservaEventos = reservaEventos;
    }

    // Metodos

    //1º metodo: permite buscar eventos por ciudad. Se espera que la ciudad sea un String y se devuelve una lista de eventos que coinciden con la ciudad proporcionada.
    public ArrayList<Evento> buscarEventosPorCiudad(String ciudad) {
        ArrayList<Evento> eventosEncontrados = new ArrayList<>(); // Lista para almacenar los eventos encontrados
        for (Evento evento : reservaEventos) { 
            if (evento.getLugar().equalsIgnoreCase(ciudad)) { // Compara el lugar del evento con la ciudad proporcionada
                eventosEncontrados.add(evento); // Si coinciden, agrega el evento a la lista de eventos encontrados
            }
        } return eventosEncontrados; 
    }

    //2º metodo: permite buscar eventos por tipo, siendo Concierto, Deporte, Musical o Teatro las opciones posibles.
    public ArrayList<Evento> buscarEventosPorTipo(String tipo) {
        ArrayList<Evento> eventosPorTipo = new ArrayList<>(); 
        for (Evento evento : reservaEventos) { 
            if (evento.getTipo().equalsIgnoreCase(tipo)) { // Compara el tipo del evento con el tipo proporcionado
                eventosPorTipo.add(evento); 
            }
        } return eventosPorTipo;
    }

    //3º metodo: permite buscar eventos por palabra clave, de forma que si coincide con el nombre del evento, se agrega a la lista de eventos encontrados.
    public ArrayList<Evento> buscarEventosPorNombre(String palabraClave) {
        ArrayList<Evento> eventosPorNombre = new ArrayList<>();
        for (Evento evento : reservaEventos) {
            if (evento.getNombre().toLowerCase().contains(palabraClave.toLowerCase())) {  // Verifica si el nombre del evento contiene la palabra clave (ignorando mayúsculas/minúsculas)
                eventosPorNombre.add(evento);
            }
        } return eventosPorNombre;
    }

    //4º metodo: permite buscar eventos ordenados por precio, de forma que se ordenan los eventos por su precio de menor a mayor.
    public ArrayList<Evento> buscarEventosPorPrecioAscendente() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos); 
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento1.getPrecio(), evento2.getPrecio())); 
        return eventosOrdenados; // Devuelve la lista de eventos ordenados por precio ascendente
    }

    //5º metodo: similar al anterior, pero en este caso se ordenan por precio de mayor a menor.
    public ArrayList<Evento> buscarEventosPorPrecioDescendente() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos); 
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento2.getPrecio(), evento1.getPrecio())); 
        return eventosOrdenados; // Devuelve la lista de eventos ordenados por precio descendente
    }

    //6º metodo: permite seleccionar el evento deseado y muestra su información.
    public void seleccionarYMostrarEventoPorTitulo(String titulo) {
    for (Evento evento : reservaEventos) {
        if (evento.getTitulo().equals(titulo)) { 
            // Muestra la información del evento si coincide el título
            System.out.println("Título: " + evento.getTitulo());
            System.out.println("Tipo: " + evento.getTipo());
            System.out.println("Descripción: " + evento.getDescripcion());
            System.out.println("Lugar: " + evento.getLugar());
            System.out.println("Fechas disponibles: " + evento.getFechas());
            System.out.println("Precio: " + evento.getPrecio());
            System.out.println("Calificación: " + evento.getCalificacion());
            return; // Termina el método después de mostrar la información
            }
        } System.out.println("Evento no encontrado.");
    }

    //7º metodo: permite seleccionar las fechas disponibles del evento ya seleccionado anteriormente.
    public void seleccionarFecha(String fecha) {
        for (Evento evento : reservaEventos) {
            if (evento.getFechas().contains(LocalDateTime.parse(fecha))) { // Verifica si la fecha está disponible en el evento
                System.out.println("Fecha seleccionada: " + fecha);
                return;
            }
        } System.out.println("Fecha no disponible."); // Si no se encuentra la fecha, muestra un mensaje
    }

    //8º metodo: permite procesar el pago con la tarjeta de credito, verificando si el importe es correcto y si la tarjeta es válida.
    public void procesarPago(String tarjetaCredito, double precio) {
        if (cliente != null && cliente.esVip()) { 
            precio = precio * 0.9; // Aplica un descuento del 10%
            System.out.println("Descuento VIP aplicado. Nuevo importe: " + precio + "€.");
            }

        if (tarjetaCredito != null && !tarjetaCredito.isEmpty() && precio > 0) { // Verifica que la tarjeta y el importe sean válidos
        System.out.println("Pago procesado con éxito. Importe: " + precio + "€.");
        } else if (tarjetaCredito == null || tarjetaCredito.isEmpty()) {
        System.out.println("Error: La tarjeta de crédito no puede estar vacía.");
        } else if (precio <= 0) {
        System.out.println("Error: El importe debe ser mayor que cero.");
        } else {
        System.out.println("Error en el pago. Verifique los datos de la tarjeta y el importe.");
        }
    }
}