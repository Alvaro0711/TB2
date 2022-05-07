package pe.edu.upc.serviceimpls;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerfaces.ICategoriaDAO;
import pe.edu.upc.entities.Categoria;
import pe.edu.upc.serviceinterfaces.ICategoriaService;

@Named
public class CategoriaServiceImpl implements ICategoriaService {

	@Inject
	private ICategoriaDAO caDao;

	@Override
	public void insert(Categoria ca) {
		// TODO Auto-generated method stub
		caDao.insert(ca);
	}

	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return caDao.list();
	}

	@Override
	public void delete(int idCategoria) {
		// TODO Auto-generated method stub
		caDao.delete(idCategoria);
	}

	@Override
	public void update(Categoria va) {
		// TODO Auto-generated method stub
		caDao.update(va);
	}
	
	@Override
	public List<Categoria> findByName(Categoria ca) {
		// TODO Auto-generated method stub
		return caDao.findByName(ca);
	}

}
