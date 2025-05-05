package com.logica;

import java.util.ArrayList;
public class JavaEventsInterfaz {

    // Atributos
    private final ArrayList<Evento> reservaEventos;
    private Cliente cliente;
    private Administrador administrador;
    private TarjetaCredito tarjetaCredito;
    private final Direccion direccion;

    // Constructor
    public JavaEventsInterfaz(ArrayList<Evento> reservaEventos, Cliente cliente, Administrador administrador, TarjetaCredito tarjetaCredito, Direccion direccion) {
        this.direccion = direccion;
        this.cliente = cliente;
        this.reservaEventos = reservaEventos;
        this.administrador = administrador;
        this.tarjetaCredito = tarjetaCredito;
    }

    // Metodos
    
    //1º metodo: permite buscar eventos por ciudad (adaptado para una interfaz de desarrollo con Maven-Swing)
    public ArrayList<Evento> buscarEventosPorCiudad(String ciudad) {
        if (ciudad == null || ciudad.isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía");
        }
        ArrayList<Evento> eventosEncontrados = new ArrayList<>();
        reservaEventos.stream()
                      .filter(evento -> evento.getLugar().equalsIgnoreCase(ciudad))
                      .forEach(eventosEncontrados::add);
        return eventosEncontrados; // Devuelve la lista de eventos encontrados
    }

    //2º metodo: permite buscar eventos por tipo, (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarEventosPorTipoSwing(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("El tipo no puede ser nulo o vacío");
        }
        ArrayList<Evento> eventosPorTipo = new ArrayList<>();
        for (Evento evento : reservaEventos) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                eventosPorTipo.add(evento);
            }
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Tipo");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            eventosPorTipo.forEach(evento -> textArea.append(evento.toString() + "\n"));
            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //3º metodo(extra): permite buscar eventos por palabra clave (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarEventosPorNombreSwing(String palabraClave) {
        if (palabraClave == null || palabraClave.isEmpty()) {
            throw new IllegalArgumentException("La palabra clave no puede ser nula o vacía");
        }
        ArrayList<Evento> eventosPorNombre = new ArrayList<>();
        for (Evento evento : reservaEventos) {
            if (evento.getNombre().toLowerCase().contains(palabraClave.toLowerCase())) {
                eventosPorNombre.add(evento);
            }
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Nombre");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            eventosPorNombre.forEach(evento -> textArea.append(evento.toString() + "\n"));
            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //4º metodo(extra): permite buscar eventos ordenados por precio, de forma que se ordenan los eventos por su precio de menor a mayor (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarEventosPorPrecioAscendenteSwing() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos);
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento1.getPrecio(), evento2.getPrecio()));
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Precio Ascendente");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            eventosOrdenados.forEach(evento -> textArea.append(evento.toString() + "\n"));
            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //5º metodo(extra): similar al anterior, pero en este caso se ordenan por precio de mayor a menor (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarEventosPorPrecioDescendenteSwing() {
        ArrayList<Evento> eventosOrdenados = new ArrayList<>(reservaEventos);
        eventosOrdenados.sort((evento1, evento2) -> Double.compare(evento2.getPrecio(), evento1.getPrecio()));
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Precio Descendente");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            eventosOrdenados.forEach(evento -> textArea.append(evento.toString() + "\n"));
            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //12º metodo: permite al admin ver todos los eventos, mostrando su información
    public String verEventos() {
    StringBuilder eventosInfo = new StringBuilder();
    for (Evento evento : reservaEventos) {
        eventosInfo.append("Título: ").append(evento.getTitulo()).append("\n")
                   .append("Tipo: ").append(evento.getTipo()).append("\n")
                   .append("Descripción: ").append(evento.getDescripcion()).append("\n")
                   .append("Lugar: ").append(evento.getLugar()).append("\n")
                   .append("Fechas disponibles: ").append(evento.getFechas()).append("\n")
                   .append("Precio: ").append(evento.getPrecio()).append("\n")
                   .append("Calificación: ").append(evento.getCalificacion()).append("\n\n");
                   }
    return eventosInfo.toString(); // Devuelve la información como un String
    }
}