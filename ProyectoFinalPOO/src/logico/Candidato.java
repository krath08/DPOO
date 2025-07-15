package logico;

import java.util.Date;

public abstract class Candidato {
	private String id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String email;
	private String direccion;
	private Date fechaNacimiento;
	private Date fechaRegistro;
	public Candidato(String id, String nombre, String apellido, String cedula, String telefono, String email,
			String direccion, Date fechaNacimiento, Date fechaRegistro) {
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
}
