package pe.edu.upc.daoimpls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;

//aqui


public class PacienteDaoImpl implements IPacienteDao {
	@PersistenceContext(unitName = "TB2")
	private EntityManager em;
	
	@Transactional
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
}
