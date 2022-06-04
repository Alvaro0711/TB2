package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Foro;
import pe.edu.upc.tb3.repositories.IForoRepository;
import pe.edu.upc.tb3.serviceinterfaces.IForoService;

@Service
public class ForoServiceImpl implements IForoService {

	@Autowired
	private IForoRepository foRepository;

	@Override
	public void insert(Foro fo) {
		foRepository.save(fo);
	}

	@Override
	public List<Foro> list() {
		return foRepository.findAll();
	}

	@Override
	public void delete(int idForo) {
		foRepository.deleteById(idForo);
	}

	@Override
	public Optional<Foro> listId(int idForo) {
		return foRepository.findById(idForo);
	}

	@Override
	public void update(Foro foro) {
		foRepository.save(foro);
	}
}
