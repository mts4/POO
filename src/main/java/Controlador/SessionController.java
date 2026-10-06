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
}