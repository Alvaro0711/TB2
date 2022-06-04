package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Psicologo;

@Repository
public interface IPsicologoRepository extends JpaRepository<Psicologo, Integer> {

}
