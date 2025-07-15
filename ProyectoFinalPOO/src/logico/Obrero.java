package logico;

import java.util.Date;
import java.util.List;

public class Obrero extends Candidato {
	private String oficio;
	private int aniosExperiencia;
	private List<String> herramientas;
	private List<String> certificacionesLaborales;

	public Obrero(String id, String nombre, String apellido, String cedula, String telefono, String email,
			String direccion, Date fechaNacimiento, Date fechaRegistro, String oficio, int aniosExperiencia,
			List<String> herramientas, List<String> certificacionesLaborales) {
		super(id, nombre, apellido, cedula, telefono, email, direccion, fechaNacimiento, fechaRegistro);
		this.oficio = oficio;
		this.aniosExperiencia = aniosExperiencia;
		this.herramientas = herramientas;
		this.certificacionesLaborales = certificacionesLaborales;
	}

	public String getOficio() {
		return oficio;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public List<String> getHerramientas() {
		return herramientas;
	}

	public List<String> getCertificacionesLaborales() {
		return certificacionesLaborales;
	}
}
