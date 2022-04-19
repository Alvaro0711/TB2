package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IPacienteDao;
import pe.edu.upc.serviceinterfaces.IPacienteService;
import pe.edu.upc.entities.Paciente;

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
}
