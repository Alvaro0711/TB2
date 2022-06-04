package pe.edu.upc.tb3.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.tb3.entities.Psicologo;

public interface IPsicologoService {
	public void insert(Psicologo psicologo);
	public List<Psicologo> list();
	public void delete(int idPsicologo);
	
	Optional<Psicologo> listId(int idPsicologo);
	public void update(Psicologo psicologo);
}
