package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IForoDAO;
import pe.edu.upc.entities.Foro;
import pe.edu.upc.serviceinterfaces.IForoService;

@Named
public class ForoServiceImpl implements IForoService {

	@Inject
	private IForoDAO foDao;

	@Override
	public void insert(Foro fo) {
		// TODO Auto-generated method stub
		foDao.insert(fo);
	}

	@Override
	public List<Foro> list() {
		// TODO Auto-generated method stub
		return foDao.list();
	}

	@Override
	public void delete(int idForo) {
		// TODO Auto-generated method stub
		foDao.delete(idForo);
	}

	@Override
	public void update(Foro fo) {
		// TODO Auto-generated method stub
		foDao.update(fo);
	}
	
	@Override
	public List<Foro> findByName(Foro fo) {
		// TODO Auto-generated method stub
		return foDao.findByName(fo);
	}

}
