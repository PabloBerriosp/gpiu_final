package org.example.backend.controller;

import org.example.backend.model.Horario;
import org.example.backend.service.HorarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horarios")
@CrossOrigin(origins = "http://localhost:5173")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public Horario obtenerHorarioActual(@PathVariable Long idEstudiante) {
        return horarioService.obtenerHorarioActualDeEstudiante(idEstudiante);
    }
}

