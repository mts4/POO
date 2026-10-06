package Modelo;

import java.util.Random;

public class Ruleta {
    public static final int CANTIDAD_NUMEROS = 37;
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int saldo = 1000;
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23,
            25, 27, 30, 32, 34, 36
    };


    public static int numeroAleatorio(){
        return rng.nextInt(CANTIDAD_NUMEROS);
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

    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        } else {
            System.out.println("El historial está lleno. No se guardarán más resultados.");
        }
    }

    public static void mostrarResultado (int numero, char tipo, int monto, boolean acierto) {
        System.out.println("Número que salió : " + numero);
        if (acierto) {
            monto = monto;
            System.out.println("Resultado: Has ganado $" + monto);

        } else {
            System.out.println("Resultado: Has perdido $" + monto);
        }
    }
    public static int actualizarSaldo(int monto, boolean acierto) {
        if (acierto) {
            saldo += monto;
        } else {
            saldo -= monto;
        }
        return saldo;
    }

    public static void mostrarEstadisticas() {
        int totalAciertos = 0;
        int totalGanancia = 0;
        int montoTotal = 0;
        int iterador = 0;
        if (historialSize == 0) {
        for (iterador = 0;historialSize > iterador; iterador++) {
            int apuesta =  historialApuestas[iterador];
            montoTotal += apuesta;

            if (historialAciertos[iterador]) {
                totalAciertos += 1;
                totalGanancia += apuesta;
            } else{
                totalGanancia -= apuesta;
            }
        }
            System.out.println("Cantidad de rondas jugadas : " + historialSize);
            System.out.println("Monto total apostado       : $" + montoTotal);
            System.out.println("Cantidad total de aciertos : " + totalAciertos);

            if (totalGanancia >= 0) {
                System.out.println("Ganancia neta              : +$" + totalGanancia);
            } else {
                System.out.println("Pérdida neta               : -$" + Math.abs(totalGanancia));
            }

    }
}
}