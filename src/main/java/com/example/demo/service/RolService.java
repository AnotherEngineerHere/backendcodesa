package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.RolDTO;
import com.example.demo.model.Rol;

public interface RolService {
    List<Rol> obtenerTodosRoles();
}