package Controlador;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class SessionController {
    private final List<Usuario> usuarios;
    private Usuario usuarioActual;
    private RuletaController ruletaController;
    private ResultadoController resultadoController;

    public SessionController() {
        this.usuarios = new ArrayList<>();
        this.usuarios.add(new Usuario("admin", "1234", "Dueño casino"));
        this.usuarios.add(new Usuario("jugador", "1111", "JugadorPrueba"));

        this.resultadoController = new ResultadoController();
        this.ruletaController = new RuletaController(this.resultadoController);
    }

    public void registrarUsuario(String usuario, String clave, String nombre) {
        if (usuario == null || usuario.isBlank() ||
                clave == null || clave.isBlank() ||
                nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Datos requeridos");
        }
        Usuario nuevo = new Usuario(usuario.trim(), clave.trim(), nombre.trim());
        usuarios.add(nuevo);
        usuarioActual = nuevo;
    }

    public boolean iniciarSesion(String usuario, String clave) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(usuario, clave)) {
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }
    public boolean hayUsuario() {
        return usuarioActual != null;
    }

    public String getNombreUsuario() {
        return hayUsuario() ? usuarioActual.getNombre() : "";
    }

    public boolean actualizarNombreUsuario(String nuevoNombre) {
        if (hayUsuario()) {
            return usuarioActual.setNombre(nuevoNombre);
        }
        return false;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public RuletaController getRuletaController() {
        return ruletaController;
    }

    public ResultadoController getResultadoController() {
        return resultadoController;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}