package Controlador;

import Modelo.Resultado;
import Modelo.Ruleta;
import Modelo.TipoApuesta;
import java.util.List;

public class ResultadoController {

    private final SessionController session;

    public ResultadoController(SessionController session){
        this.session = session;
    }


    public String obtenerEstadisticas() {
        List<Resultado> historial = session.getHistorial();
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
}
