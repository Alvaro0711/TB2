package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.IPsicologoDao;
import pe.edu.upc.serviceinterfaces.IPsicologoService;
import pe.edu.upc.entities.Psicologo;

@Named
public class PsicologoServiceImpl implements IPsicologoService {
	@Inject
	private IPsicologoDao pDao;

	@Override
	public void insert(Psicologo ps) {
		pDao.insert(ps);
	}

	@Override
	public List<Psicologo> list() {

		return pDao.List();
	}

	@Override
	public void delete(int idPsicologo) {
		pDao.delete(idPsicologo);
	}
}
