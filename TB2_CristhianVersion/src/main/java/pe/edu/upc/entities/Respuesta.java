package pe.edu.upc.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Respuesta")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRespuesta;

	@ManyToOne
	@JoinColumn(name = "idForo", nullable = false)
	private Foro foroo;
	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false)
	private Paciente paci;
	
	
	
	@Column(name = "Asunto", nullable = false, length = 100)
	private String asun;
	@Column(name = "Contenido", nullable = false, length = 1000)
	private String conteni;
	@Column(name = "FechaPost", nullable = false)
	private Date fechaposteo;
	
	
	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Respuesta(int idRespuesta, Foro foroo, Paciente paci, String asun, String conteni, Date fechaposteo) {
		super();
		this.idRespuesta = idRespuesta;
		this.foroo = foroo;
		this.paci = paci;
		this.asun = asun;
		this.conteni = conteni;
		this.fechaposteo = fechaposteo;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public Foro getForoo() {
		return foroo;
	}

	public void setForoo(Foro foroo) {
		this.foroo = foroo;
	}

	public Paciente getPaci() {
		return paci;
	}

	public void setPaci(Paciente paci) {
		this.paci = paci;
	}

	public String getAsun() {
		return asun;
	}

	public void setAsun(String asun) {
		this.asun = asun;
	}

	public String getConteni() {
		return conteni;
	}

	public void setConteni(String conteni) {
		this.conteni = conteni;
	}

	public Date getFechaposteo() {
		return fechaposteo;
	}

	public void setFechaposteo(Date fechaposteo) {
		this.fechaposteo = fechaposteo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRespuesta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Respuesta other = (Respuesta) obj;
		return idRespuesta == other.idRespuesta;
	}
	
}
