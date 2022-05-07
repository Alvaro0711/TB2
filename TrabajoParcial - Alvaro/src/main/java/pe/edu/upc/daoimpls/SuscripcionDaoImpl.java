package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ISuscripcionDao;
import pe.edu.upc.entities.Suscripcion;

public class SuscripcionDaoImpl implements ISuscripcionDao {
	@PersistenceContext(unitName = "Avance")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Suscripcion s) {
		try {
			em.persist(s);
		} catch (Exception e) {
			System.out.println("Error al insertar en suscripcion dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Suscripcion> List() {
		List<Suscripcion> listaSuscripciones = new ArrayList<Suscripcion>();
		try {
			Query jpql = em.createQuery("from Suscripcion s");
			listaSuscripciones = jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar Suscripcion en el dao List");
		}

		return listaSuscripciones;
	}

	@Transactional
	@Override
	public void update(Suscripcion sus) {
		try {
			em.merge(sus);
		}catch(Exception e) {
			System.out.println("Error al modificar Suscripcion en el DAO");
		}
	}
}
