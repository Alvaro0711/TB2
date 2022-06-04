package pe.edu.upc.tb3.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.tb3.entities.Plan;

public interface IPlanService {
	
	public void insert(Plan plan);
	public List<Plan> list();
	public void delete(int idPlan);
	
	Optional<Plan> listId(int idPaciente);
}
