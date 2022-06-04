package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Categoria;
import pe.edu.upc.tb3.repositories.ICategoriaRepository;
import pe.edu.upc.tb3.serviceinterfaces.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaRepository caRepository;

	@Override
	public void insert(Categoria ca) {
		caRepository.save(ca);
	}

	@Override
	public List<Categoria> list() {
		return caRepository.findAll();
	}

	@Override
	public void delete(int idCategoria) {
		caRepository.deleteById(idCategoria);
	}

	@Override
	public Optional<Categoria> listId(int idCategoria) {
		return caRepository.findById(idCategoria);
	}

	@Override
	public void update(Categoria categoria) {
		caRepository.save(categoria);
	}

}
