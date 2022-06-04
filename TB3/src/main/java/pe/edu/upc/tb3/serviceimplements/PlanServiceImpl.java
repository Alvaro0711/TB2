package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Plan;
import pe.edu.upc.tb3.repositories.IPlanRepository;
import pe.edu.upc.tb3.serviceinterfaces.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {
	@Autowired
	private IPlanRepository planRepository;

	@Override
	public void insert(Plan plan) {
		planRepository.save(plan);
	}

	@Override
	public List<Plan> list() {
		// TODO Auto-generated method stub
		return planRepository.findAll();
	}
	
	@Override
	public void delete(int idPlan) {
		planRepository.deleteById(idPlan);
	}

	@Override
	public Optional<Plan> listId(int idPlan) {
		// TODO Auto-generated method stub
		return planRepository.findById(idPlan);
	}
}
