package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plan")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPlan;

	@Column(name = "Titulo", nullable = false, length = 47)
	private String Titulo;

	@Column(name = "Descripcion", nullable = false, length = 46)
	private String Descripcion;

	@Column(name = "Costo", nullable = false, length = 46)
	private String Costo;

	@Column(name = "Moneda", nullable = false, length = 45)
	private String Moneda;

	@Column(name = "Duracion", nullable = false, length = 47)
	private String Duracion;

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(int idPlan, String titulo, String descripcion, String costo, String moneda, String duracion) {
		super();
		this.idPlan = idPlan;
		Titulo = titulo;
		Descripcion = descripcion;
		Costo = costo;
		Moneda = moneda;
		Duracion = duracion;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCosto() {
		return Costo;
	}

	public void setCosto(String costo) {
		Costo = costo;
	}

	public String getMoneda() {
		return Moneda;
	}

	public void setMoneda(String moneda) {
		Moneda = moneda;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}
}

