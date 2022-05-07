package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPsicologoDao;
import pe.edu.upc.entities.Psicologo;

public class PsicologoDaoImpl implements IPsicologoDao {
	@PersistenceContext(unitName = "TB2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Psicologo ps) {
		try {
			em.persist(ps);
		} catch (Exception e) {
			System.out.println("Error al insertar en psicologo dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Psicologo> List() {
		List<Psicologo> listaPsicologos = new ArrayList<Psicologo>();
		try {
			Query jpql = em.createQuery("from Psicologo p");
			listaPsicologos = (List<Psicologo>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar paciente en el dao List");
		}

		return listaPsicologos;
	}

	@Transactional
	@Override
	public void delete(int idPsicologo) {
		try {
			Psicologo per = em.find(Psicologo.class, idPsicologo);
			em.remove(per);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el dao de Psicologo");
		}
	}
}
