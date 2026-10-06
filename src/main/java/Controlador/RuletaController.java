package Controlador;

import Modelo.Resultado;
import Modelo.Ruleta;
import Modelo.TipoApuesta;

public class RuletaController {
    private final Ruleta ruleta;
    private final ResultadoController resultadoController;

    public RuletaController(ResultadoController resultadoController) {
        this.ruleta = new Ruleta(1000);
        this.resultadoController = resultadoController;
    }
}