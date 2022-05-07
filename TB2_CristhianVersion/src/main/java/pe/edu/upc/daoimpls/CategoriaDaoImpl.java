package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.ICategoriaDAO;
import pe.edu.upc.entities.Categoria;

public class CategoriaDaoImpl implements ICategoriaDAO {

	@PersistenceContext(unitName = "TB2")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Categoria ca) {
		try {
			em.persist(ca);
		} catch (Exception e) {
			System.out.println("Error al insertar categoria en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> list() {

		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		try {
			Query jpql = em.createQuery("from Categoria ca");
			listaCategoria = (List<Categoria>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar categoria en DAO");
		}
		return listaCategoria;
	}

	@Transactional
	@Override
	public void delete(int idCategoria) {
		try {
			Categoria cat = em.find(Categoria.class, idCategoria);
			em.remove(cat);
		} catch (Exception e) {

			System.out.println("Error al eliminar en el dao");
		}
	}
	
	@Transactional
	@Override
	public void update(Categoria ca) {
		try {
			em.merge(ca);
		} catch (Exception e) {
			System.out.println("Error al actualizar en el dao");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findByName(Categoria ca) {
		List<Categoria> listaBuscada = new ArrayList<Categoria>();
		try {
			Query q = em.createQuery("from Categoria ca where ca.Nombre like ?1");//
			q.setParameter(1, "%" + ca.getNombre() + "%");
			listaBuscada = (List<Categoria>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar categoria");
		}
		return listaBuscada;
	}

}
