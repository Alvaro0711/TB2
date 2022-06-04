package pe.edu.upc.tb3.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Suscripcion")
public class Suscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSus;

	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "idPlan", nullable = false)
	private Plan plan;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Fecha", nullable = false)
	private Date Fecha;
	
	@Column(name = "Meses", nullable = false, length = 47)
	private String Meses;

	public Suscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Suscripcion(int idSus, Paciente paciente, Plan plan, Date fecha, String meses) {
		super();
		this.idSus = idSus;
		this.paciente = paciente;
		this.plan = plan;
		this.Fecha = fecha;
		this.Meses = meses;
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
		this.Fecha = fecha;
	}

	public String getMeses() {
		return Meses;
	}

	public void setMeses(String meses) {
		this.Meses = meses;
	}

}
