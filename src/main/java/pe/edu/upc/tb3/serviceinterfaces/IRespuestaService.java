package pe.edu.upc.tb3.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.tb3.entities.Respuesta;

public interface IRespuestaService {

	public void insert(Respuesta respuesta);
	public List<Respuesta> list();
	public void delete(int idRespuesta);
	Optional<Respuesta> listId(int idRespuesta);
	public void update(Respuesta respuesta);
}