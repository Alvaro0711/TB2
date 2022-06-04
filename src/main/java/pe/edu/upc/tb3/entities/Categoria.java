package pe.edu.upc.tb3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;

	@Column(name = "Nombre", nullable = false, length = 50)
	private String Nombre;

	@Column(name = "Descripcion", nullable = false, length = 100)
	private String Descripcion;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int idCategoria, String nombre, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}

