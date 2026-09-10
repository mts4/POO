import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {
    //--- Lista dinámica de usuarios
    public static final List USUARIOS = new ArrayList<>();

    //--- Componentes de la interfaz gráfica
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario: ");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");


    public VentanaLogin() {
        USUARIOS.add(new Usuario("admin", "1234", "Don Donnie"));
        USUARIOS.add(new Usuario("jugador", "1111", "JugadorPrueba"));

        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(350, 180, 100, 30);
        txtUsuario.setBounds(450, 180, 200, 30);

        lblClave.setBounds(350, 230, 100, 30);
        txtClave.setBounds(450, 230, 200, 30);

        btnIngresar.setBounds(400, 290, 200, 40);

        frame.setLayout(null);
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(new JLabel(""));
        frame.add(btnIngresar);

    }


    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Gestiona el inicio de sesión al presionar el botón.
     * Debe validar las credenciales ingresadas y abrir la siguiente
     * ventana o mostrar un mensaje de error.
     */
    private void login() {
        // TODO: Implementar la lógica de inicio de sesión
    }

    /**
     * Valida las credenciales ingresadas utilizando la lista de usuarios.
     *
     * @param u nombre de usuario ingresado
     * @param p contraseña ingresada
     * @return el nombre del usuario si las credenciales son válidas o una cadena vacía
     * si no existe una coincidencia
     */
    private String validarCredenciales (String u, String p) {
        // TODO: Recorrer la lista y validar las credenciales
        return "";
    }

    /**
     * Abre la ventana de registro para crear un nuevo usuario.
     * Debe cerrar la ventana actual e invocar a VentanaRegistro.
     */
    private void abrirRegistro() {
        // TODO: Cerrar la ventana actual y abrir la ventana de registro
    }
}