package es.unex.aos.user.Controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

  @Autowired
  private LoadBalancerClient loadBalancer;

  //////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////// INVOCACION AL MICROSERVICIO
  ////////////////////////////////////////////////////////////////////////////////////////////// GESTION_PEDIDO//////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  @GetMapping("/pedidos")
  public void getPedidos() throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("pedidos");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'gestion_pedido'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/pedidos";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      System.out.println("*** Se han recuperado correctamente todos los pedidos ***");
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

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

  // Métodos para eliminar pedidos en gestion_pedido
  @DeleteMapping("/pedidos/{id}")
  public ResponseEntity<String> deletePedido(@PathVariable Long id) {
    ServiceInstance serviceInstance = loadBalancer.choose("pedidos");
    if (serviceInstance == null)
      return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'gestion_pedido'");

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/pedido/" + id;

    RestTemplate restTemplate = new RestTemplate();
    try {
      return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_pedido'");
    }
  }

  @DeleteMapping("/pedidos")
  public ResponseEntity<String> deleteAllPedidos() {
    ServiceInstance serviceInstance = loadBalancer.choose("pedidos");
    if (serviceInstance == null)
      return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'gestion_pedido'");

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/pedido";

    RestTemplate restTemplate = new RestTemplate();
    try {

      return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_pedido'");
    }
  }
  //////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////// FIN INVOCACION AL MICROSERVICIO
  ////////////////////////////////////////////////////////////////////////////////////////////// GESTION_PEDIDO///////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  //////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////// INVOCACION AL MICROSERVICIO
  ////////////////////////////////////////////////////////////////////////////////////////////// GESTION_CLIENTE/////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////

  @GetMapping("/clientes")
  public void getClientes() throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("clientes");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'clientes'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/clientes";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

  @GetMapping("/cliente/{id}")
  public void getClienteId(@PathVariable Long id) throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("clientes");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'gestion_cliente'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/cliente/" + id;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

  // Método para eliminar un cliente por ID en gestion_cliente
  @DeleteMapping("/cliente/{id}")
  public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
    ServiceInstance serviceInstance = loadBalancer.choose("clientes");

    if (serviceInstance == null)
      return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'gestion_cliente'");

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/cliente/" + id;

    RestTemplate restTemplate = new RestTemplate();
    try {
      return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_cliente'");
    }
  }

  // Método para eliminar todos los clientes en gestion_cliente
  //Servicio
@DeleteMapping("/clientes")
public ResponseEntity<String> deleteAllClientes() {
    ServiceInstance serviceInstance = loadBalancer.choose("clientes");
    if (serviceInstance == null) {
        return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'clientes'");
    }

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/clientes"; //controlador cliente

    RestTemplate restTemplate = new RestTemplate();
    try {
        return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_cliente'");
    }
}

  //////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////// FIN INVOCACION AL MICROSERVICIO GESTION_CLIENTE
  ////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////

  //////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////// INVOCACION AL MICROSERVICIO
  ////////////////////////////////////////////////////////////////////////////////////////////// GESTION_HORARIO////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////

  @GetMapping("/horarios")
  public void getHorarios() throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("horarios");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'gestion_horario'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/horarios";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

  @GetMapping("/horario/{id}")
  public void getHorarioId(@PathVariable Long id) throws RestClientException, IOException {

    ServiceInstance serviceInstance = loadBalancer.choose("horarios");
    if (serviceInstance == null)
      System.out.println("ERROR - no hay servicios activos con el nombre 'gestion_horario'");

    System.out.println("*** Load balancer uri: " + serviceInstance.getUri());

    String baseUrl = serviceInstance.getUri().toString();

    baseUrl = baseUrl + "/horario/" + id;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

  // Método para eliminar un horario por ID en gestion_horario
  @DeleteMapping("/horario/{id}")
  public ResponseEntity<String> deleteHorario(@PathVariable Long id) {
    ServiceInstance serviceInstance = loadBalancer.choose("horarios");

    if (serviceInstance == null)
      return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'gestion_horario'");

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/horario/" + id;
    RestTemplate restTemplate = new RestTemplate();
    try {
      return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_horario'");
    }
  }

  // Método para eliminar todos los horarios en gestion_horario
  @DeleteMapping("/horarios")
  public ResponseEntity<String> deleteAllHorarios() {
    ServiceInstance serviceInstance = loadBalancer.choose("horarios");

    if (serviceInstance == null)
      return ResponseEntity.status(500).body("ERROR - No hay servicios activos con el nombre 'gestion_horario'");

    String baseUrl = serviceInstance.getUri().toString();
    baseUrl = baseUrl + "/horario";
    RestTemplate restTemplate = new RestTemplate();
    try {
      return restTemplate.exchange(baseUrl, HttpMethod.DELETE, getHeaders(), String.class);
    } catch (RestClientException | IOException e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body("ERROR - Excepción al llamar a 'gestion_horario'");
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////// FIN INVOCACION AL MICROSERVICIOGESTION_HORARIO
  ///////////////////////////////////////////////////////////////////////////////////////////// //////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////

  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    return new HttpEntity<>(headers);
  }
}