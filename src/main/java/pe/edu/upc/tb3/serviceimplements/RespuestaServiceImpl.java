package pe.edu.upc.tb3.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.tb3.entities.Respuesta;
import pe.edu.upc.tb3.repositories.IRespuestaRepository;
import pe.edu.upc.tb3.serviceinterfaces.IRespuestaService;

@Service
public class RespuestaServiceImpl implements IRespuestaService {

	@Autowired
	private IRespuestaRepository reRepository;

	@Override
	public void insert(Respuesta re) {
		reRepository.save(re);
	}

	@Override
	public List<Respuesta> list() {
		return reRepository.findAll();
	}

	@Override
	public void delete(int idRespuesta) {
		reRepository.deleteById(idRespuesta);
	}

	@Override
	public Optional<Respuesta> listId(int idRespuesta) {
		return reRepository.findById(idRespuesta);
	}

	@Override
	public void update(Respuesta respuesta) {
		reRepository.save(respuesta);
	}
}
