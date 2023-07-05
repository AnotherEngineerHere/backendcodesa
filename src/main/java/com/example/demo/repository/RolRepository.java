package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query("SELECT r FROM Rol r")
    List<Rol> obtenerTodosRoles();
}
