package com.example.demo.controller;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long idUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(idUsuario);
        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> mostrarTodosUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioService.mostrarTodosUsuarios();
        return ResponseEntity.ok(usuariosDTO);
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarUsuariosPorNombre(@RequestParam(required = false) String nombre) {
        List<UsuarioDTO> usuariosDTO = usuarioService.buscarUsuariosPorNombre(nombre);
        return ResponseEntity.ok(usuariosDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO nuevoUsuarioDTO = usuarioService.crearUsuario(usuarioDTO);
        if (nuevoUsuarioDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setIdUsuario(idUsuario);
        UsuarioDTO usuarioActualizadoDTO = usuarioService.actualizarUsuario(usuarioDTO);
        if (usuarioActualizadoDTO != null) {
            return ResponseEntity.ok(usuarioActualizadoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
