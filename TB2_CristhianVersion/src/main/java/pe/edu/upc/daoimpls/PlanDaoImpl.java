package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPlanDao;
import pe.edu.upc.entities.Plan;

public class PlanDaoImpl implements IPlanDao {
	@PersistenceContext(unitName = "TB2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Plan pl) {
		try {
			em.persist(pl);
		} catch (Exception e) {
			System.out.println("Error al insertar en plan dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> List() {
		List<Plan> listaPlanes = new ArrayList<Plan>();
		try {
			Query jpql = em.createQuery("from Plan pl");
			listaPlanes = (List<Plan>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar plan en el dao List");
		}

		return listaPlanes;
	}

	@Transactional
	@Override
	public void delete(int idPlan) {
		try {
			Plan per = em.find(Plan.class, idPlan);
			em.remove(per);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el dao de Plan");
		}
	}

}
