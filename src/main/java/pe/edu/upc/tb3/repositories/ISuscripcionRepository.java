package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Suscripcion;

@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, Integer> {

}
