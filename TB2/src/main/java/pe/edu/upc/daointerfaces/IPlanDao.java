package pe.edu.upc.daointerfaces;

import java.util.List;
import pe.edu.upc.entities.Plan;

public interface IPlanDao {
	public void insert(Plan pl);
	public List<Plan> List();
	
	public void delete(int idPlan);
}
