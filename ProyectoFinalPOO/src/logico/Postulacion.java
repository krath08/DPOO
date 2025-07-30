package logico;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Postulacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private Candidato candidato;
	private Vacante vacante;
	private Date fechaPostulacion;
	private EstadoPostulacion estado;
	private String comentarios;
	private List<String> requisitosCumplidos;

	public Postulacion(String id, Candidato candidato, Vacante vacante, Date fechaPostulacion, EstadoPostulacion estado,
			String comentarios, List<String> requisitosCumplidos) {
		this.id = id;
		this.candidato = candidato;
		this.vacante = vacante;
		this.fechaPostulacion = fechaPostulacion;
		this.estado = estado;
		this.comentarios = comentarios;
	    this.requisitosCumplidos = requisitosCumplidos;

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
	public List<String> getRequisitosCumplidos() {
	    return requisitosCumplidos;
	}
}