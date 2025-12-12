package org.example.backend.repository;

import org.example.backend.model.Horario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @EntityGraph(attributePaths = {"bloques", "bloques.asignatura", "estudiante"})
    Optional<Horario> findTopByEstudiante_IdUsuarioOrderByUltimaActualizacionDesc(Long idEstudiante);
}
