import javax.swing.*;

    public class VentanaMenu {
        private final JFrame frame = new JFrame("Menu - Casino Black Cat");
        private final JLabel lblBienvenida = new JLabel("Bienvenido");

        private final JButton btnJugar = new JButton("Jugar");
        private final JButton btnIniciar = new JButton("Iniciar");
        private final JButton btnHistorial = new JButton("Historial");
        private final JButton btnSalir = new JButton("Salir");

        private final JPanel panelMensaje = new JPanel();
        private final JPanel panelBotones = new JPanel();

        public VentanaMenu(String usuario) {

            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(null);

            lblBienvenida.setText("¡Bienvenido, " + usuario + "!");
            lblBienvenida.setBounds(200, 170, 600, 40);
            lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(lblBienvenida);

            btnJugar.setBounds(420, 240, 160, 40);
            btnJugar.addActionListener(e -> jugar());
            frame.add(btnJugar);
        }
        public void mostrarVentana() {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        private void configurarFrame(){}
        private void configurarBotones(){}
        private void asignarDimBotones(JButton nombreBoton){}
        private void centrarBotones(JButton nombreBoton) {}
        private void crearPanelMensaje() {}
        private void crearPanelBotones() {}
        private void asignarAcciones(){}



        private void jugar() {
            frame.dispose();
        }
    }