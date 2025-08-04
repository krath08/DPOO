package logico;

import java.io.Serializable;
import java.util.Date;

public class empresa implements Serializable {
    private static final long serialVersionUID = 1L;
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
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

	public void setId(String text) {
		// TODO Auto-generated method stub
		
	}

   
}
