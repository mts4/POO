package Modelo;

public class ApuestaNegro extends ApuestaBase {
    public ApuestaNegro() {
        super("NEGRO");
    }

    @Override
    public boolean acierto(int numero, String color) {
        if (numero == 0) {
            return false;
        }

        if (color == "Negro") {
            return true;
        } else {
            return false;
        }
    }
}