package pe.edu.upc.tb3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.tb3.entities.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

}
