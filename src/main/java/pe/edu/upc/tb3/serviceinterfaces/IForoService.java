package pe.edu.upc.tb3.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.tb3.entities.Foro;

public interface IForoService {

	public void insert(Foro foro);
	public List<Foro> list();
	public void delete(int idForo);
	Optional<Foro> listId(int idForo);
	public void update(Foro foro);
}