package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Paciente;
import pe.edu.upc.tb3.repositories.IPacienteRepository;
import pe.edu.upc.tb3.serviceinterfaces.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {
	@Autowired
	private IPacienteRepository pacienteRepository;

	@Override
	public void insert(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public List<Paciente> list() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}
	
	@Override
	public void delete(int idPaciente) {
		pacienteRepository.deleteById(idPaciente);
	}

	@Override
	public Optional<Paciente> listId(int idPaciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(idPaciente);
	}

	@Override
	public void update(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteRepository.save(paciente);
	}
}
