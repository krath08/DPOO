package logico;

import java.io.Serializable;
import java.util.Date;

public abstract class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String email;
	private String direccion;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	private String usuario;
	private String contrasena;
	public Candidato(String id, String nombre, String apellido, String cedula, String telefono, String email,
			String direccion, Date fechaNacimiento, Date fechaRegistro, String usuario, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public String getDireccion() {
		return direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
