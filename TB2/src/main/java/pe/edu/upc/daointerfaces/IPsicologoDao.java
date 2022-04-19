package pe.edu.upc.daointerfaces;

import java.util.List;
import pe.edu.upc.entities.Psicologo;

public interface IPsicologoDao {
	public void insert(Psicologo ps);
	public List<Psicologo>List();
	
	public void delete(int idPsicologo);
}
