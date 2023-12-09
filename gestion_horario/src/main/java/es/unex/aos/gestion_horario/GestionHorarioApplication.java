package es.unex.aos.gestion_horario;

import es.unex.aos.gestion_horario.model.Horario;
import es.unex.aos.gestion_horario.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionHorarioApplication {

    @Autowired
    HorarioRepository horarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionHorarioApplication.class, args);
    }
    @PostConstruct
    public void init() {
        List<Horario> list = new ArrayList<>();

        Horario horario = new Horario(1, "Lunes", "09:00", "17:00");
        list.add(horario);

        horario = new Horario(2, "Martes", "08:30", "16:30");
        list.add(horario);

        // Agrega más horarios según tus necesidades

        // Guarda los horarios en la base de datos
        horarioRepository.saveAll(list);
    }

    
}
