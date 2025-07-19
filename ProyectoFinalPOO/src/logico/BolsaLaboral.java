package logico;

import java.util.ArrayList;
import java.util.List;

public class BolsaLaboral {
	private static BolsaLaboral instancia;
	private List<empresa> empresas;
	private List<Candidato> candidatos;
	private List<Vacante> vacantes;
	private List<Postulacion> postulaciones;

	private BolsaLaboral() {
		empresas = new ArrayList<>();
		candidatos = new ArrayList<>();
		vacantes = new ArrayList<>();
		postulaciones = new ArrayList<>();
	}

	public static BolsaLaboral getInstancia() {
		if (instancia == null)
			instancia = new BolsaLaboral();
		return instancia;
	}

	public void agregarEmpresa(empresa e) {
		empresas.add(e);
	}

	public void agregarCandidato(Candidato c) {
		candidatos.add(c);
	}

	public int getCantidadEmpresasActivas() {
		int count = 0;
		for (empresa e : empresas) {
			if (e.isActiva())
				count++;
		}
		return count;
	}

	public int getCantidadCandidatos() {
		return candidatos.size();
	}

	public int getCantidadVacantesAbiertas() {
		int count = 0;
		for (Vacante v : vacantes) {
			if (v.isActiva())
				count++;
		}
		return count;
	}

	public int getCantidadPostulacionesPendientes() {
	    int count = 0;
	    for (Postulacion p : postulaciones) {
	        if (p.getEstado() == EstadoPostulacion.PENDIENTE) {
	            count++;
	        }
	    }
	    return count;
	}

}
