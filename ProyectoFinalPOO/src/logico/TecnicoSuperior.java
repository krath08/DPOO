package logico;

import java.util.Date;
import java.util.List;

public class TecnicoSuperior extends Candidato {
	private String instituto;
	private String especialidad;
	private int anioGraduacion;
	private List<String> certificaciones;

	public TecnicoSuperior(String id, String nombre, String apellido, String cedula, String telefono, String email,
			String direccion, Date fechaNacimiento, Date fechaRegistro, String instituto, String especialidad,
			int anioGraduacion, List<String> certificaciones) {
		super(id, nombre, apellido, cedula, telefono, email, direccion, fechaNacimiento, fechaRegistro);
		this.instituto = instituto;
		this.especialidad = especialidad;
		this.anioGraduacion = anioGraduacion;
		this.certificaciones = certificaciones;
	}

	public String getInstituto() {
		return instituto;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getAnioGraduacion() {
		return anioGraduacion;
	}

	public List<String> getCertificaciones() {
		return certificaciones;
	}
}
