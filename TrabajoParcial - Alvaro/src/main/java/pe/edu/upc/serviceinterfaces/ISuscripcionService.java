package pe.edu.upc.serviceinterfaces;

import java.util.List;

import pe.edu.upc.entities.Suscripcion;

public interface ISuscripcionService {
	public void insert(Suscripcion sus);
	public List<Suscripcion> list();
	public void update(Suscripcion sus);
}
