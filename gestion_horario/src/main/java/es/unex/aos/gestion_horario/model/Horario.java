package es.unex.aos.gestion_horario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Horario {
    @Id
    @GeneratedValue
    private long idEmpleado; 

    private String diaSemana;
    private String horaEntrada;
    private String horaSalida;

    // Constructor por defecto
    public Horario() {
    }

    // Constructor con todos los atributos
    public Horario(long idEmpleado, String diaSemana, String horaEntrada, String horaSalida) {
        this.idEmpleado = idEmpleado;
        this.diaSemana = diaSemana;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    // Método getter para idEmpleado
    public long getIdEmpleado() {
        return idEmpleado;
    }

    // Método setter para idEmpleado
    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    // Método getter para diaSemana
    public String getDiaSemana() {
        return diaSemana;
    }

    // Método setter para diaSemana
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    // Método getter para horaEntrada
    public String getHoraEntrada() {
        return horaEntrada;
    }

    // Método setter para horaEntrada
    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    // Método getter para horaSalida
    public String getHoraSalida() {
        return horaSalida;
    }

    // Método setter para horaSalida
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
}
