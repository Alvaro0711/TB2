package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IPlanDao;
import pe.edu.upc.serviceinterfaces.IPlanService;
import pe.edu.upc.entities.Plan;

@Named
public class PlanServiceImpl implements IPlanService{
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private IPlanDao plDao;

	@Override
	public void insert(Plan pl) {
		plDao.insert(pl);
	}

	@Override
	public List<Plan> list() {

		return plDao.List();
	}

	@Override
	public void delete(int idPlan) {
		plDao.delete(idPlan);
	}
}
