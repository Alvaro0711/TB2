/**
 * 
 */
package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Foro;

public interface IForoDAO {
	
	public void insert(Foro fo);
	
	public List<Foro> list();
	
	public void update(Foro fo);
	
	public void delete(int idForo);
	
	public List<Foro> findByName(Foro fo);
}
