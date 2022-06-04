package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Respuesta;

@Repository
public interface IRespuestaRepository extends JpaRepository<Respuesta,Integer>{

}
