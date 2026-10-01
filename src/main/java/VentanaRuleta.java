import javax.swing.*;

public class VentanaRuleta {

    private final JFrame frame = new JFrame("Ruleta - Casino Black Cat");
    private final JLabel lblTipo = new JLabel("Tipo de apuesta:");
    private final JLabel lblColor = new JLabel("Seleccione color:");
    private final JLabel lblParidad = new JLabel("Seleccione paridad:");
    private final JLabel lblMonto = new JLabel("Monto:");
    private final JButton btnGirar = new JButton("Girar");

    String[] tipo = {"Color", "Numero"};
    String[] color = {"Rojo", "Negro"};
    String[] paridad = {"Par", "Impar"};




    public VentanaRuleta() {
        crearJcombo();
    }
    public void mostrarVentana() {
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
    }
    public void crearJcombo(){
        JComboBox<String> comboTipo = new JComboBox<>(tipo);
        JComboBox<String> comboColor = new JComboBox<>(color);
        JComboBox<String> comboParidad = new JComboBox<>(paridad);
    }
    public void montoApuesta(){
        SpinnerNumberModel modeloMonto = new SpinnerNumberModel(100, 0, 1000, 10);
        JSpinner spinnerApuesta = new JSpinner(modeloMonto);
    }

}