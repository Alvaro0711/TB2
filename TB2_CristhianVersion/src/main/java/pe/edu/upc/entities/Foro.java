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
@Table(name = "Foro")
public class Foro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idForo;

	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria cate;
	@ManyToOne
	@JoinColumn(name = "idPsicologo", nullable = false)
	private Psicologo psico;
	
	
	@Column(name = "Titulo", nullable = false, length = 100)
	private String tit;
	@Column(name = "Asunto", nullable = false, length = 100)
	private String asun
	;@Column(name = "Contenido", nullable = false, length = 1000)
	private String conten;
	@Column(name = "FechaPost", nullable = false)
	private Date fechaposteo;
	
	
	public Foro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Foro(int idForo, Categoria cate, Psicologo psico, String tit, String asun, String conten,
			Date fechaposteo) {
		super();
		this.idForo = idForo;
		this.cate = cate;
		this.psico = psico;
		this.tit = tit;
		this.asun = asun;
		this.conten = conten;
		this.fechaposteo = fechaposteo;
	}


	public int getIdForo() {
		return idForo;
	}


	public void setIdForo(int idForo) {
		this.idForo = idForo;
	}


	public Categoria getCate() {
		return cate;
	}


	public void setCate(Categoria cate) {
		this.cate = cate;
	}


	public Psicologo getPsico() {
		return psico;
	}


	public void setPsico(Psicologo psico) {
		this.psico = psico;
	}


	public String getTit() {
		return tit;
	}


	public void setTit(String tit) {
		this.tit = tit;
	}


	public String getAsun() {
		return asun;
	}


	public void setAsun(String asun) {
		this.asun = asun;
	}


	public String getConten() {
		return conten;
	}


	public void setConten(String conten) {
		this.conten = conten;
	}


	public Date getFechaposteo() {
		return fechaposteo;
	}


	public void setFechaposteo(Date fechaposteo) {
		this.fechaposteo = fechaposteo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idForo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foro other = (Foro) obj;
		return idForo == other.idForo;
	}
	
}
