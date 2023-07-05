package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO);
    void eliminarUsuario(Long idUsuario);
    UsuarioDTO obtenerUsuarioPorId(Long idUsuario);
    List<UsuarioDTO> buscarUsuariosPorNombre(String nombre);
    boolean existeNombreUsuario(String nombreUsuario);
    List<UsuarioDTO> mostrarTodosUsuarios();
}