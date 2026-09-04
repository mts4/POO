import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    public static final int CANTIDAD_NUMEROS = 37;
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean [MAX_HISTORIAL];
    public static int historialSize = 0;
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
        mostrarResultado(numero, tipo, monto, resultadoEvaluado);
    }
    public static char leerTipoApuesta (Scanner in) {
       System.out.print("escriba la primera letra en mayuscula de la opcion para seleccionarla \n" +
               "**SELECCIONE TIPO DE APUESTA:** \n P - PAR \n I - IMPAR \n R- ROJO \n N - Negro");
        char tipoApuesta = in.next().charAt(0);
        return tipoApuesta;
    }

    public static int girarRuleta() {
     int numeroGanador= rng.nextInt(CANTIDAD_NUMEROS);
        return numeroGanador;
    }

    /**
     * Evalúa si la apuesta realizada por el jugador
     * fue acertada.
     *
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta elegida.
     * @return true si acertó, false si perdió.
     */
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

    /**
     * Registra los resultados de la ronda en los arreglos
     * de historial.
     *
     * @param numero número obtenido en la ruleta.
     * @param apuesta monto apostado.
     * @param acierto si el jugador acerto o no.
     */
    public static void registrarResultado (int numero, int apuesta, boolean acierto) {
        // TODO: Guardar los datos sin superar MAX_HISTORIAL.
    }

    /**
     * Muestra en consola el resultado de la ronda.
     *
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta realizada.
     * @param monto monto apostado.
     * @param acierto si el jugador ganó o perdió.
     */
    public static void mostrarResultado (int numero, char tipo, int monto, boolean acierto) {
        System.out.println("Número que salió : " + numero);
        if (acierto) {
            monto = monto
            System.out.println("Resultado: Has ganado $" + monto);
        } else {
            System.out.println("Resultado: Has perdido $" + monto);
        }
    }

    /**
     * Muestra estadísticas generales de todas las
     * rondas jugadas.
     */
    public static void mostrarEstadisticas() {
        // TODO: Calcular y mostrar las estadísticas acumuladas.
    }
}