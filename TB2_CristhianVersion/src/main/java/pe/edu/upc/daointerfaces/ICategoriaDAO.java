/**
 * 
 */
package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Categoria;

public interface ICategoriaDAO {
	
	public void insert(Categoria ca);
	
	public List<Categoria> list();
	
	public void update(Categoria ca);
	
	public void delete(int idCategoria);
	
	public List<Categoria> findByName(Categoria ca);
}
