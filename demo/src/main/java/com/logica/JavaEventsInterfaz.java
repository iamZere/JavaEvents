package com.logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class JavaEventsInterfaz {

    // Atributos
    private final ArrayList<Evento> reservaEventos;
    private final Cliente cliente;
    private final Administrador administrador;
    private final TarjetaCredito tarjetaCredito;
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

    //9º metodo: la aplicacion guarda la reserva en el perfil del cliente, mostrando la información de la reserva   
    public void guardarReservaSwing(String evento, LocalDateTime fecha, int cantidadEntradas, double precio) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Guardar Reserva");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            String fechaFormateada = fecha.toString();
            ReservaEntradas nuevaReserva = new ReservaEntradas(evento, fechaFormateada, cantidadEntradas, precio);
            cliente.anadirReserva(nuevaReserva);

            String factura = "Cliente: " + cliente.getNombre() + "\nEvento: " + evento + "\nFecha: " + fechaFormateada + "\nImporte: " + precio;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("factura.txt"))) {
                writer.write(factura);
            } catch (IOException e) {
                textArea.append("Error al generar la factura: " + e.getMessage() + "\n");
            }

            textArea.append("Reserva guardada con éxito:\n" + nuevaReserva.toString() + "\n");
            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //10º metodo: permite unicamente al administrador crear un evento, verificando que el evento no exista previamente
    public void crearEventoSwing(Evento nuevoEvento) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Crear Evento");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            boolean eventoExiste = reservaEventos.stream()
                                                 .anyMatch(evento -> evento.getTitulo().equals(nuevoEvento.getTitulo()));

            if (eventoExiste) {
                textArea.append("El evento ya existe.\n");
            } else {
                reservaEventos.add(nuevoEvento);
                textArea.append("Evento creado con éxito: " + nuevoEvento.getTitulo() + "\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //11º metodo: permite al administrador eliminar un evento, verificando que el evento exista previamente (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void eliminarEventoSwing(Evento borrarEvento) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eliminar Evento");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            if (reservaEventos.remove(borrarEvento)) { // Fuerza la eliminación del evento si existe
                textArea.append("Evento eliminado con éxito: " + borrarEvento.getTitulo() + "\n");
            } else {
                textArea.append("El evento no existe.\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //12º metodo: permite al administrador seleccionar un evento y modificar cualquier atributo del mismo, verificando que el evento exista previamente (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void modificarEventoSwing(Evento cambiarEvento) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Modificar Evento");
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setLayout(new java.awt.GridLayout(8, 2));

            javax.swing.JTextField tituloField = new javax.swing.JTextField(cambiarEvento.getTitulo());
            javax.swing.JTextField tipoField = new javax.swing.JTextField(cambiarEvento.getTipo());
            javax.swing.JTextField descripcionField = new javax.swing.JTextField(cambiarEvento.getDescripcion());
            javax.swing.JTextField lugarField = new javax.swing.JTextField(cambiarEvento.getLugar());
            javax.swing.JTextField fechasField = new javax.swing.JTextField(cambiarEvento.getFechas().toString());
            javax.swing.JTextField precioField = new javax.swing.JTextField(String.valueOf(cambiarEvento.getPrecio()));
            javax.swing.JTextField direccionImagenField = new javax.swing.JTextField(cambiarEvento.getDireccionImagen());

            panel.add(new javax.swing.JLabel("Título:"));
            panel.add(tituloField);
            panel.add(new javax.swing.JLabel("Tipo:"));
            panel.add(tipoField);
            panel.add(new javax.swing.JLabel("Descripción:"));
            panel.add(descripcionField);
            panel.add(new javax.swing.JLabel("Lugar:"));
            panel.add(lugarField);
            panel.add(new javax.swing.JLabel("Fechas (separadas por comas):"));
            panel.add(fechasField);
            panel.add(new javax.swing.JLabel("Precio:"));
            panel.add(precioField);
            panel.add(new javax.swing.JLabel("Dirección Imagen:"));
            panel.add(direccionImagenField);

            javax.swing.JButton modificarButton = new javax.swing.JButton("Modificar");
            modificarButton.addActionListener(e -> {
                try {
                    String nuevoTitulo = tituloField.getText();
                    String nuevoTipo = tipoField.getText();
                    String nuevaDescripcion = descripcionField.getText();
                    String nuevoLugar = lugarField.getText();
                    ArrayList<LocalDateTime> nuevasFechas = new ArrayList<>();
                    for (String fecha : fechasField.getText().split(",")) {
                        nuevasFechas.add(LocalDateTime.parse(fecha.trim()));
                    }
                    double nuevoPrecio = Double.parseDouble(precioField.getText());
                    String nuevaDireccionImagen = direccionImagenField.getText();

                    boolean eventoEncontrado = false;
                    for (Evento evento : reservaEventos) {
                        if (evento.getTitulo().equals(cambiarEvento.getTitulo())) {
                            evento.setTitulo(nuevoTitulo);
                            evento.setTipo(nuevoTipo);
                            evento.setDescripcion(nuevaDescripcion);
                            evento.setLugar(nuevoLugar);
                            evento.setFechas(nuevasFechas);
                            evento.setPrecio(nuevoPrecio);
                            evento.setDireccionImagen(nuevaDireccionImagen);
                            eventoEncontrado = true;
                            javax.swing.JOptionPane.showMessageDialog(frame, "Evento modificado con éxito: " + nuevoTitulo);
                            break;
                        }
                    }

                    if (!eventoEncontrado) {
                        javax.swing.JOptionPane.showMessageDialog(frame, "El evento no existe.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | java.time.format.DateTimeParseException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error en el formato de los datos: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
            });

            frame.add(panel, java.awt.BorderLayout.CENTER);
            frame.add(modificarButton, java.awt.BorderLayout.SOUTH);
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //13º metodo: permite al admin ver todos los eventos, mostrando su información
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
    return eventosInfo.toString(); 
    }

    //14º metodo(extra): permite al admin ver eventos en funcion de su tipo, siendo Concierto, Deporte, Musical o Teatro las opciones posibles (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void verEventosPorTipoSwing(String tipo) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Tipo");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            boolean eventosEncontrados = false;
            for (Evento evento : reservaEventos) {
                if (evento.getTipo().equalsIgnoreCase(tipo)) {
                    textArea.append("Título: " + evento.getTitulo() + "\n");
                    textArea.append("Descripción: " + evento.getDescripcion() + "\n");
                    textArea.append("Lugar: " + evento.getLugar() + "\n");
                    textArea.append("Fechas disponibles: " + evento.getFechas() + "\n");
                    textArea.append("Precio: " + evento.getPrecio() + "\n\n");
                    eventosEncontrados = true;
                }
            }

            if (!eventosEncontrados) {
                textArea.append("No se encontraron eventos del tipo: " + tipo + "\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //15º metodo(extra): permite al admin ver eventos en funcion de la fecha del mismo, ordenando por fecha de menor a mayor (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void verEventosPorFechaSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Eventos por Fecha");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            reservaEventos.sort((evento1, evento2) -> evento1.getFechas().get(0).compareTo(evento2.getFechas().get(0))); // Ordena los eventos por la primera fecha disponible
            for (Evento evento : reservaEventos) {
                textArea.append("Título: " + evento.getTitulo() + "\n");
                textArea.append("Descripción: " + evento.getDescripcion() + "\n");
                textArea.append("Lugar: " + evento.getLugar() + "\n");
                textArea.append("Fechas disponibles: " + evento.getFechas() + "\n");
                textArea.append("Precio: " + evento.getPrecio() + "\n\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //16º metodo: permite al admin ver todos los clientes, mostrando su información (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void verClientesSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Clientes Registrados");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            textArea.append("Clientes registrados:\n\n");
            ArrayList<Cliente> clientes = administrador.getClientes(); // Muestra lista de clientes al admin
            for (Cliente clienteVer : clientes) {
                textArea.append("Nombre: " + clienteVer.getNombre() + "\n");
                textArea.append("Correo: " + clienteVer.getCorreo() + "\n");
                textArea.append("Teléfono: " + clienteVer.getTelefono() + "\n");
                textArea.append("VIP: " + (clienteVer.esVip() ? "Sí" : "No") + "\n");
                textArea.append("Reservas: " + clienteVer.getReservas().size() + "\n\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //17º metodo: permite al admin dar VIP a un cliente, verificando que el cliente exista previamente (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void darVipClienteSwing(Cliente cliente) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Dar VIP a Cliente");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
            textArea.setEditable(false);

            if (administrador.getClientes().contains(cliente)) {
                cliente.setEsVip(true); // Asigna el valor true al VIP del cliente
                textArea.append("Cliente VIP actualizado: " + cliente.getNombre() + "\n");
            } else {
                textArea.append("El cliente no existe.\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //18º metodo(extra): permite al admin buscar clientes por nombre, verificando que el cliente exista previamente (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarClientePorNombreSwing(String nombre) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Buscar Cliente por Nombre");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
            textArea.setEditable(false);

            boolean clienteEncontrado = false;
            for (Cliente clienteNombre : administrador.getClientes()) {
                if (clienteNombre.getNombre().equalsIgnoreCase(nombre)) {
                    textArea.append("Cliente encontrado:\n");
                    textArea.append("Nombre: " + clienteNombre.getNombre() + "\n");
                    textArea.append("Correo: " + clienteNombre.getCorreo() + "\n");
                    clienteEncontrado = true;
                    break;
                }
            }

            if (!clienteEncontrado) {
                textArea.append("Cliente no encontrado.\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //19º metodo(extra): permite al admin buscar clientes en función de si son VIP o no, mostrando el nombre y el correo de los clientes VIP (adaptado para una interfaz de desarrollo con Maven-Swing)
    public void buscarClientesPorVipSwing(boolean esVip) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Buscar Clientes por VIP");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            boolean clientesEncontrados = false;
            for (Cliente clienteVIP : administrador.getClientes()) {
                if (clienteVIP.esVip() == esVip) {
                    textArea.append("Nombre: " + clienteVIP.getNombre() + "\n");
                    textArea.append("Correo: " + clienteVIP.getCorreo() + "\n\n");
                    clientesEncontrados = true;
                }
            }

            if (!clientesEncontrados) {
                textArea.append("No se encontraron clientes " + (esVip ? "VIP." : "no VIP.") + "\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //20º metodo: permite al admin visualizar las reservas de todos los clientes de la aplicacion ordenadas por la fecha de la realizacion de la reserva (menor a mayor)
    public void verReservasSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Reservas de Clientes");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            ArrayList<ReservaEntradas> reservas = new ArrayList<>();
            for (Cliente clienteReservas : administrador.getClientes()) {
                reservas.addAll(clienteReservas.getReservas());
            }
            reservas.sort((reserva1, reserva2) -> reserva1.getFecha().compareTo(reserva2.getFecha()));

            for (ReservaEntradas reserva : reservas) {
                textArea.append("Reserva: " + reserva.toString() + "\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //21º metodo(extra): dar la opcion al admin de seleccionar todas las reservas o solo a partir de una fecha especifica (fecha en la que se hizo la reserva)
    public void verReservasDesdeFechaSwing(LocalDateTime fechaDesde) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Reservas desde Fecha");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            ArrayList<ReservaEntradas> reservas = new ArrayList<>();
            for (Cliente clienteReservas : administrador.getClientes()) {
                reservas.addAll(clienteReservas.getReservas());
            }

            for (ReservaEntradas reserva : reservas) {
                if (LocalDateTime.parse(reserva.getFecha()).isAfter(fechaDesde)) {
                    textArea.append("Reserva: " + reserva.toString() + "\n");
                }
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //22º y 23º metodo: permite al cliente registrarse en la aplicacion, y si ya esta registrado, podra iniciar sesion con su correo y clave
    public void iniciarSesionSwing(String correo, String clave) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Iniciar Sesión");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
            textArea.setEditable(false);

            boolean inicioExitoso = false;
            for (Cliente clienteRegistrado : administrador.getClientes()) {
                if (clienteRegistrado.getCorreo().equals(correo) && clienteRegistrado.getClave().equals(clave)) {
                    textArea.append("Inicio de sesión exitoso. Bienvenido, " + clienteRegistrado.getNombre() + "!\n");
                    inicioExitoso = true;
                    break;
                }
            }

            if (!inicioExitoso) {
                textArea.append("Error: Correo o clave incorrectos.\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public void registrarClienteSwing(String nombre, String correo, String clave, String telefono) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Registrar Cliente");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(10, 40);
            textArea.setEditable(false);

            boolean clienteExiste = false;
            for (Cliente clienteRegistrado : administrador.getClientes()) {
                if (clienteRegistrado.getCorreo().equals(correo)) {
                    textArea.append("El cliente ya está registrado.\n");
                    clienteExiste = true;
                    break;
                }
            }

            if (!clienteExiste) {
                Cliente nuevoCliente = new Cliente(nombre, correo, clave, telefono, direccion);
                administrador.getClientes().add(nuevoCliente);
                textArea.append("Cliente registrado con éxito. Bienvenido, " + nuevoCliente.getNombre() + "!\n");
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //24º metodo: permite al cliente dar una reseña al evento entre 1 y 5, siempre y cuando haya asistido al evento. (Extra)Tambien puede añadir un comentario
    public void darResenaEventoSwing(Evento evento) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Dar Reseña al Evento");
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setLayout(new java.awt.GridLayout(3, 2));

            javax.swing.JLabel calificacionLabel = new javax.swing.JLabel("Calificación (1-5):");
            javax.swing.JTextField calificacionField = new javax.swing.JTextField();
            javax.swing.JLabel comentarioLabel = new javax.swing.JLabel("Comentario:");
            javax.swing.JTextField comentarioField = new javax.swing.JTextField();
            javax.swing.JButton enviarButton = new javax.swing.JButton("Enviar");

            enviarButton.addActionListener(e -> {
                try {
                    int calificacion = Integer.parseInt(calificacionField.getText());
                    if (calificacion < 1 || calificacion > 5) {
                        javax.swing.JOptionPane.showMessageDialog(frame, "La calificación debe estar entre 1 y 5.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String comentario = comentarioField.getText();
                    evento.setCalificacion(calificacion);
                    javax.swing.JOptionPane.showMessageDialog(frame, "Reseña añadida con éxito: " + comentario + " - Calificación: " + calificacion);
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error: Introduzca un número válido para la calificación.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            });

            panel.add(calificacionLabel);
            panel.add(calificacionField);
            panel.add(comentarioLabel);
            panel.add(comentarioField);
            panel.add(enviarButton);

            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //25º metodo: permite al cliente consultar sus reservas, mostrando la información de cada reserva
    public void consultarReservasSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Consultar Reservas");
            javax.swing.JTextArea textArea = new javax.swing.JTextArea(20, 40);
            textArea.setEditable(false);

            List<ReservaEntradas> reservas = cliente.getReservas();
            if (reservas.isEmpty()) {
                textArea.append("Aún no tienes reservas.\n");
            } else {
                for (ReservaEntradas reserva : reservas) {
                    textArea.append(reserva.toString() + "\n");
                }
            }

            frame.add(new javax.swing.JScrollPane(textArea));
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    //26º metodo: permite al cliente modificar todos sus datos personales
    public void modificarDatosPersonalesSwing() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Modificar Datos Personales");
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setLayout(new java.awt.GridLayout(5, 2));

            javax.swing.JTextField nombreField = new javax.swing.JTextField(cliente.getNombre());
            javax.swing.JTextField correoField = new javax.swing.JTextField(cliente.getCorreo());
            javax.swing.JTextField claveField = new javax.swing.JTextField(cliente.getClave());
            javax.swing.JTextField telefonoField = new javax.swing.JTextField(cliente.getTelefono());
            javax.swing.JTextField direccionField = new javax.swing.JTextField(cliente.getDireccion().toString());

            panel.add(new javax.swing.JLabel("Nombre:"));
            panel.add(nombreField);
            panel.add(new javax.swing.JLabel("Correo:"));
            panel.add(correoField);
            panel.add(new javax.swing.JLabel("Clave:"));
            panel.add(claveField);
            panel.add(new javax.swing.JLabel("Teléfono:"));
            panel.add(telefonoField);
            panel.add(new javax.swing.JLabel("Dirección:"));
            panel.add(direccionField);

            javax.swing.JButton modificarButton = new javax.swing.JButton("Modificar");
            modificarButton.addActionListener(e -> {
                try {
                    String nuevoNombre = nombreField.getText();
                    String nuevoCorreo = correoField.getText();
                    String nuevaClave = claveField.getText();
                    String nuevoTelefono = telefonoField.getText();
                    Direccion nuevaDireccion = Direccion.parseDireccion(direccionField.getText());

                    cliente.setNombre(nuevoNombre);
                    cliente.setCorreo(nuevoCorreo);
                    cliente.setClave(nuevaClave);
                    cliente.setTelefono(nuevoTelefono);
                    cliente.setDireccion(nuevaDireccion);

                    javax.swing.JOptionPane.showMessageDialog(frame, "Datos personales modificados con éxito.");
                    frame.dispose();
                } catch (IllegalArgumentException | NullPointerException ex) {
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error al modificar los datos: " + ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.add(panel, java.awt.BorderLayout.CENTER);
            frame.add(modificarButton, java.awt.BorderLayout.SOUTH);
            frame.pack();
            frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}