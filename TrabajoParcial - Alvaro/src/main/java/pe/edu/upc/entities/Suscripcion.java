package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Suscripcion")

public class Suscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSus;
	
	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "idPlan", nullable = false)
	private Plan plan;
	
	@Column(name = "Fecha", nullable = false, length = 47)
	private Date Fecha;
	
	@Column(name = "Meses", nullable = false, length = 47)
	private String Meses;
	
	public Suscripcion(int idSus, Paciente paciente, Plan plan, Date fecha, String meses) {
		super();
		this.idSus = idSus;
		this.paciente = paciente;
		this.plan = plan;
		this.Fecha = fecha;
		this.Meses = meses;
	}

	public Suscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSus() {
		return idSus;
	}

	public void setIdSus(int idSus) {
		this.idSus = idSus;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getMeses() {
		return Meses;
	}

	public void setMeses(String meses) {
		Meses = meses;
	}
	
}
