package org.example.backend.service;

import org.example.backend.model.Horario;
import org.example.backend.repository.HorarioRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario obtenerHorarioActualDeEstudiante(Long idEstudiante) {
        return horarioRepository
                .findTopByEstudiante_IdUsuarioOrderByUltimaActualizacionDesc(idEstudiante)
                .orElseThrow(() -> new IllegalArgumentException("No existe horario para el estudiante id=" + idEstudiante));
    }
}
