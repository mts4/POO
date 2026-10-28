package Modelo;

public abstract class ApuestaBase {
    private String tipoApuesta;

    public ApuestaBase(String tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public abstract boolean acierto(int numero, String color);
}