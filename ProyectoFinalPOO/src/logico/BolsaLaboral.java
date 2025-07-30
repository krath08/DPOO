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
    
    public void agregarVacante(Vacante v) {
        vacantes.add(v);
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
            if (v.isAbierta())
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

    public List<empresa> getEmpresas() {
        return empresas;
    }

    public empresa buscarEmpresaPorNombre(String nombre) {
        for (empresa e : empresas) {
            if (e.getNombre().equals(nombre))
                return e;
        }
        return null;
    }
    public Candidato buscarCandidatoPorUsuario(String usuario, String contrasena) {
        for (Candidato c : candidatos) {
            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contrasena))
                return c;
        }
        return null;
    }
    public empresa buscarEmpresaPorUsuario(String usuario, String contrasena) {
        for (empresa e : empresas) {
            if (e.getUsuario().equals(usuario) && e.getContrasena().equals(contrasena))
                return e;
        }
        return null;
    }

}
