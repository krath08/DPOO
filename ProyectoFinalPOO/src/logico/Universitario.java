package logico;

import java.util.Date;

public class Universitario extends Candidato {
	private String universidad;
	private String carrera;
	private int anioGraduacion;
	private String tituloObtenido;
	private String especialidad;

	public Universitario(String id, String nombre, String apellido, String cedula, String telefono, String email,
			String direccion, Date fechaNacimiento, Date fechaRegistro, String universidad, String carrera,
			int anioGraduacion, String tituloObtenido, String especialidad) {
		super(id, nombre, apellido, cedula, telefono, email, direccion, fechaNacimiento, fechaRegistro);
		this.universidad = universidad;
		this.carrera = carrera;
		this.anioGraduacion = anioGraduacion;
		this.tituloObtenido = tituloObtenido;
		this.especialidad = especialidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getAnioGraduacion() {
		return anioGraduacion;
	}

	public String getTituloObtenido() {
		return tituloObtenido;
	}

	public String getEspecialidad() {
		return especialidad;
	}
}
