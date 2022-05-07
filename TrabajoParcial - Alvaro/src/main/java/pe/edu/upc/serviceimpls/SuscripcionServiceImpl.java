package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.ISuscripcionDao;
import pe.edu.upc.serviceinterfaces.ISuscripcionService;
import pe.edu.upc.entities.Suscripcion;

@Named
public class SuscripcionServiceImpl implements ISuscripcionService {
	
	@Inject
	private ISuscripcionDao sDao;
	
	@Override
	public void insert(Suscripcion s) {
		sDao.insert(s);
	}
	
	@Override
	public List<Suscripcion> list() {

		return sDao.List();
	}

	@Override
	public void update(Suscripcion sus) {
		sDao.update(sus);
	}
}
