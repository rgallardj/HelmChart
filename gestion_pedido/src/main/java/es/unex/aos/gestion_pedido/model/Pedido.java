package es.unex.aos.gestion_pedido.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Pedido {

    @Id 
    @GeneratedValue
    private Long id; // Añadido un campo de tipo Long para el ID de Pedido
    private String estado;
    private int idCliente;
    private int valorPedido;
    private int unidades;
    private String nombre;
    private String direccionEntrega;

    // Constructor por defecto
    public Pedido() {
    }

    // Constructor con todos los atributos
   
   public Pedido(Long id, String estado, int idCliente, int valorPedido, int unidades, String nombre, String direccionEntrega) {
     this.id = id;
     this.estado = estado;
     this.idCliente = idCliente;
     this.valorPedido = valorPedido;
     this.unidades = unidades;
     this.nombre = nombre;
     this.direccionEntrega = direccionEntrega;
    }

    // Métodos getter y setter para el campo ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos getters y setters para estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos getters y setters para idCliente
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    // Métodos getters y setters para valorPedido
    public int getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(int valorPedido) {
        this.valorPedido = valorPedido;
    }

    // Métodos getters y setters para unidades
    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    // Métodos getters y setters para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getters y setters para direccionEntrega
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
