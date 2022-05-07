package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Respuesta;

public interface IRespuestaService {

	public void insert(Respuesta re);

	public List<Respuesta> list();
	
	public void update(Respuesta re);

	public void delete(int idRespuesta);
	
	public List<Respuesta> findByName(Respuesta re);
}
