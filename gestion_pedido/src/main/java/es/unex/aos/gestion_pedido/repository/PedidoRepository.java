package es.unex.aos.gestion_pedido.repository;

import org.springframework.data.repository.CrudRepository;
import es.unex.aos.gestion_pedido.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    
}
