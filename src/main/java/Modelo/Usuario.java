package Modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;

    public Usuario() {
        this("invitado", "", "Invitado");
    }

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = "Invitado";
        }
    }

    public boolean validarCredenciales (String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String getNombre() {
        return nombre;
    }
}