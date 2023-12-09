package es.unex.aos.gestion_cliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import es.unex.aos.gestion_cliente.model.Cliente;
import es.unex.aos.gestion_cliente.repository.ClienteRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository; // Inyecta el repositorio de Clientes

    @Autowired
    private LoadBalancerClient loadBalancer;

    // Crear un nuevo cliente
    @PostMapping("/cliente")
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/cliente/{id}")
    public Optional<Cliente> getCliente(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    // Actualizar un cliente por ID
    @PutMapping("/cliente/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        if (clienteRepository.existsById(id)) {
            updatedCliente.setId(id); // Asegurarse de que el ID coincida
            return clienteRepository.save(updatedCliente);
        } else {
            throw new RuntimeException("Cliente no encontrado: " + id);
        }
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no encontrado: " + id);
        }
    }

    // Eliminar todos los clientes
    @DeleteMapping("/clientes")
    public void deleteAllClientes() {
        clienteRepository.deleteAll();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// INVOCACION AL MICROSERVICIOGESTION_PEDIDO//////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////// 


    @GetMapping("/pedidos/{id}")
  public void getPedidoId(@PathVariable Long id) throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("pedidos");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'gestion_pedido'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/pedido/" + id;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }
    //////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////// FIN INVOCACION ALMICROSERVICIOGESTION_PEDIDO/////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////// 
    //////////////////////////////////////////////////////////////////////////////////////////////
  
    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}
