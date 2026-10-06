package Vista;

import Controlador.RuletaController;
import Controlador.SessionController;
import Modelo.Resultado;
import Modelo.TipoApuesta;

import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {

    private final SessionController session;
    private final RuletaController controlador;

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JLabel lblMonto = new JLabel("Monto:");
    private final JLabel lblResultado = new JLabel("");
    private final JButton btnGirar = new JButton("Girar");
    private final JButton btnVolver = new JButton("Volver al Menú");
    private final JTextField txtSaldo = new JTextField();

    // Uso de TipoApuesta en JComboBox según Listing 7 de la guía
    private final JComboBox<TipoApuesta> cboTipo = new JComboBox<>(TipoApuesta.values());

    private final SpinnerNumberModel modeloMonto = new SpinnerNumberModel(100, 10, 10000, 10);
    private final JSpinner spinnerApuesta = new JSpinner(modeloMonto);

    public VentanaRuleta(SessionController session) {
        this.session = session;
        this.controlador = session.getRuletaController();

        configurarFrame();
        configuracionJcombo();
        configuracionJlabel();
        configuracionTxt();
        configuracionBoton();
        addFrame();
        configurarEventos();
    }

    public void mostrarVentana() {
        actualizarSaldoVista();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void configurarFrame() {
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void addFrame() {
        frame.add(lblTipo);
        frame.add(lblMonto);
        frame.add(cboTipo);
        frame.add(spinnerApuesta);
        frame.add(btnGirar);
        frame.add(btnVolver);
        frame.add(txtSaldo);
        frame.add(lblResultado);
    }

    private void configuracionJcombo() {
        cboTipo.setBounds(350, 120, 500, 35);
    }

    private void configuracionJlabel() {
        lblTipo.setBounds(200, 115, 200, 40);
        lblMonto.setBounds(200, 200, 200, 40);
        lblResultado.setBounds(200, 290, 650, 30);
        lblResultado.setFont(new Font("SansSerif", Font.BOLD, 13));
    }

    private void configuracionTxt() {
        txtSaldo.setBounds(700, 205, 150, 30);
        txtSaldo.setEditable(false);
        txtSaldo.setFocusable(false);
        actualizarSaldoVista();
    }

    private void configuracionBoton() {
        spinnerApuesta.setBounds(350, 205, 150, 30);
        btnGirar.setBounds(525, 205, 150, 30);
        btnVolver.setBounds(200, 360, 180, 35);
    }

    private void configurarEventos() {
        btnGirar.addActionListener(e -> ejecutarGiro());
        btnVolver.addActionListener(e -> volverAlMenu());
    }

    private void actualizarSaldoVista() {
        txtSaldo.setText("Saldo: $" + controlador.getSaldo());
    }

    private void ejecutarGiro() {
        int monto = (Integer) spinnerApuesta.getValue();
        TipoApuesta tipo = (TipoApuesta) cboTipo.getSelectedItem();

        // La Vista delega la coordinación al Controlador (Listing 2)
        Resultado resultado = controlador.realizarApuesta(tipo, monto);

        if (resultado == null) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Saldo insuficiente o monto inválido. Recargue saldo en su Perfil.",
                    "Apuesta no permitida",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        actualizarSaldoVista();
        mostrarResultado(resultado);
    }

    private void mostrarResultado(Resultado res) {
        String colorNumero = controlador.obtenerColorTexto(res.getNumero());
        String estado = res.isAcierto() ? "GANASTE" : "PERDISTE";

        lblResultado.setText(String.format(
                "Número %d (%s) | Apuesta=%s | Monto=$%d | %s | Saldo=$%d",
                res.getNumero(), colorNumero, res.getTipo(), res.getMonto(), estado, controlador.getSaldo()
        ));
    }

    private void volverAlMenu() {
        frame.dispose();
        new VentanaMenu(session).mostrarVentana();
    }
}