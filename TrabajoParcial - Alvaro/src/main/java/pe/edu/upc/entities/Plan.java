package pe.edu.upc.entities;

import java.util.Objects;

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


	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(int idPlan, String titulo, String descripcion, String costo, String moneda) {
		super();
		this.idPlan = idPlan;
		this.Titulo = titulo;
		this.Descripcion = descripcion;
		this.Costo = costo;
		this.Moneda = moneda;
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

	@Override
	public int hashCode() {
		return Objects.hash(idPlan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		return idPlan == other.idPlan;
	}
	
	
}

