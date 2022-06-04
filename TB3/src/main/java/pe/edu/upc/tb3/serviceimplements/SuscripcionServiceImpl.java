package pe.edu.upc.tb3.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.tb3.entities.Suscripcion;
import pe.edu.upc.tb3.repositories.ISuscripcionRepository;
import pe.edu.upc.tb3.serviceinterfaces.ISuscripcionService;

@Service
public class SuscripcionServiceImpl implements ISuscripcionService {
	@Autowired
	private ISuscripcionRepository susRepository;

	@Override
	public void insert(Suscripcion sus) {
		susRepository.save(sus);
	}

	@Override
	public List<Suscripcion> list() {
		// TODO Auto-generated method stub
		return susRepository.findAll();
	}
}
