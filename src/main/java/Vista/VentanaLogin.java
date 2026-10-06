package Vista;

import Controlador.SessionController;
import javax.swing.*;


public class VentanaLogin {

    private final SessionController session;


    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistro = new JButton("Registro");


    public VentanaLogin(SessionController session) {
        this.session = session;

        btnIngresar.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> abrirRegistro());

        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(350, 140, 100, 30);
        txtUsuario.setBounds(450, 140, 200, 30);

        lblClave.setBounds(350, 190, 100, 30);
        txtClave.setBounds(450, 190, 200, 30);

        btnIngresar.setBounds(400, 250, 200, 40);
        btnRegistro.setBounds(400, 300,200, 40 );

        frame.setLayout(null);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(new JLabel(""));
        frame.add(btnIngresar);
        frame.add(btnRegistro);

    }


    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void login() {
        String u = txtUsuario.getText().trim();
        String p = new String(txtClave.getPassword()).trim();

        boolean ingreso = session.iniciarSesion(u, p);

        if (ingreso) {
            frame.dispose();
            new VentanaMenu(session).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro(session).mostrarVentana();
    }
}
