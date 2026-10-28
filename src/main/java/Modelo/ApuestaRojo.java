package Modelo;

public class ApuestaRojo extends ApuestaBase {
    public ApuestaRojo() {
        super("ROJO");
    }

    @Override
    public boolean acierto(int numero, String color) {
        if (numero == 0) {
            return false;
        }
        if (color == "Rojo") {
            return true;
        } else {
            return false;
        }
    }
}