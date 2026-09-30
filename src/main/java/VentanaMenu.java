import javax.swing.*;
import java.awt.*;

public class VentanaMenu {
        private final JFrame frame = new JFrame("Menu - Casino Black Cat");
        private final JLabel lblBienvenida = new JLabel("Bienvenido");

        private final JButton btnJugar = new JButton("Jugar");
        private final JButton btnIniciar = new JButton("Iniciar");
        private final JButton btnHistorial = new JButton("Historial");
        private final JButton btnSalir = new JButton("Salir");

        private final JPanel panelMensaje = new JPanel();
        private final JPanel panelBotones = new JPanel();

        private final Dimension tamanoBoton = new Dimension(200, 40);

        public VentanaMenu(String usuario) {
            configurarFrame();
            configurarBotones();
            configurarPanelBotones();
            configurarPanelMensaje();

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

            frame.add(panelMensaje);
            frame.add(panelBotones);
        }
        private void configurarBotones(){
            for (JButton botonNombre : new JButton[]{btnIniciar, btnJugar, btnHistorial, btnSalir}) {
                asignarDimBotones(botonNombre);
                centrarBotones(botonNombre);
            }
        }
        private void asignarDimBotones(JButton nombreBoton){
            nombreBoton.setPreferredSize(tamanoBoton);
            nombreBoton.setMaximumSize(tamanoBoton);
        }
        private void centrarBotones(JButton nombreBoton) {
            nombreBoton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        private void configurarPanelMensaje() {
            panelMensaje.setLayout(null);
            panelMensaje.add(lblBienvenida);
            panelMensaje.setBorder(BorderFactory.createLineBorder(Color.RED));
            panelMensaje.setBounds(400, 50, 590, 350);
        }
        private void configurarPanelBotones() {
            panelBotones.setBounds(10, 50, 380, 350);
            panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
            panelBotones.setBorder(BorderFactory.createLineBorder(Color.BLUE));

            panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));

            agregarBotonConMargen(btnIniciar);
            agregarBotonConMargen(btnJugar);
            agregarBotonConMargen(btnHistorial);
            agregarBotonConMargen(btnSalir);
        }

        private void agregarBotonConMargen(JButton boton) {
            panelBotones.add(boton);
            panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        private void asignarAcciones(){
            btnJugar.addActionListener(e -> jugar());
        }



        private void jugar() {
            frame.dispose();
        }
    }