package Controlador;

import Modelo.Resultado;
import Modelo.Ruleta;

import java.util.List;

public class ResultadoController {

    private final SessionController session;

    int ronda = 0;
    int montoTotal = 0;

    public ResultadoController(SessionController session){
        this.session = session;
    }


    public String obtenerHistorial() {
        List<Resultado> historial = session.getHistorial();
        if (historial.isEmpty()) {
            return "Aún no se han jugado rondas en esta sesión.";
        }

        String texto = "=== HISTORIAL DE JUGADAS DE " + session.getNombreUsuario() + " ===\n\n";

        for (Resultado r : historial) {
            ronda = ronda + 1;
            texto = texto + "Jugada " + ronda + ":\n";
            texto = texto + " - Número salido : " + r.getNumero() + "\n";
            texto = texto + " - Tipo apuesta  : " + r.getTipo() + "\n";
            texto = texto + " - Monto apostado: $" + r.getMonto() + "\n";

            if (r.isAcierto()) {
                texto = texto + " - Resultado     : RONDA GANADA\n";
                montoTotal += r.getMonto();
            } else {
                texto = texto + " - Resultado     : RONDA PERDIDA\n";
                montoTotal -= r.getMonto();
            }
            texto = texto + "--------------------------------------\n";

        }
        texto = texto + "SALDO ACTUAL: " + session.getRuletaController().getSaldo() + " | BALANCE: " + montoTotal + " | RONDAS JUGADAS: " + ronda +  "\n";
        ronda = 0;
        return  texto;
    }
}
