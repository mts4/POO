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

    public void registrarResultado(int numero, int monto, boolean acierto, TipoApuesta tipo) {
        if (historial.size() < MAX_HISTORIAL) {
            historial.add(new Resultado(numero, monto, acierto, tipo));
        }
    }

    public List<Resultado> getHistorial() {
        return historial;
    }
    public String obtenerEstadisticas() {
        if (historial.isEmpty()) {
            return "Aún no se han jugado rondas en esta sesión.";
        }

        int totalAciertos = 0;
        int totalGanancia = 0;
        int montoTotal = 0;

        for (Resultado r : historial) {
            int apuesta = r.getMonto();
            montoTotal += apuesta;

            if (r.isAcierto()) {
                totalAciertos++;
                totalGanancia += apuesta;
            } else {
                totalGanancia -= apuesta;
            }
        }

        String balance = (totalGanancia >= 0)
                ? "Ganancia neta              : +$" + totalGanancia
                : "Pérdida neta               : -$" + Math.abs(totalGanancia);

        return "=== ESTADÍSTICAS DE JUEGO ===\n\n" +
                "Cantidad de rondas jugadas : " + historial.size() + "\n" +
                "Monto total apostado       : $" + montoTotal + "\n" +
                "Cantidad total de aciertos : " + totalAciertos + "\n" +
                balance;
    }
    public void limpiarHistorial() {
        historial.clear();
    }
}
