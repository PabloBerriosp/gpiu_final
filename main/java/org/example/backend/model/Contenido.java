package org.example.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContenido;

    private String titulo;
    private String cuerpo;
    private String categoria;
    private String ambito;
    private String visibilidad;

    private LocalDate vigenciaInicio;
    private LocalDate vigenciaFin;

    private String estado; // publicado | borrador

    public Contenido() {}

    // ======= GETTERS =======

    public Long getIdContenido() {
        return idContenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public LocalDate getVigenciaInicio() {
        return vigenciaInicio;
    }

    public LocalDate getVigenciaFin() {
        return vigenciaFin;
    }

    public String getEstado() {
        return estado;
    }

    // ======= SETTERS =======

    public void setIdContenido(Long idContenido) {
        this.idContenido = idContenido;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public void setVigenciaInicio(LocalDate vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public void setVigenciaFin(LocalDate vigenciaFin) {
        this.vigenciaFin = vigenciaFin;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

