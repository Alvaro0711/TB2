package pe.edu.upc.serviceinterfaces;

import java.util.List;
import pe.edu.upc.entities.Psicologo;

public interface IPsicologoService {
	
	public void insert(Psicologo ps);
	public List<Psicologo> list();
	public void delete(int idPsicologo);
}
