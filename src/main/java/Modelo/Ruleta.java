package Modelo;

import java.util.Random;

public class Ruleta {
    private static final int CANTIDAD_NUMEROS = 37;
    private static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23,
            25, 27, 30, 32, 34, 36
    };
    private final Random rng;
    private int saldo;

    public Ruleta() {
        this(0);
    }
    public Ruleta(int saldoInicial) {
        this.rng = new Random();
        this.saldo = Math.max(0, saldoInicial);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public int numeroAleatorio(){
        return rng.nextInt(CANTIDAD_NUMEROS);
    }

    public boolean esRojo(int n) {
        for (int numerosRojo : numerosRojos) {
            if (numerosRojo == n) {
                return true;
            }
        }
        return false;
    }
    public String obtenerColorTexto(int numero) {
        if (numero == 0) return "Verde";
        return esRojo(numero) ? "Rojo" : "Negro";
    }

    public boolean evaluarApuesta(int numero, TipoApuesta tipo) {
        if (numero == 0 || tipo == null) return false;

        return switch (tipo) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }
    public int actualizarSaldo(int monto, boolean acierto) {
        if (acierto) {
            saldo += monto;
        } else {
            saldo -= monto;
        }
        return saldo;
    }
}