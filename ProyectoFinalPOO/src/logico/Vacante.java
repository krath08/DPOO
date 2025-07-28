package logico;

import java.util.Date;
import java.util.List;

public class Vacante {
    private String id;
    private String titulo;
    private String descripcion;
    private List<String> requisitos; 
    private double salario;
    private empresa empresa;
    private Date fechaPublicacion;
    private boolean abierta;
    private TipoEmpleo tipoEmpleo; 
    private int experienciaRequerida; 

    public Vacante(String id, String titulo, String descripcion, List<String> requisitos, double salario,
                   empresa empresa, Date fechaPublicacion, boolean abierta, TipoEmpleo tipoEmpleo, int experienciaRequerida) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.salario = salario;
        this.empresa = empresa;
        this.fechaPublicacion = fechaPublicacion;
        this.abierta = abierta;
        this.tipoEmpleo = tipoEmpleo;
        this.experienciaRequerida = experienciaRequerida;
    }


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<String> getRequisitos() {
        return requisitos;
    }

    public double getSalario() {
        return salario;
    }

    public empresa getEmpresa() {
        return empresa;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public TipoEmpleo getTipoEmpleo() {
        return tipoEmpleo;
    }

    public int getExperienciaRequerida() {
        return experienciaRequerida;
    }
}
