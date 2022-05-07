package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IForoDAO;
import pe.edu.upc.entities.Foro;

public class ForoDaoImpl implements IForoDAO {

	@PersistenceContext(unitName = "TB2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Foro fo) {
		try {
			em.persist(fo);
		} catch (Exception e) {
			System.out.println("Error al insertar foro en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foro> list() {

		List<Foro> listaForo = new ArrayList<Foro>();
		try {
			Query jpql = em.createQuery("from Foro fo");
			listaForo = (List<Foro>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar Foro en DAO");
		}
		return listaForo;
	}

	@Transactional
	@Override
	public void delete(int idForo) {
		try {
			Foro foroo = em.find(Foro.class, idForo);
			em.remove(foroo);
		} catch (Exception e) {

			System.out.println("Error al eliminar en el dao");
		}
	}
	
	@Transactional
	@Override
	public void update(Foro fo) {
		try {
			em.merge(fo);
		} catch (Exception e) {
			System.out.println("Error al actualizar en el dao");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Foro> findByName(Foro fo) {
		List<Foro> listaBuscada = new ArrayList<Foro>();
		try {
			Query q = em.createQuery("from Foro fo where fo.Titulo like ?1");// el 1 es el valor variado
			q.setParameter(1, "%" + fo.getTit() + "%");
			listaBuscada = (List<Foro>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar foro por titulo");
		}
		return listaBuscada;
	}

}
