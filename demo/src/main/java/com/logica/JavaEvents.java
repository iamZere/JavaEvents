package com.logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JavaEvents {

    // Atributos
    private final ArrayList<Evento> reservaEventos;
    private final Cliente cliente;
    private final Administrador administrador;
    private final TarjetaCredito tarjetaCredito;

    // Constructor
    public JavaEvents(ArrayList<Evento> reservaEventos, Cliente cliente, Administrador administrador, TarjetaCredito tarjetaCredito) {
        this.cliente = cliente;
        this.reservaEventos = reservaEventos;
        this.administrador = administrador;
        this.tarjetaCredito = tarjetaCredito;
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

    //3º metodo(extra): permite buscar eventos por palabra clave, de forma que si coincide con el nombre del evento, se agrega a la lista de eventos encontrados
    public ArrayList<Evento> buscarEventosPorNombre(String palabraClave) {
        ArrayList<Evento> eventosPorNombre = new ArrayList<>();
        for (Evento evento : reservaEventos) {
            if (evento.getNombre().toLowerCase().contains(palabraClave.toLowerCase())) {  // Verifica si el nombre del evento contiene la palabra clave (ignorando mayúsculas/minúsculas)
                eventosPorNombre.add(evento);
            }
        } return eventosPorNombre;
    }

    //4º metodo(extra): permite buscar eventos ordenados por precio, de forma que se ordenan los eventos por su precio de menor a mayor
    public ArrayList<Evento> buscarEventosPorPrecioAscendente() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos); 
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento1.getPrecio(), evento2.getPrecio())); 
        return eventosOrdenados; // Devuelve la lista de eventos ordenados por precio ascendente
    }

    //5º metodo(extra): similar al anterior, pero en este caso se ordenan por precio de mayor a menor
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

    //Antes de proceder con el pago, se da la opcion de elegir el numero de entradas a comprar 
    public void seleccionarEntradas(int cantidadEntradas) {
        if (cantidadEntradas > 0) { 
            System.out.println("Cantidad de entradas seleccionadas: " + cantidadEntradas);
        } else {
            System.out.println("Error: La cantidad de entradas debe ser mayor que cero.");
        }
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

    //9º metodo: la aplicacion guarda la reserva en el perfil del cliente, mostrando la información de la reserva   
    public void guardarReserva(String evento, LocalDateTime fecha, int cantidadEntradas, double precio) {
        String fechaFormateada = fecha.toString();
        // Almacenar los datos de la reserva (los que contiene la factura) en la aplicación para futuras consultas
        ReservaEntradas nuevaReserva = new ReservaEntradas(evento, fechaFormateada, cantidadEntradas, precio); 
        cliente.anadirReserva(nuevaReserva); 

        // generacion de la factura
        String factura = "Cliente: " + cliente.getNombre() + "\nEvento: " + evento + "\nFecha: " + fechaFormateada + "\nImporte: " + precio;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("factura.txt"))) { // crea un nuevo fichero de texto
            writer.write(factura);
        } catch (IOException e) {
            System.out.println("Error al generar la factura: " + e.getMessage());
        } System.out.println("Reserva guardada con éxito: " + nuevaReserva.toString()); 
    }

    //10º metodo: permite unicamente al administrador crear un evento, verificando que el evento no exista previamente
    public void crearEvento(Evento nuevoEvento) {
        for (Evento evento : reservaEventos) {
            if (evento.getTitulo().equals(nuevoEvento.getTitulo())) { // Verifica si el evento ya existe
                System.out.println("El evento ya existe.");
                return;
            }
        } reservaEventos.add(nuevoEvento); // Agrega el nuevo evento a la lista
        System.out.println("Evento creado con éxito: " + nuevoEvento.getTitulo());
    }

    //11º metodo: permite al administrador eliminar un evento, verificando que el evento exista previamente
    public void eliminarEvento(Evento borrarEvento) {
        if (reservaEventos.remove(borrarEvento)) { // fuerza la eliminacion del evento, y si existe, procede, y si no, no hace nada
            System.out.println("Evento eliminado con éxito: " + borrarEvento.getTitulo());
        } else {
            System.out.println("El evento no existe.");
        }
    }

    //12º metodo: permite al administrador seleccionar un evento y modificar cualquier atributo del mismo, verificando que el evento exista previamente
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

    //13º metodo: permite al admin ver todos los eventos, mostrando su información
    public void verEventos() {
        for (Evento evento : reservaEventos) {
            System.out.println("Título: " + evento.getTitulo());
            System.out.println("Tipo: " + evento.getTipo());
            System.out.println("Descripción: " + evento.getDescripcion());
            System.out.println("Lugar: " + evento.getLugar());
            System.out.println("Fechas disponibles: " + evento.getFechas());
            System.out.println("Precio: " + evento.getPrecio());
        }
    }

    //14º metodo(extra): permite al admin ver eventos en funcion de su tipo, siendo Concierto, Deporte, Musical o Teatro las opciones posibles
    public void verEventosPorTipo(String tipo) {
        for (Evento evento : reservaEventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) { 
                System.out.println("Título: " + evento.getTitulo());
                System.out.println("Descripción: " + evento.getDescripcion());
                System.out.println("Lugar: " + evento.getLugar());
                System.out.println("Fechas disponibles: " + evento.getFechas());
                System.out.println("Precio: " + evento.getPrecio());
            }
        }
    }

    //15º metodo(extra): permite al admin ver eventos en funcion de la fecha del mismo, ordenando por fecha de menor a mayor
    public void verEventosPorFecha() {
        reservaEventos.sort((evento1, evento2) -> evento1.getFechas().get(0).compareTo(evento2.getFechas().get(0))); //ordena los eventos por la primera fecha disponible
        for (Evento evento : reservaEventos) {
            System.out.println("Título: " + evento.getTitulo());
            System.out.println("Descripción: " + evento.getDescripcion());
            System.out.println("Lugar: " + evento.getLugar());
            System.out.println("Fechas disponibles: " + evento.getFechas());
            System.out.println("Precio: " + evento.getPrecio());
        }
    }

    //16º metodo: permite al admin ver todos los clientes, mostrando su información
    public void verClientes() {
        System.out.println("Clientes registrados:");
        ArrayList<Cliente> clientes = administrador.getClientes(); // muestra lista de clientes al admin
        for (Cliente clienteVer : clientes) {
            System.out.println("Nombre: " + clienteVer.getNombre());
            System.out.println("Correo: " + clienteVer.getCorreo());
            System.out.println("Teléfono: " + clienteVer.getTelefono());
            System.out.println("VIP: " + (clienteVer.esVip() ? "Sí" : "No"));
            System.out.println("Reservas: " + clienteVer.getReservas().size());
        }
    }

    //17º metodo: permite al admin dar VIP a un cliente, verificando que el cliente exista previamente
    public void darVipCliente(Cliente cliente) {
        if (administrador.getClientes().contains(cliente)) { 
            cliente.setEsVip(true); // asigna el valor true al vip del cliente, modificado por el administrador
            System.out.println("Cliente VIP actualizado: " + cliente.getNombre());
        } else {
            System.out.println("El cliente no existe.");
        }
    }

    //18º metodo(extra): permite al admin buscar clientes por nombre, verificando que el cliente exista previamente
    public void buscarClientePorNombre(String nombre) {
        for (Cliente clienteNombre : administrador.getClientes()) {
            if (clienteNombre.getNombre().equalsIgnoreCase(nombre)) { //verifica que coincidan los nombres
                System.out.println("Cliente encontrado:");
                System.out.println("Cliente: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo());
                return; 
            }
        } System.out.println("Cliente no encontrado.");
    }

    //19º metodo(extra): permite al admin buscar cientes en funcion de si son VIP o no, mostrando el nombre y el correo de los clientes VIP
    public void buscarClientesPorVip(boolean esVip) {
        for (Cliente clienteVIP : administrador.getClientes()) {
            if (clienteVIP.esVip() == esVip) { 
                System.out.println("Cliente: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo());
            }
        }
    }

    //20º metodo: permite al admin visualizar las reservas de todos los clientes de la aplicacion ordenadas por la fecha de la realizacion de la reserva (menor a mayor)
    public void verReservas() {
        ArrayList<ReservaEntradas> reservas = new ArrayList<>(); // Lista para almacenar todas las reservas
        for (Cliente clienteReservas : administrador.getClientes()) { // Recorre todos los clientes
            reservas.addAll(clienteReservas.getReservas()); // Añade las reservas de cada cliente a la lista
        } 
        reservas.sort((reserva1, reserva2) -> reserva1.getFecha().compareTo(reserva2.getFecha())); // Ordena las reservas por fecha
        for (ReservaEntradas reserva : reservas) {
            System.out.println("Reserva: " + reserva.toString());
        }
    }

    //21º metodo(extra): dar la opcion al admin de seleccionar todas las reservas o solo a partir de una fecha especifica (fecha en la que se hizo la reserva)
    public void verReservasDesdeFecha(LocalDateTime fechaDesde) {
        ArrayList<ReservaEntradas> reservas = new ArrayList<>(); 
        for (Cliente clienteReservas : administrador.getClientes()) { // recorre todos los clientes
            reservas.addAll(clienteReservas.getReservas()); // añade las reservas de cada cliente a la lista
        } 
        for (ReservaEntradas reserva : reservas) {
            if (LocalDateTime.parse(reserva.getFecha()).isAfter(fechaDesde)) { //el parse permite que .isAfter comprenda la fecha
                System.out.println("Reserva: " + reserva.toString());
            }
        }
    } 
}