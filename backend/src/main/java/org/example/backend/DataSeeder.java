package org.example.backend;

import org.example.backend.model.*;
import org.example.backend.repository.AsignaturaRepository;
import org.example.backend.repository.EstudianteRepository;
import org.example.backend.repository.HorarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DataSeeder implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final HorarioRepository horarioRepository;

    public DataSeeder(EstudianteRepository estudianteRepository,
                      AsignaturaRepository asignaturaRepository,
                      HorarioRepository horarioRepository) {
        this.estudianteRepository = estudianteRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.horarioRepository = horarioRepository;
    }

    @Override
    public void run(String... args) {
        // Evitar duplicar seed si ya existe algo
        if (estudianteRepository.count() > 0 || asignaturaRepository.count() > 0 || horarioRepository.count() > 0) {
            return;
        }

        // 1) Estudiante
        Estudiante est = new Estudiante(
                "Juan Pérez",
                "juan.perez@usach.cl",
                "ESTUDIANTE",
                "12.345.678-9",
                "Ingeniería"
        );
        est = estudianteRepository.save(est);

        // 2) Asignaturas
        Asignatura prog = new Asignatura("INF-101", "Programación I");
        Asignatura calc = new Asignatura("MAT-120", "Cálculo I");
        asignaturaRepository.save(prog);
        asignaturaRepository.save(calc);

        // 3) Horario + Bloques (la misma asignatura varias veces por semana)
        Horario horario = new Horario(est);

        horario.agregarBloque(new BloqueHorario("Lunes",  LocalTime.of(8, 0),  LocalTime.of(9, 30),  "Sala A1", prog));
        horario.agregarBloque(new BloqueHorario("Miércoles", LocalTime.of(8, 0),  LocalTime.of(9, 30),  "Sala B2", prog)); // misma asignatura, otro día/sala

        horario.agregarBloque(new BloqueHorario("Martes", LocalTime.of(10, 0), LocalTime.of(11, 30), "Sala C3", calc));
        horario.agregarBloque(new BloqueHorario("Jueves", LocalTime.of(10, 0), LocalTime.of(11, 30), "Sala C3", calc));

        horarioRepository.save(horario);

        System.out.println("Seed listo. Estudiante id=" + est.getIdUsuario() + " (usa este id en el endpoint de horario).");
    }
}
