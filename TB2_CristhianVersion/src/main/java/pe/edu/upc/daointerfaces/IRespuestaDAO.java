/**
 * 
 */
package pe.edu.upc.daointerfaces;

import java.util.List;

import pe.edu.upc.entities.Respuesta;

public interface IRespuestaDAO {
	
	public void insert(Respuesta re);
	
	public List<Respuesta> list();
	
	public void update(Respuesta re);
	
	public void delete(int idRespuesta);
	
	public List<Respuesta> findByName(Respuesta re);
}
