package Modelo;

public class Resultado {
    private int numero;
    private int monto;
    private boolean acierto;
    private TipoApuesta tipo;

    public Resultado() {
        this(0, 0, false, TipoApuesta.ROJO);
    }

    public Resultado(int numero, int monto, boolean acierto, TipoApuesta tipo) {
        this.numero = numero;
        this.monto = monto;
        this.acierto = acierto;
        this.tipo = tipo;
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

    public TipoApuesta getTipo() {
        return tipo;
    }

    public void setTipo(TipoApuesta tipo) {
        this.tipo = tipo;
    }
}

