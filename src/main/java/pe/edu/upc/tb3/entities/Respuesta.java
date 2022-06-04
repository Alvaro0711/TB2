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
@Table(name = "Respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespuesta;

	@ManyToOne
	@JoinColumn(name = "idForo", nullable = false)
	private Foro foro;
	
	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false)
	private Paciente paciente;
		
	@Column(name = "Asunto", nullable = false, length = 100)
	private String Asunto;
	
	@Column(name = "Contenido", nullable = false, length = 1000)
	private String Contenido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaPost", nullable = false)
	private Date FechaPost;

	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Respuesta(int idRespuesta, Foro foro, Paciente paciente, String asunto, String contenido, Date fechaPost) {
		super();
		this.idRespuesta = idRespuesta;
		this.foro = foro;
		this.paciente = paciente;
		Asunto = asunto;
		Contenido = contenido;
		FechaPost = fechaPost;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String asunto) {
		Asunto = asunto;
	}

	public String getContenido() {
		return Contenido;
	}

	public void setContenido(String contenido) {
		Contenido = contenido;
	}

	public Date getFechaPost() {
		return FechaPost;
	}

	public void setFechaPost(Date fechaPost) {
		FechaPost = fechaPost;
	}
}
