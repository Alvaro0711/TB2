package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Foro;

@Repository
public interface IForoRepository extends JpaRepository<Foro,Integer>{

}
