package es.unex.aos.gestion_cliente;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import es.unex.aos.gestion_cliente.model.Cliente;
import es.unex.aos.gestion_cliente.repository.ClienteRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionClienteApplication {

    @Autowired
    ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionClienteApplication.class, args);

	}


	 @PostConstruct
    public void init() {
        List<Cliente> list = new ArrayList<>();

        Cliente cliente = new Cliente();
        cliente.setNombre("John");
        cliente.setApellido("Doe");
        cliente.setDireccion("123 Main St");
        // Agrega más atributos según tus necesidades

        list.add(cliente);

        cliente = new Cliente();
        cliente.setNombre("Jane");
        cliente.setApellido("Smith");
        cliente.setDireccion("456 Elm St");
        // Agrega más atributos según tus necesidades

        list.add(cliente);

        // Guarda los clientes en la base de datos
        clienteRepository.saveAll(list);
    }

}
