package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "ID_ROL")
    private Long idRol;

    @Column(name = "NOMBRE")
    private String nombre;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}