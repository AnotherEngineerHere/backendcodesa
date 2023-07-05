package com.example.demo.controller;


import com.example.demo.model.Rol;
import com.example.demo.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

  
    public ResponseEntity<List<Rol>> obtenerTodosRoles() {
        List<Rol> rolesDTO = rolService.obtenerTodosRoles();
        return ResponseEntity.ok(rolesDTO);
    }
}
