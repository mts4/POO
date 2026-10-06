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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.isBlank()) {
            this.username = username.trim();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.isBlank()) {
            this.password = password;
        }
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre.trim();
            return true;
        }
        return false;
    }
}