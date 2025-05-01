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

    //1º metodo: permite buscar eventos por ciudad
    public ArrayList<Evento> buscarEventosPorCiudad(String ciudad) {
        ArrayList<Evento> eventosEncontrados = new ArrayList<>(); // Lista para almacenar los eventos encontrados
        for (Evento evento : reservaEventos) { 
            if (evento.getLugar().equalsIgnoreCase(ciudad)) { // Compara el lugar del evento con la ciudad proporcionada
                eventosEncontrados.add(evento); 
            }
        } return eventosEncontrados; 
    }

    //2º metodo: permite buscar eventos por tipo, siendo Concierto, Deporte, Musical o Teatro las opciones posibles
    public ArrayList<Evento> buscarEventosPorTipo(String tipo) {
        ArrayList<Evento> eventosPorTipo = new ArrayList<>(); 
        for (Evento evento : reservaEventos) { 
            if (evento.getTipo().equalsIgnoreCase(tipo)) { // Compara el tipo del evento con el tipo proporcionado
                eventosPorTipo.add(evento); 
            }
        } return eventosPorTipo;
    }

    //3º metodo: permite buscar eventos por palabra clave, de forma que si coincide con el nombre del evento, se agrega a la lista de eventos encontrados
    public ArrayList<Evento> buscarEventosPorNombre(String palabraClave) {
        ArrayList<Evento> eventosPorNombre = new ArrayList<>();
        for (Evento evento : reservaEventos) {
            if (evento.getNombre().toLowerCase().contains(palabraClave.toLowerCase())) {  // Verifica si el nombre del evento contiene la palabra clave (ignorando mayúsculas/minúsculas)
                eventosPorNombre.add(evento);
            }
        } return eventosPorNombre;
    }

    //4º metodo: permite buscar eventos ordenados por precio, de forma que se ordenan los eventos por su precio de menor a mayor
    public ArrayList<Evento> buscarEventosPorPrecioAscendente() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos); 
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento1.getPrecio(), evento2.getPrecio())); 
        return eventosOrdenados; // Devuelve la lista de eventos ordenados por precio ascendente
    }

    //5º metodo: similar al anterior, pero en este caso se ordenan por precio de mayor a menor
    public ArrayList<Evento> buscarEventosPorPrecioDescendente() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos); 
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento2.getPrecio(), evento1.getPrecio())); 
        return eventosOrdenados; // Devuelve la lista de eventos ordenados por precio descendente
    }

    //6º metodo: permite seleccionar el evento deseado y muestra su información
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

    //7º metodo: permite seleccionar las fechas disponibles del evento ya seleccionado anteriormente
    public void seleccionarFecha(LocalDateTime fecha) {
        for (Evento evento : reservaEventos) {
            if (evento.getFechas().contains(fecha)) { // Verifica si la fecha está disponible en el evento
                System.out.println("Fecha seleccionada: " + fecha);
                return;
            }
        } System.out.println("Fecha no disponible."); // No disponible si no coincide con ninguna fecha del evento
    }

    //8º metodo: permite procesar el pago con la tarjeta de credito, verificando si el importe es correcto y si la tarjeta es válida
    public void procesarPago(double precio) {
        if (cliente != null && cliente.esVip()) { 
            precio = precio * 0.9; // Aplica un descuento del 10%
            System.out.println("Descuento VIP aplicado. Nuevo importe: " + precio + "€.");
            }

        if (tarjetaCredito != null && precio > 0) { 
            System.out.println("Procesando pago con tarjeta de crédito: " + tarjetaCredito.getNumeroTarjeta());
            System.out.println("Pago procesado con éxito. Importe: " + precio + "€.");
        } else if (tarjetaCredito == null) {
            System.out.println("Error: La tarjeta de crédito no puede estar vacía.");
        } else if (precio <= 0) {
            System.out.println("Error: El importe debe ser mayor que cero.");
        } else {
            System.out.println("Error en el pago. Verifique los datos de la tarjeta y el importe.");
        }
    }

    //9º metodo: permite unicamente al administrador crear un evento, verificando que el evento no exista previamente
    public void crearEvento(Evento nuevoEvento) {
        for (Evento evento : reservaEventos) {
            if (evento.getTitulo().equals(nuevoEvento.getTitulo())) { // Verifica si el evento ya existe
                System.out.println("El evento ya existe.");
                return;
            }
        } reservaEventos.add(nuevoEvento); // Agrega el nuevo evento a la lista
        System.out.println("Evento creado con éxito: " + nuevoEvento.getTitulo());
    }

    //10º metodo: permite al administrador eliminar un evento, verificando que el evento exista previamente
    public void eliminarEvento(Evento borrarEvento) {
        if (reservaEventos.remove(borrarEvento)) { // fuerza la eliminacion del evento, y si existe, procede, y si no, no hace nada
            System.out.println("Evento eliminado con éxito: " + borrarEvento.getTitulo());
        } else {
            System.out.println("El evento no existe.");
        }
    }

    //11º metodo: permite al administrador seleccionar un evento y modificar cualquier atributo del mismo, verificando que el evento exista previamente
    public void modificarEvento(Evento cambiarEvento, String nuevoTitulo, String nuevoTipo, String nuevaDescripcion, String nuevoLugar, ArrayList<LocalDateTime> nuevasFechas, double nuevoPrecio, String nuevaDireccionImagen) {
        for (Evento evento : reservaEventos) {
            if (evento.getTitulo().equals(cambiarEvento.getTitulo())) {
                evento.setTitulo(nuevoTitulo);
                evento.setTipo(nuevoTipo);
                evento.setDescripcion(nuevaDescripcion);
                evento.setLugar(nuevoLugar);
                evento.setFechas(nuevasFechas);
                evento.setPrecio(nuevoPrecio);
                evento.setDireccionImagen(nuevaDireccionImagen);
                System.out.println("Evento modificado con éxito: " + nuevoTitulo);
                return;
            }
        } System.out.println("El evento no existe.");
    }
}