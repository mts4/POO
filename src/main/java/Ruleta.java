import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    public static final int CANTIDAD_NUMEROS = 37;
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static int iterador = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos = {
            1, 3, 5, 7, 9, 12, 14, 16, 18,
            19, 21, 23,
            25, 27, 30, 32, 34, 36
    };


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        do {
            mostrarMenu();

            opcionElegida = leerOpcion(teclado);

            ejecutarOpcion(opcionElegida, teclado);

        }
        while (opcionElegida != 3);
    }

    public static void mostrarMenu() {
        System.out.println("**MENU** \n SELECCIONE UNA OPCION INGRESANDO EL NUMERO ASOCIADO \n " +
                "1. INICIAR RONDA\n 2. VER ESTADISTICAS \n 3. SALIR ");
    }

    public static int leerOpcion (Scanner in) {
        int opcion = in.nextInt();
        return opcion;
    }

    public static void ejecutarOpcion(int opcion, Scanner in) {
        switch (opcion) {
                case 1:
                    iniciarRonda(in);
                    break;
                case 2:
                    mostrarEstadisticas();
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
                    break;
            }
        }

    public static void iniciarRonda (Scanner in) {
        char tipo = leerTipoApuesta(in);
        System.out.print("Cuanto desea apostar: ");
        int monto = in.nextInt();
        int numero = girarRuleta();
        boolean resultadoEvaluado = evaluarResultado(numero, tipo);
        registrarResultado(numero,monto,resultadoEvaluado);
        mostrarResultado(numero, tipo, monto, resultadoEvaluado);
    }
    public static char leerTipoApuesta (Scanner in) {
        boolean controlCiclo = true;
        char tipoApuesta;
        do {
            System.out.print("escriba la primera letra en mayuscula de la opcion para seleccionarla \n" +
                    "**SELECCIONE TIPO DE APUESTA:** \n P - PAR \n I - IMPAR \n R- ROJO \n N - Negro");
            tipoApuesta = in.next().charAt(0);
            if (tipoApuesta == 'R' || tipoApuesta == 'N' || tipoApuesta == 'P' || tipoApuesta == 'I') {
                controlCiclo = false;
            } else {
                System.out.println("Opción no válida. Ingrese R, N, P o I.");
            }
           } while(controlCiclo);
           return tipoApuesta;
    }
    public static int girarRuleta() {
     int numeroGanador= rng.nextInt(CANTIDAD_NUMEROS);
        return numeroGanador;
    }


    public static boolean evaluarResultado (int numero, char tipo) {
        if (numero == 0) {
            return false;
        }
        switch (tipo) {
            case 'R':
                return esRojo(numero);

            case 'N':
                return !esRojo(numero);

            case 'P':
                return (numero % 2 == 0);

            case 'I':
                return (numero % 2 != 0);

            default:
                return false;
        }
    }


    public static boolean esRojo(int n) {
        for (int i = 0; i < numerosRojos.length; i++) {
            if (numerosRojos[i] == n) {
                return true;
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
            System.out.println("historial está lleno. no se guardaran resultados");
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

    public static void mostrarEstadisticas() {
        int totalAciertos = 0;
        int totalGanancia = 0;
        int montoTotal = 0;
        if (historialSize == 0) {
            System.out.println("Aún no se han jugado rondas.\n");
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