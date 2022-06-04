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
@Table(name = "Foro")
public class Foro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idForo;

	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "idPsicologo", nullable = false)
	private Psicologo psicologo;
	
	
	@Column(name = "Titulo", nullable = false, length = 50)
	private String Titulo;
	
	@Column(name = "Asunto", nullable = false, length = 100)
	private String Asunto;
	
	@Column(name = "Contenido", nullable = false, length = 1000)
	private String Contenido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FechaPost", nullable = false)
	private Date FechaPost;
	
	
	public Foro() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Foro(int idForo, Categoria categoria, Psicologo psicologo, String titulo, String asunto, String contenido,
			Date fechaPost) {
		super();
		this.idForo = idForo;
		this.categoria = categoria;
		this.psicologo = psicologo;
		Titulo = titulo;
		Asunto = asunto;
		Contenido = contenido;
		FechaPost = fechaPost;
	}


	public int getIdForo() {
		return idForo;
	}


	public void setIdForo(int idForo) {
		this.idForo = idForo;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Psicologo getPsicologo() {
		return psicologo;
	}


	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
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
