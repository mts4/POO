package Controlador;

import Modelo.ApuestaBase;
import Modelo.Resultado;
import Modelo.Ruleta;

public class RuletaController {
    private final Ruleta ruleta;
    private final SessionController session;

    public RuletaController(SessionController session) {
        this.ruleta = new Ruleta(1000);
        this.session = session;
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

    public Resultado realizarApuesta(ApuestaBase apuesta, int monto) {
        if (monto <= 0 || monto > ruleta.getSaldo()) {
            return null;
        }

        int numeroSalido = ruleta.numeroAleatorio();
        boolean acierto = ruleta.evaluarApuesta(numeroSalido, apuesta);
        ruleta.actualizarSaldo(monto, acierto);

        Resultado resultado = new Resultado(numeroSalido, monto, acierto, apuesta);

        session.registrarResultado(resultado);

        return new Resultado(numeroSalido, monto, acierto, apuesta);
    }
}