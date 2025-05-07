package com.logica;

import java.time.LocalDateTime;
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

    //6º metodo: permite seleccionar el evento deseado y muestra su información (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void seleccionarYMostrarEventoPorTituloSwing(String titulo) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Información del Evento");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            boolean eventoEncontrado = false;

            for (Evento evento : reservaEventos) {
                if (evento.getTitulo().equals(titulo)) {
                    textArea.append("Título: " + evento.getTitulo() + "\n");
                    textArea.append("Tipo: " + evento.getTipo() + "\n");
                    textArea.append("Descripción: " + evento.getDescripcion() + "\n");
                    textArea.append("Lugar: " + evento.getLugar() + "\n");
                    textArea.append("Fechas disponibles: " + evento.getFechas() + "\n");
                    textArea.append("Precio: " + evento.getPrecio() + "\n");
                    textArea.append("Calificación: " + evento.getCalificacion() + "\n");
                    eventoEncontrado = true;
                    break;
                }
            }

            if (!eventoEncontrado) {
                textArea.append("Evento no encontrado.");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //7º metodo: permite seleccionar las fechas disponibles del evento ya seleccionado anteriormente (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void seleccionarFechaSwing(LocalDateTime fecha) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Selección de Fecha");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            boolean fechaEncontrada = false;

            for (Evento evento : reservaEventos) {
                if (evento.getFechas().contains(fecha)) {
                    textArea.append("Fecha seleccionada: " + fecha + "\n");
                    fechaEncontrada = true;
                    break;
                }
            }

            if (!fechaEncontrada) {
                textArea.append("Fecha no disponible.");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // Antes de proceder con el pago, se da la opción de elegir el número de entradas a comprar (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void seleccionarEntradasSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Seleccionar Entradas");
            javax.swing.JPanel panel = new javax.swing.JPanel();
            javax.swing.JLabel label = new javax.swing.JLabel("Cantidad de entradas:");
            javax.swing.JTextField textField = new javax.swing.JTextField(10);
            javax.swing.JButton button = new javax.swing.JButton("Confirmar");

            button.addActionListener(e -> {
                try {
                    int cantidadEntradas = Integer.parseInt(textField.getText());
                    if (cantidadEntradas > 0) {
                        javax.swing.JOptionPane.showMessageDialog(frame, "Cantidad de entradas seleccionadas: " + cantidadEntradas);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(frame, "Error: La cantidad de entradas debe ser mayor que cero.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error: Introduzca un número válido.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            });

            panel.add(label);
            panel.add(textField);
            panel.add(button);
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    // 8º método: permite procesar el pago con la tarjeta de crédito, verificando si el importe es correcto y si la tarjeta es válida (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void procesarPagoSwing(double precio) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Procesar Pago");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
            textArea.setEditable(false);

            if (cliente != null && cliente.esVip()) {
                final double precioConDescuento = precio * 0.9; // Aplica un descuento del 10%
                textArea.append("Descuento VIP aplicado. Nuevo importe: " + precioConDescuento + "€.\n");
            }

            if (tarjetaCredito != null && precio > 0) {
                textArea.append("Procesando pago con tarjeta de crédito: " + tarjetaCredito.getNumeroTarjeta() + "\n");
                textArea.append("Pago procesado con éxito. Importe: " + precio + "€.\n");
            } else if (tarjetaCredito == null) {
                textArea.append("Error: La tarjeta de crédito no puede estar vacía.\n");
            } else if (precio <= 0) {
                textArea.append("Error: El importe debe ser mayor que cero.\n");
            } else {
                textArea.append("Error en el pago. Verifique los datos de la tarjeta y el importe.\n");
            }

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