package org.example.backend.service;

import org.example.backend.model.Contenido;
import org.example.backend.repository.ContenidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ContenidoService {

    private final ContenidoRepository contenidoRepository;

    public ContenidoService(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    public Contenido crearContenido(Contenido contenido) {

        if (contenido.getTitulo() == null || contenido.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        if (contenido.getCategoria() == null || contenido.getCategoria().isBlank()) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }

        if (contenido.getAmbito() == null || contenido.getAmbito().isBlank()) {
            throw new IllegalArgumentException("El ámbito es obligatorio");
        }

        LocalDate inicio = contenido.getVigenciaInicio();
        LocalDate fin = contenido.getVigenciaFin();
        if (inicio != null && fin != null && fin.isBefore(inicio)) {
            throw new IllegalArgumentException("La vigencia fin no puede ser anterior a la fecha de inicio ");
        }

        if (contenido.getEstado() == null || contenido.getEstado().isBlank()) {
            contenido.setEstado("borrador");
        }

        return contenidoRepository.save(contenido);
    }

    public List<Contenido> listarContenidos() {
        return contenidoRepository.findAll();
    }

    public Contenido obtenerPorId(Long id) {
        return contenidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contenido no encontrado con id:  " + id));
    }
}
