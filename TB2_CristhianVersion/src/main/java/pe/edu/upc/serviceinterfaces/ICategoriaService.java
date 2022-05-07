package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Categoria;

public interface ICategoriaService {

	public void insert(Categoria ca);

	public List<Categoria> list();
	
	public void update(Categoria ca);

	public void delete(int idCategoria);
	
	public List<Categoria> findByName(Categoria ca);
}
