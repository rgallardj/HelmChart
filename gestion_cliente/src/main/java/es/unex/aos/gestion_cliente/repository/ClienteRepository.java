package es.unex.aos.gestion_cliente.repository;

import es.unex.aos.gestion_cliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}