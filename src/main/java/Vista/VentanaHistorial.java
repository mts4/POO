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
        java.util.List<Modelo.Resultado> historial = session.getResultadoController().obtenerHistorial();

        String texto = construirTextoHistorial(historial);
        txtHistorial.setText(texto);

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
    private String construirTextoHistorial(java.util.List<Modelo.Resultado> historial) {
        if (historial.isEmpty()) {
            return "Aún no se han jugado rondas en esta sesión.";
        }

        StringBuilder texto = new StringBuilder();
        texto.append("=== HISTORIAL DE JUGADAS DE ").append(session.getNombreUsuario()).append(" ===\n\n");

        int ronda = 0;
        int montoTotal = 0;

        for (Modelo.Resultado r : historial) {
            ronda++;
            texto.append("Jugada ").append(ronda).append(":\n");
            texto.append(" - Número salido : ").append(r.getNumero()).append("\n");
            texto.append(" - Tipo apuesta  : ").append(r.getTipo()).append("\n");
            texto.append(" - Monto apostado: $").append(r.getMonto()).append("\n");

            if (r.isAcierto()) {
                texto.append(" - Resultado     : RONDA GANADA\n");
                montoTotal += r.getMonto();
            } else {
                texto.append(" - Resultado     : RONDA PERDIDA\n");
                montoTotal -= r.getMonto();
            }
            texto.append("--------------------------------------\n");
        }

        texto.append("SALDO ACTUAL: $").append(session.getRuletaController().getSaldo())
                .append(" | BALANCE: $").append(montoTotal)
                .append(" | RONDAS JUGADAS: ").append(ronda).append("\n");

        return texto.toString();
    }
}