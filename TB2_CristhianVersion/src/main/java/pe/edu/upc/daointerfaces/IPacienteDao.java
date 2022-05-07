package pe.edu.upc.daointerfaces;

import java.util.List;
import pe.edu.upc.entities.Paciente;

public interface IPacienteDao {
	public void insert(Paciente p);
	public List<Paciente>List();
	
	public void delete(int idPaciente);

}
