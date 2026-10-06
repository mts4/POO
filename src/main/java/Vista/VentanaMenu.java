package Vista;

import Controlador.SessionController;
import javax.swing.*;
import java.awt.*;

public class VentanaMenu {
    private final SessionController session;

    private final JFrame frame = new JFrame("Menu - Casino Black Cat");
    private final JLabel lblSaldoMenu = new JLabel();

    private final JButton btnPerfil = new JButton("Perfil / Recargar");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");

    private final JPanel panelMensaje = new JPanel();
    private final JPanel panelBotones = new JPanel();

    private final Dimension tamanoBoton = new Dimension(230, 50);
    private final JTextArea txtMensaje = new JTextArea();

    public VentanaMenu(SessionController session) {
        this.session = session;

        configurarFrame();
        actualizarMensajeBienvenida();
        configurarBotones();
        configurarPanelBotones();
        configurarPanelMensaje();
        asignarAcciones();
    }

    public void mostrarVentana() {
        actualizarMensajeBienvenida();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void configurarFrame() {
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.add(panelMensaje);
        frame.add(panelBotones);
    }

    private void configurarBotones() {
        for (JButton botonNombre : new JButton[]{btnPerfil, btnJugar, btnHistorial, btnSalir}) {
            asignarDimBotones(botonNombre);
            centrarBotones(botonNombre);
        }
    }

    private void asignarDimBotones(JButton nombreBoton) {
        nombreBoton.setPreferredSize(tamanoBoton);
        nombreBoton.setMaximumSize(tamanoBoton);
    }

    private void centrarBotones(JButton nombreBoton) {
        nombreBoton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void configurarPanelMensaje() {
        panelMensaje.setLayout(null);
        panelMensaje.setBorder(BorderFactory.createLineBorder(Color.RED));
        panelMensaje.setBounds(400, 50, 590, 350);

        lblSaldoMenu.setBounds(50, 15, 400, 30);
        lblSaldoMenu.setFont(new Font("SansSerif", Font.BOLD, 18));
        panelMensaje.add(lblSaldoMenu);
        panelMensaje.add(txtMensaje);
    }

    private void actualizarMensajeBienvenida() {
        int saldoActual = session.getRuletaController().getSaldo();
        String nombreActual = session.getNombreUsuario();

        lblSaldoMenu.setText("Jugador: " + nombreActual + " | Saldo actual: $" + saldoActual);

        txtMensaje.setText(
                "RULETA — Casino Black Cat\n\n" +
                        "Bienvenido/a " + nombreActual + " al menú principal\n\n" +
                        "A la izquierda tienes:\n" +
                        "• Perfil / Recargar: modifica tu nombre o deposita saldo.\n" +
                        "• Jugar: abre la ventana de juego.\n" +
                        "• Historial: muestra las estadísticas de la sesión.\n" +
                        "• Salir: cierra sesión y vuelve al login."
        );

        txtMensaje.setEditable(false);
        txtMensaje.setOpaque(false);
        txtMensaje.setBounds(50, 60, 500, 260);
        txtMensaje.setFont(new Font("SansSerif", Font.PLAIN, 18));
    }

    private void configurarPanelBotones() {
        panelBotones.setBounds(10, 50, 380, 350);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        panelBotones.add(Box.createRigidArea(new Dimension(0, 50)));

        agregarBotonConMargen(btnPerfil);
        agregarBotonConMargen(btnJugar);
        agregarBotonConMargen(btnHistorial);
        agregarBotonConMargen(btnSalir);
    }

    private void agregarBotonConMargen(JButton boton) {
        panelBotones.add(boton);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
    }

    private void asignarAcciones() {
        btnPerfil.addActionListener(e -> opcionPerfil());
        btnJugar.addActionListener(e -> opcionJugar());
        btnHistorial.addActionListener(e -> opcionHistorial());
        btnSalir.addActionListener(e -> opcionSalir());
    }

    private void opcionJugar() {
        frame.dispose();
        new VentanaRuleta(session).mostrarVentana();
    }

    // Vista de perfil para consultar/modificar nombre y recargar saldo (Objetivo 6)
    private void opcionPerfil() {
        String[] opciones = {"Cambiar Nombre", "Depositar Saldo", "Cerrar"};
        String infoPerfil = "Nombre actual: " + session.getNombreUsuario() + "\n" +
                "Saldo actual: $" + session.getRuletaController().getSaldo() + "\n\n" +
                "¿Qué operación desea realizar?";

        int eleccion = JOptionPane.showOptionDialog(
                frame,
                infoPerfil,
                "Perfil de Usuario",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (eleccion == 0) {
            String nuevoNombre = JOptionPane.showInputDialog(frame, "Ingrese su nuevo nombre:", session.getNombreUsuario());
            if (nuevoNombre != null) {
                if (session.actualizarNombreUsuario(nuevoNombre)) {
                    actualizarMensajeBienvenida();
                    JOptionPane.showMessageDialog(frame, "Nombre actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(frame, "El nombre no puede estar vacío.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (eleccion == 1) {
            String montoStr = JOptionPane.showInputDialog(frame, "Ingrese el monto a depositar:");
            if (montoStr != null) {
                try {
                    int monto = Integer.parseInt(montoStr.trim());
                    if (session.getRuletaController().depositar(monto)) {
                        actualizarMensajeBienvenida();
                        JOptionPane.showMessageDialog(frame, "Depósito exitoso. Nuevo saldo: $" + session.getRuletaController().getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(frame, "El monto debe ser mayor a 0.", "Monto Inválido", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void opcionHistorial() {
        String estadisticas = session.getResultadoController().obtenerEstadisticas();
        JOptionPane.showMessageDialog(frame, estadisticas, "Historial de Jugadas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void opcionSalir() {
        session.cerrarSesion();
        frame.dispose();
        new VentanaLogin(session).mostrarVentana();
    }
}
