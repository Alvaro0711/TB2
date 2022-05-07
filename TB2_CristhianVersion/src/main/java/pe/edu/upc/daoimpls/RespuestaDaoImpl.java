package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IRespuestaDAO;
import pe.edu.upc.entities.Respuesta;

public class RespuestaDaoImpl implements IRespuestaDAO {

	@PersistenceContext(unitName = "TB2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Respuesta re) {
		try {
			em.persist(re);
		} catch (Exception e) {
			System.out.println("Error al insertar respuesta en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Respuesta> list() {

		List<Respuesta> listaRespuesta = new ArrayList<Respuesta>();
		try {
			Query jpql = em.createQuery("from Respuesta re");
			listaRespuesta = (List<Respuesta>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar Respuesta en DAO");
		}
		return listaRespuesta;
	}

	@Transactional
	@Override
	public void delete(int idRespuesta) {
		try {
			Respuesta res = em.find(Respuesta.class, idRespuesta);
			em.remove(res);
		} catch (Exception e) {

			System.out.println("Error al eliminar en el dao");
		}
	}
	
	@Transactional
	@Override
	public void update(Respuesta re) {
		try {
			em.merge(re);
		} catch (Exception e) {
			System.out.println("Error al actualizar en el dao");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Respuesta> findByName(Respuesta re) {
		List<Respuesta> listaBuscada = new ArrayList<Respuesta>();
		try {
			Query q = em.createQuery("from Respuesta re where re.Contenido like ?1");// el 1 es el valor variado
			q.setParameter(1, "%" + re.getConteni() + "%");
			listaBuscada = (List<Respuesta>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar respuesta por contenido");
		}
		return listaBuscada;
	}

}
