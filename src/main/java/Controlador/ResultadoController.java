package Controlador;

import Modelo.Resultado;
import Modelo.TipoApuesta;
import java.util.ArrayList;
import java.util.List;

public class ResultadoController {
    private static final int MAX_HISTORIAL = 100;
    private final List<Resultado> historial;

    public ResultadoController() {
        this.historial = new ArrayList<>();
    }
}
