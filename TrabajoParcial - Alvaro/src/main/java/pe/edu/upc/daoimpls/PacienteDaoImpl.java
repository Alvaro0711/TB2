package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;

@Transactional

public class PacienteDaoImpl implements IPacienteDao {
	@PersistenceContext(unitName = "Avance")
	private EntityManager em;

	@Override
	public void insert(Paciente p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar en paciente dao");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> List() {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		try {
			Query jpql = em.createQuery("from Paciente p");
			listaPacientes = (List<Paciente>) jpql.getResultList();

		} catch (Exception e) {
			System.out.println("Error al listar paciente en el dao List");
		}

		return listaPacientes;
	}

	@Transactional
	@Override
	public void delete(int idPaciente) {
		try {
			Paciente per = em.find(Paciente.class, idPaciente);
			em.remove(per);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el dao de paciente");
		}
	}
	
	@Transactional
	@Override
	public void update(Paciente p) {
		try {
			em.merge(p);
		}catch(Exception e) {
			System.out.println("Error al modificar Paciente en el DAO");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> BuscarNombre(Paciente p) {
		List<Paciente> listaBuscada = new ArrayList<Paciente>();
		try {
			Query q=em.createQuery("from Paciente p where p.NombrePaciente like ?1");
			q.setParameter(1, p.getNombrePaciente());
			listaBuscada=(List<Paciente>)q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al Buscar Paciente");
		}
		return listaBuscada;
	}
}
