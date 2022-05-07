package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.entities.Paciente;
import pe.edu.upc.serviceinterfaces.IPacienteService;

@Named
public class PacienteServiceImpl implements IPacienteService {
	
	@Inject
	private IPacienteDao pDao;

	@Override
	public void insert(Paciente p) {
		pDao.insert(p);
	}

	@Override
	public List<Paciente> list() {

		return pDao.List();
	}

	@Override
	public void delete(int idPaciente) {
		pDao.delete(idPaciente);
	}
	
	@Override
	public void update(Paciente p) {
		pDao.update(p);
	}
	
	@Override
	public List<Paciente> BuscarNombre(Paciente p) {
		// TODO Auto-generated method stub
		return pDao.BuscarNombre(p);
	}
}
