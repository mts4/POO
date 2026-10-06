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
    public int getSaldo() {
        return ruleta.getSaldo();
    }

    public boolean depositar(int monto) {
        return ruleta.depositar(monto);
    }

    public String obtenerColorTexto(int numero) {
        return ruleta.obtenerColorTexto(numero);
    }


}