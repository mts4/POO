package Vista;

import Controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial {
    private final SessionController session;

    private final JFrame frame = new JFrame("Historial de Jugadas - Casino Black Cat");
    private final JTextArea txtHistorial = new JTextArea();
    private final JScrollPane scrollPane = new JScrollPane(txtHistorial);
    private final JButton btnVolver = new JButton("Volver al Menú");

    public VentanaHistorial(SessionController session) {
        this.session = session;

        configurarFrame();
        configurarAreaTexto();
        configurarBoton();
        addFrame();
        asignarAcciones();
    }

    public void mostrarVentana() {
        String estadisticas = session.getResultadoController().obtenerHistorial();
        txtHistorial.setText(estadisticas);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void configurarFrame() {
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void configurarAreaTexto() {
        txtHistorial.setEditable(false);
        txtHistorial.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtHistorial.setMargin(new Insets(10, 10, 10, 10));

        scrollPane.setBounds(50, 30, 480, 350);
    }

    private void configurarBoton() {
        btnVolver.setBounds(200, 400, 180, 35);
    }

    private void addFrame() {
        frame.add(scrollPane);
        frame.add(btnVolver);
    }

    private void asignarAcciones() {
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void volverAlMenu() {
        frame.dispose();
        new VentanaMenu(session).mostrarVentana();
    }
}