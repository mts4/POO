package Modelo;

import java.util.Random;

public class Ruleta {
    public static final int CANTIDAD_NUMEROS = 37;
    public static int[] numerosRojos = {
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
    public int numeroAleatorio(){
        return rng.nextInt(CANTIDAD_NUMEROS);
    }
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public static boolean esRojo(int n) {
        for (int numerosRojo : numerosRojos) {
            if (numerosRojo == n) {
                return true;
            }
        }
        return false;
    }
    public static String obtenerColorTexto(int numero) {
        if (numero == 0) return "Verde";
        return esRojo(numero) ? "Rojo" : "Negro";
    }

    public static boolean evaluarApuesta(String tipo, String seleccion, int numeroSalido) {
        if (numeroSalido == 0) {
            return false;
        }

        if ("Color".equalsIgnoreCase(tipo)) {
            boolean esRojoNum = esRojo(numeroSalido);
            if ("Rojo".equalsIgnoreCase(seleccion)) {
                return esRojoNum;
            } else if ("Negro".equalsIgnoreCase(seleccion)) {
                return !esRojoNum;
            }
        } else {
            boolean esParNum = (numeroSalido % 2 == 0);
            if ("Par".equalsIgnoreCase(seleccion)) {
                return esParNum;
            } else if ("Impar".equalsIgnoreCase(seleccion)) {
                return !esParNum;
            }
        }
        return false;
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