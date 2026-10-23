package Controlador;

import Modelo.Resultado;
import java.util.List;
import Modelo.*;

public class ResultadoController {
    private final SessionController session;

    public ResultadoController(SessionController session) {
        this.session = session;
    }

    public List<Resultado> obtenerHistorial() {
        return session.getHistorial();
    }

	public Estadisticas obtenerEstadisticas() {
		// TODO - implement ResultadoController.obtenerEstadisticas
		throw new UnsupportedOperationException();
	}
}