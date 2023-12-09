package es.unex.aos.gestion_horario.repository;

import es.unex.aos.gestion_horario.model.Horario;
import org.springframework.data.repository.CrudRepository;

public interface HorarioRepository extends CrudRepository<Horario, Long> {
    
}

