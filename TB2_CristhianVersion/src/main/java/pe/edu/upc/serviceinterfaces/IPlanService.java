package pe.edu.upc.serviceinterfaces;

import java.util.List;
import pe.edu.upc.entities.Plan;

public interface IPlanService {
	public void insert(Plan pl);
	public List<Plan> list();
	public void delete(int idPlan);
}
