package org.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Estudiante extends Usuario {

    @Column(nullable = false, unique = true)
    private String rut;

    @Column(nullable = false)
    private String carrera;

    public Estudiante() {
        super();
    }

    public Estudiante(String nombre, String email, String rol, String rut, String carrera) {
        super(nombre, email, rol);
        this.rut = rut;
        this.carrera = carrera;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
