import javax.swing.*;

    public class VentanaSaludo {

        private final JFrame frame = new JFrame("Bienvenida - Casino Black Cat");
        private final JLabel lblBienvenida = new JLabel("Bienvenido");
        private final JButton btnJugar = new JButton("Jugar");

        public VentanaSaludo(String usuario) {

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

        private void jugar() {
            frame.dispose();
        }
    }