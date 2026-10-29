package Modelo;

public class Resultado {
    private int numero;
    private int monto;
    private boolean acierto;
    private ApuestaBase apuesta;

    public Resultado(int numero, int monto, boolean acierto, ApuestaBase apuesta) {
        this.numero = numero;
        this.monto = monto;
        this.acierto = acierto;
        this.apuesta = apuesta;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    public ApuestaBase getTipo() {
        return apuesta;
    }

    public void setTipo(ApuestaBase tipo) {
        this.apuesta = tipo;
    }
}

