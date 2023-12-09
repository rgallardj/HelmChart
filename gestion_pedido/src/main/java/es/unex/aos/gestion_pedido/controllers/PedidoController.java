package es.unex.aos.gestion_pedido.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación @GetMapping
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.unex.aos.gestion_pedido.model.Pedido;
import es.unex.aos.gestion_pedido.repository.PedidoRepository;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository; // Inyecta el repositorio de Pedidos

    @PostMapping("/pedido")
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    @GetMapping("/pedidos")
    public Iterable<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

     @GetMapping("/pedido/{id}")
    public Pedido getPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

     @PutMapping("/pedido/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido updatedPedido) {
        Pedido existingPedido = pedidoRepository.findById(id).orElse(null);

        if (existingPedido != null) {
            existingPedido.setEstado(updatedPedido.getEstado());
            // Actualiza los demás campos según sea necesario
            return pedidoRepository.save(existingPedido);
        } else {
            return null; // Maneja el caso en que el Pedido no existe
        }
    }

    @DeleteMapping("/pedido/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }

    @DeleteMapping("/pedido")
    public void deleteAllPedidos() {
        pedidoRepository.deleteAll();
    }

}
