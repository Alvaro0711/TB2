package pe.edu.upc.tb3.serviceinterfaces;

import java.util.List;

import pe.edu.upc.tb3.entities.Suscripcion;

public interface ISuscripcionService {
	
	public void insert(Suscripcion sus);
	
	List<Suscripcion> list();
}
