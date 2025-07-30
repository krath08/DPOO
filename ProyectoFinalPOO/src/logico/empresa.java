package logico;

import java.util.Date;

public class empresa {
    private String id;
    private String nombre;
    private TipoEmpresa tipo;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaRegistro;
    private boolean activa;
    private String usuario;
    private String contrasena;

    public empresa(String id, String nombre, TipoEmpresa tipo, String direccion, String telefono, String email,
                   Date fechaRegistro, boolean activa, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.activa = activa;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public TipoEmpresa getTipo() { return tipo; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public boolean isActiva() { return activa; }
    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
}
