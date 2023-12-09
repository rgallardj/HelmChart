package es.unex.aos.gestion_pedido;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.unex.aos.gestion_pedido.model.Pedido;
import es.unex.aos.gestion_pedido.repository.PedidoRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionPedidoApplication {

	@Autowired
    PedidoRepository pedidoRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionPedidoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        List<Pedido> list = new ArrayList<>();

        Pedido pedido1 = new Pedido();
        pedido1.setEstado("Pendiente");
        pedido1.setIdCliente(1); // Establece el ID del cliente correspondiente
        pedido1.setValorPedido(100);
        pedido1.setUnidades(5);
        pedido1.setNombre("Pedido 1");
        pedido1.setDireccionEntrega("Dirección 1");
        list.add(pedido1);

        Pedido pedido2 = new Pedido();
        pedido2.setEstado("Entregado");
        pedido2.setIdCliente(2); // Establece el ID del cliente correspondiente
        pedido2.setValorPedido(200);
        pedido2.setUnidades(10);
        pedido2.setNombre("Pedido 2");
        pedido2.setDireccionEntrega("Dirección 2");
        list.add(pedido2);

        
        Pedido pedido3 = new Pedido();
        pedido3.setEstado("Entregado");
        pedido3.setIdCliente(2); // Establece el ID del cliente correspondiente
        pedido3.setValorPedido(300);
        pedido3.setUnidades(10);
        pedido3.setNombre("Pedido 3");
        pedido3.setDireccionEntrega("Dirección 2");
        list.add(pedido3);

        pedidoRepository.saveAll(list);
    }
}
