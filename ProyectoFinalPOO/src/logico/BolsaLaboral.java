package logico;

import java.util.List;

public class BolsaLaboral {
	private List<empresa> empresas;
	private List<Candidato> candidatos;
	private List<Vacante> vacantes;
	private List<Postulacion> postulaciones;

	public BolsaLaboral(List<empresa> empresas, List<Candidato> candidatos, List<Vacante> vacantes,
			List<Postulacion> postulaciones) {
		super();
		this.empresas = empresas;
		this.candidatos = candidatos;
		this.vacantes = vacantes;
		this.postulaciones = postulaciones;
	}
}
