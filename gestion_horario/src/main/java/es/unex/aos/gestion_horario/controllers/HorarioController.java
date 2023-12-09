package es.unex.aos.gestion_horario.controllers;

import es.unex.aos.gestion_horario.model.Horario;
import es.unex.aos.gestion_horario.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HorarioController {

    @Autowired
    private HorarioRepository horarioRepository;

    // Crear un nuevo horario
    @PostMapping("/horario")
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioRepository.save(horario);
    }

    // Obtener todos los horarios
    @GetMapping("/horarios")
    public List<Horario> getAllHorarios() {
        return (List<Horario>) horarioRepository.findAll();
    }

    // Obtener un horario por ID
    @GetMapping("/horario/{id}")
    public Optional<Horario> getHorario(@PathVariable Long id) {
        return horarioRepository.findById(id);
    }

    // Actualizar un horario por ID
    @PutMapping("/horario/{id}")
    public Horario updateHorario(@PathVariable Long id, @RequestBody Horario updatedHorario) {
        Horario existingHorario = horarioRepository.findById(id).orElse(null);

        if (existingHorario != null) {
            existingHorario.setIdEmpleado(updatedHorario.getIdEmpleado());
            existingHorario.setDiaSemana(updatedHorario.getDiaSemana());
            existingHorario.setHoraEntrada(updatedHorario.getHoraEntrada());
            existingHorario.setHoraSalida(updatedHorario.getHoraSalida());

            return horarioRepository.save(existingHorario);
        } else {
            throw new RuntimeException("Horario no encontrado: " + id);
        }
    }

    // Eliminar un horario por ID
    @DeleteMapping("/horario/{id}")
    public void deleteHorario(@PathVariable Long id) {
        horarioRepository.deleteById(id);
    }

    // Eliminar todos los horarios
    @DeleteMapping("/horario")
    public void deleteAllHorarios() {
        horarioRepository.deleteAll();
    }
}
