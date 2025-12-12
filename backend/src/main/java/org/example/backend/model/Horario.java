package org.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @Column(name = "ultima_actualizacion", nullable = false)
    private LocalDateTime ultimaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estudiante estudiante;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BloqueHorario> bloques = new ArrayList<>();

    public Horario() {
    }

    public Horario(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<BloqueHorario> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueHorario> bloques) {
        this.bloques = bloques;
    }

    public void agregarBloque(BloqueHorario bloque) {
        bloques.add(bloque);
        bloque.setHorario(this);
    }

    public void quitarBloque(BloqueHorario bloque) {
        bloques.remove(bloque);
        bloque.setHorario(null);
    }
}
