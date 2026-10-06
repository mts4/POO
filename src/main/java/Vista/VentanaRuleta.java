package Vista;

import Modelo.Ruleta;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VentanaRuleta {

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JLabel lblColor = new JLabel("Seleccione color:");
    private final JLabel lblParidad = new JLabel("Seleccione paridad:");
    private final JLabel lblMonto = new JLabel("Monto:");
    private final JLabel lblResultado = new JLabel("");
    private final JButton btnGirar = new JButton("Girar");
    private final JTextField txtSaldo = new JTextField("Saldo: 1000");


    String[] tipo = {"Color", "Numero"};
    String[] color = {"Rojo", "Negro"};
    String[] paridad = {"Par", "Impar"};

    private final JComboBox<String> comboTipo = new JComboBox<>(tipo);
    private final JComboBox<String> comboColor = new JComboBox<>(color);
    private final JComboBox<String> comboParidad = new JComboBox<>(paridad);

    SpinnerNumberModel modeloMonto = new SpinnerNumberModel(100, 0, 1000, 10);
    JSpinner spinnerApuesta = new JSpinner(modeloMonto);

    private int saldoInicial = 1000;



    public VentanaRuleta() {
        configurarFrame();
        configuracionJcombo();
        configuracionJlabel();
        configuracionTxt();
        configuracionBoton();
        addFrame();
        configurarEventos();
    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private void configurarFrame(){
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void addFrame(){
        for (JLabel jLabel : Arrays.asList(lblTipo, lblColor, lblMonto, lblParidad)) frame.add(jLabel);
        for (JComboBox<String> stringJComboBox : Arrays.asList(comboTipo, comboColor, comboParidad))
            frame.add(stringJComboBox);
        frame.add(spinnerApuesta);
        frame.add(btnGirar);
        frame.add(txtSaldo);
        frame.add(lblResultado);
    }
    private void configuracionJcombo(){

        comboTipo.setBounds(350, 50, 500, 30);
        comboColor.setBounds(350, 125, 500, 30);
        comboParidad.setBounds(350, 200, 500, 30);
        comboParidad.setEnabled(false);

    }
    private void configuracionJlabel(){
        lblTipo.setBounds(200, 45, 200 ,40 );
        lblColor.setBounds(200, 120, 200 ,40 );
        lblParidad.setBounds(200, 195, 200 ,40 );
        lblMonto.setBounds(200, 280, 200 ,40 );
        lblResultado.setBounds(200, 350, 620, 30);
        lblResultado.setFont(new Font("SansSerif", Font.BOLD, 12));
    }
    private void configuracionTxt(){
        txtSaldo.setBounds(700, 285, 150, 30);
        txtSaldo.setEditable(false);
        txtSaldo.setFocusable(false);
    }
    private void configuracionBoton(){
        btnGirar.setBounds(525,285,150,30);
        spinnerApuesta.setBounds(350, 285, 150, 30);
    }
    private void configurarEventos(){
        comboTipo.addActionListener(e -> actualizarEstadoDesplegables());
        btnGirar.addActionListener(e -> ejecutarGiro());
    }
    private void actualizarEstadoDesplegables() {
        String seleccion = (String) comboTipo.getSelectedItem();
        if ("Color".equalsIgnoreCase(seleccion)) {
            comboColor.setEnabled(true);
            comboParidad.setEnabled(false);
        } else {
            comboColor.setEnabled(false);
            comboParidad.setEnabled(true);
        }
    }
    private void ejecutarGiro() {
        int monto = (Integer) spinnerApuesta.getValue();
        String tipoApuesta = (String) comboTipo.getSelectedItem();
        String seleccion = obtenerSeleccionActual();

        int numeroSalido = Ruleta.numeroAleatorio();
        boolean acierto = Ruleta.evaluarApuesta(tipoApuesta, seleccion, numeroSalido);
        Ruleta.registrarResultado(numeroSalido, monto, acierto);

        int nuevoSaldo = Ruleta.actualizarSaldo(monto, acierto);
        txtSaldo.setText("Saldo: " + nuevoSaldo);

        mostrarResultado(numeroSalido, seleccion, monto, acierto, nuevoSaldo);
    }

    private String obtenerSeleccionActual() {
        return comboColor.isEnabled()
                ? (String) comboColor.getSelectedItem()
                : (String) comboParidad.getSelectedItem();
    }

    private void mostrarResultado(int numero, String seleccion, int monto, boolean acierto, int saldoActual) {
        String colorNumero = Ruleta.obtenerColorTexto(numero);
        String estado = acierto ? "GANASTE" : "PERDISTE";

        lblResultado.setText(String.format(
                "Número %d (%s) | Apuesta=%s | Monto=$%d | %s | Saldo=%d",
                numero, colorNumero, seleccion, monto, estado, saldoActual
        ));
    }
}