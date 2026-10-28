package Modelo;

public class ApuestaPar extends ApuestaBase {
    public ApuestaPar() {
        super("PAR");
    }

    @Override
    public boolean acierto(int numero, String color) {
        if (numero == 0) {
            return false;
        }

        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}