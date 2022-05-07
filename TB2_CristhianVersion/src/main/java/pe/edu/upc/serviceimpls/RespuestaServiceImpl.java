package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IRespuestaDAO;
import pe.edu.upc.entities.Respuesta;
import pe.edu.upc.serviceinterfaces.IRespuestaService;

@Named
public class RespuestaServiceImpl implements IRespuestaService {

	@Inject
	private IRespuestaDAO reDao;

	@Override
	public void insert(Respuesta re) {
		// TODO Auto-generated method stub
		reDao.insert(re);
	}

	@Override
	public List<Respuesta> list() {
		// TODO Auto-generated method stub
		return reDao.list();
	}

	@Override
	public void delete(int idRespuesta) {
		// TODO Auto-generated method stub
		reDao.delete(idRespuesta);
	}

	@Override
	public void update(Respuesta re) {
		// TODO Auto-generated method stub
		reDao.update(re);
	}
	@Override
	public List<Respuesta> findByName(Respuesta re) {
		// TODO Auto-generated method stub
		return reDao.findByName(re);
	}

}
