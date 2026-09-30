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
            configurarFrame();
            configurarBotones();

            asignarAcciones();


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
            frame.add(btnJugar);
            frame.add(lblBienvenida);
        }
        private void configurarBotones(){
            btnJugar.setBounds(420, 240, 160, 40);
        }
        private void asignarDimBotones(JButton nombreBoton){}
        private void centrarBotones(JButton nombreBoton) {}
        private void configurarPanelMensaje() {}
        private void configurarPanelBotones() {}
        private void asignarAcciones(){
            btnJugar.addActionListener(e -> jugar());
        }



        private void jugar() {
            frame.dispose();
        }
    }