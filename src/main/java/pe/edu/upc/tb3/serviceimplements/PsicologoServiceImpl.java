package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Psicologo;
import pe.edu.upc.tb3.repositories.IPsicologoRepository;
import pe.edu.upc.tb3.serviceinterfaces.IPsicologoService;

@Service
public class PsicologoServiceImpl implements IPsicologoService {
	@Autowired
	private IPsicologoRepository psicologoRepository;

	@Override
	public void insert(Psicologo psicologo) {
		psicologoRepository.save(psicologo);
	}

	@Override
	public List<Psicologo> list() {
		// TODO Auto-generated method stub
		return psicologoRepository.findAll();
	}
	
	@Override
	public void delete(int idPsicologo) {
		psicologoRepository.deleteById(idPsicologo);
	}

	@Override
	public Optional<Psicologo> listId(int idPsicologo) {
		// TODO Auto-generated method stub
		return psicologoRepository.findById(idPsicologo);
	}

	@Override
	public void update(Psicologo psicologo) {
		// TODO Auto-generated method stub
		psicologoRepository.save(psicologo);
	}
}
