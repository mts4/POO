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
}

