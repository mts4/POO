package Modelo;

public class ApuestaImpar extends ApuestaBase {
    public ApuestaImpar() {
        super("IMPAR");
    }

    @Override
    public boolean acierto(int numero, String color) {
        if (numero == 0) {
            return false;
        }

        if (numero % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}