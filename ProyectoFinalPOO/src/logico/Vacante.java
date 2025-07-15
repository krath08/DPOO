package logico;

import java.util.Date;

public class Vacante {
	private String id;
	private String titulo;
	private String descripcion;
	private String requisitos;
	private double salario;
	private Date fechaPublicacion;
	private Date fechaVencimiento;
	private boolean activa;
	private empresa empresa;

	public Vacante(String id, String titulo, String descripcion, String requisitos, double salario,
			Date fechaPublicacion, Date fechaVencimiento, boolean activa, empresa empresa) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.salario = salario;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaVencimiento = fechaVencimiento;
		this.activa = activa;
		this.empresa = empresa;
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

	public String getRequisitos() {
		return requisitos;
	}

	public double getSalario() {
		return salario;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public boolean isActiva() {
		return activa;
	}

	public empresa getempresa() {
		return empresa;
	}
}
