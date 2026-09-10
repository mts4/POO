import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    //--- Lista dinámica de usuarios
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    //--- Componentes de la interfaz gráfica
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JFrame frameRegistro = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistro = new JButton("Registro");


    public VentanaLogin() {
        USUARIOS.add(new Usuario("admin", "1234", "Dueño casino"));
        USUARIOS.add(new Usuario("jugador", "1111", "JugadorPrueba"));

        btnIngresar.addActionListener(e -> login());

        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(350, 180, 100, 30);
        txtUsuario.setBounds(450, 180, 200, 30);

        lblClave.setBounds(350, 230, 100, 30);
        txtClave.setBounds(450, 230, 200, 30);

        btnIngresar.setBounds(400, 290, 200, 40);
        btnRegistro.setBounds(400, 340,200, 40 );

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
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());

        String nombreJugador = validarCredenciales(u, p);

        if (!nombreJugador.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "bienvenido, " + nombreJugador + "!");
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private String validarCredenciales (String u, String p) {
        for (Usuario usuario : USUARIOS) {
            if (usuario.validarCredenciales(u, p)) {
                return usuario.getNombre();
            }
        }
        return "";
    }
    
    private void abrirRegistro() {
        frame.dispose();
        frameRegistro.setLocationRelativeTo(null);
        frameRegistro.setVisible(true);
    }
}
