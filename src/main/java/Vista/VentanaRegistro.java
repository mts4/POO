package Vista;

import Controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;

public class VentanaRegistro {

    private final SessionController session;

    private final JFrame frame = new JFrame("Registro de Usuario - Casino Black Cat");

    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();

    private final JLabel lblClave = new JLabel("Contraseña:");
    private final JPasswordField txtClave = new JPasswordField();

    private final JLabel lblNombre = new JLabel("Nombre Completo:");
    private final JTextField txtNombre = new JTextField();

    private final JButton btnRegistrar = new JButton("Registrar");
    private final JButton btnVolver = new JButton("Volver al Login");

    public VentanaRegistro(SessionController session){
        this.session = session;
        configurarFrame();
        addFrame();
        posicionesElementos();
        asignarAcciones();
    }


    public void mostrarVentana() {

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private void configurarFrame(){
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

    }
    private void addFrame(){
        frame.add(lblUsuario);
        frame.add(txtUsuario);

        frame.add(lblClave);
        frame.add(txtClave);

        frame.add(lblNombre);
        frame.add(txtNombre);

        frame.add(btnRegistrar);
        frame.add(btnVolver);
    }
    private void posicionesElementos(){
        lblUsuario.setBounds(300, 110, 130, 30);
        txtUsuario.setBounds(440, 110, 260, 30);

        lblClave.setBounds(300, 160, 130, 30);
        txtClave.setBounds(440, 160, 260, 30);

        lblNombre.setBounds(300, 210, 130, 30);
        txtNombre.setBounds(440, 210, 260, 30);

        btnRegistrar.setBounds(340, 290, 140, 35);
        btnVolver.setBounds(500, 290, 140, 35);
    }
    private void asignarAcciones() {

        btnRegistrar.addActionListener(e -> registrarUsuario());
        btnVolver.addActionListener(e -> volverLogin());

    }


    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();
        String nombre = txtNombre.getText().trim();

        try {
            session.registrarUsuario(usuario, clave, nombre);
            JOptionPane.showMessageDialog(
                    frame,
                    "¡Registro completado! Ahora puede iniciar sesión.",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            volverLogin();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Por favor, complete todos los campos antes de continuar.",
                    "Campos Incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
    private void volverLogin() {
        frame.dispose();
        new VentanaLogin(session).mostrarVentana();
    }
}
