package logico;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BolsaLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    private static BolsaLaboral instancia;

    private int countIdEmpresa;
    private int countIdVacante;
    private List<empresa> empresas;
    private List<Candidato> candidatos;
    private List<Vacante> vacantes;
    private List<Postulacion> postulaciones;

    private static final String ARCHIVO_EMPRESAS = "empresas.dat";
    private static final String ARCHIVO_CANDIDATOS = "candidatos.dat";
    private static final String ARCHIVO_VACANTES = "vacantes.dat";
    private static final String ARCHIVO_POSTULACIONES = "postulaciones.dat";

    private BolsaLaboral() {
        empresas = cargarLista(ARCHIVO_EMPRESAS);
        candidatos = cargarLista(ARCHIVO_CANDIDATOS);
        vacantes = cargarLista(ARCHIVO_VACANTES);
        postulaciones = cargarLista(ARCHIVO_POSTULACIONES);
    }

    public static BolsaLaboral getInstancia() {
        if (instancia == null)
            instancia = new BolsaLaboral();
        return instancia;
    }

    public void agregarEmpresa(empresa e) {
        empresas.add(e);
        guardarLista(empresas, ARCHIVO_EMPRESAS);
    }

    public void agregarCandidato(Candidato c) {
        candidatos.add(c);
        guardarLista(candidatos, ARCHIVO_CANDIDATOS);
    }

    public void agregarVacante(Vacante v) {
        vacantes.add(v);
        guardarLista(vacantes, ARCHIVO_VACANTES);
    }

    public void agregarPostulacion(Postulacion p) {
        postulaciones.add(p);
        guardarLista(postulaciones, ARCHIVO_POSTULACIONES);
    }

    public List<Postulacion> getPostulaciones() {
        return postulaciones;
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

    public List<Vacante> getVacantes() {
        return vacantes;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
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

    private <T> void guardarLista(List<T> lista, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> cargarLista(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }


    public void eliminarCandidatoPorId(String id) {
        candidatos.removeIf(c -> c.getId().equals(id));
        guardarLista(candidatos, ARCHIVO_CANDIDATOS);
    }

    public void eliminarEmpresaPorId(String id) {
        empresas.removeIf(e -> e.getId().equals(id));
        guardarLista(empresas, ARCHIVO_EMPRESAS);
    }


    public void guardarEmpresas() {
        guardarLista(empresas, ARCHIVO_EMPRESAS);
    }

    public void guardarPostulaciones() {
        guardarLista(postulaciones, ARCHIVO_POSTULACIONES);
    }

    public Vacante buscarVacantePorId(String id) {
        for (Vacante v : vacantes) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }
    
    public Postulacion buscarPostulacionPorId(String id) {
        for (Postulacion p : postulaciones) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }


    public void eliminarVacantePorId(String id) {
        Vacante v = buscarVacantePorId(id);
        if (v != null) {
            vacantes.remove(v);
        }
    }

    public void eliminarPostulacionPorId(String id) {
        postulaciones.removeIf(p -> p.getId().equals(id));
        guardarLista(postulaciones, ARCHIVO_POSTULACIONES);
    }
    
    public void modificarCandidato(Candidato nuevoCandidato) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getId().equals(nuevoCandidato.getId())) {
                candidatos.set(i, nuevoCandidato);
                guardarLista(candidatos, ARCHIVO_CANDIDATOS);
                return;
            }
        }
    }
    public String getNuevoIdEmpresa() {
        int max = -1;
        for (empresa e : empresas) {
            String id = e.getId();
            if (id != null && id.startsWith("E-")) {
                try {
                    int num = Integer.parseInt(id.substring(2));
                    if (num > max) max = num;
                } catch (Exception ex) {}
            }
        }
        return "E-" + (max + 1);
    }

    public String generarIdVacante() {
        String id = "V-" + countIdVacante;
        countIdVacante++;
        return id;
    }


}