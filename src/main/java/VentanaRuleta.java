import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VentanaRuleta {

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JLabel lblColor = new JLabel("Seleccione color:");
    private final JLabel lblParidad = new JLabel("Seleccione paridad:");
    private final JLabel lblMonto = new JLabel("Monto:");
    private final JButton btnGirar = new JButton("Girar");
    private final JTextArea txtMensaje = new JTextArea("");


    String[] tipo = {"Color", "Numero"};
    String[] color = {"Rojo", "Negro"};
    String[] paridad = {"Par", "Impar"};

    private final JComboBox<String> comboTipo = new JComboBox<>(tipo);
    private final JComboBox<String> comboColor = new JComboBox<>(color);
    private final JComboBox<String> comboParidad = new JComboBox<>(paridad);

    SpinnerNumberModel modeloMonto = new SpinnerNumberModel(100, 0, 1000, 10);
    JSpinner spinnerApuesta = new JSpinner(modeloMonto);



    public VentanaRuleta() {
        configurarFrame();
        displayJcombo();
        displayJlabel();
        displayBoton();
        addFrame();
        montoApuesta();
        spinnerApuesta.setBounds(350, 285, 150, 30);
        txtMensaje.setBounds(700, 285, 150, 30);
        btnGirar.setBounds(550,285,150,30);

    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void configurarFrame(){
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    public void addFrame(){
        for (JLabel jLabel : Arrays.asList(lblTipo, lblColor, lblMonto, lblParidad)) frame.add(jLabel);
        for (JComboBox<String> stringJComboBox : Arrays.asList(comboTipo, comboColor, comboParidad))
            frame.add(stringJComboBox);
        frame.add(spinnerApuesta);
        frame.add(btnGirar);
        frame.add(txtMensaje);
    }
    public void displayJcombo(){

        comboTipo.setBounds(350, 50, 500, 30);
        comboColor.setBounds(350, 125, 500, 30);
        comboParidad.setBounds(350, 200, 500, 30);

    }
    public void displayJlabel(){
        lblTipo.setBounds(200, 45, 200 ,40 );
        lblColor.setBounds(200, 120, 200 ,40 );
        lblParidad.setBounds(200, 195, 200 ,40 );
        lblMonto.setBounds(200, 280, 200 ,40 );

        txtMensaje.setBounds(200, 240, 600, 180);
        txtMensaje.setEditable(false);
        txtMensaje.setFont(new Font("Monospaced", Font.BOLD, 13));
    }
    public void displayBoton(){
        btnGirar.setBounds(550,285,150,30);
    }
    public void montoApuesta(){

    }

}