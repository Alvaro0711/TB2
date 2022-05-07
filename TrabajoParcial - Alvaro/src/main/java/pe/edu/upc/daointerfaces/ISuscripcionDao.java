package pe.edu.upc.daointerfaces;

import java.util.List;
import pe.edu.upc.entities.Suscripcion;

public interface ISuscripcionDao {
	public void insert(Suscripcion sus);
	public List<Suscripcion>List();
	
	public void update(Suscripcion sus);
}
