package logico;

import java.util.Date;

class Postulacion {
	private String id;
	private Candidato candidato;
	private Vacante vacante;
	private Date fechaPostulacion;
	private EstadoPostulacion estado;
	private String comentarios;

	public Postulacion(String id, Candidato candidato, Vacante vacante, Date fechaPostulacion, EstadoPostulacion estado,
			String comentarios) {
		this.id = id;
		this.candidato = candidato;
		this.vacante = vacante;
		this.fechaPostulacion = fechaPostulacion;
		this.estado = estado;
		this.comentarios = comentarios;
	}

	public String getId() {
		return id;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public Vacante getVacante() {
		return vacante;
	}

	public Date getFechaPostulacion() {
		return fechaPostulacion;
	}

	public EstadoPostulacion getEstado() {
		return estado;
	}

	public String getComentarios() {
		return comentarios;
	}
}