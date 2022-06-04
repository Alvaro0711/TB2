package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Integer> {

}
