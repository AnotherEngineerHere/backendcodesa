package com.example.demo.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        if (existeNombreUsuario(usuarioDTO.getNombre())) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setNombre(usuarioDTO.getNombre());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        
        UsuarioDTO usuarioGuardadoDTO = new UsuarioDTO();
        usuarioGuardadoDTO.setIdUsuario(usuarioGuardado.getIdUsuario());
        usuarioGuardadoDTO.setNombre(usuarioGuardado.getNombre());

        return usuarioGuardadoDTO;
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioExistenteOptional = usuarioRepository.findById(usuarioDTO.getIdUsuario());
        if (usuarioExistenteOptional.isPresent()) {
            Usuario usuarioExistente = usuarioExistenteOptional.get();

            if (!usuarioExistente.getNombre().equals(usuarioDTO.getNombre()) && existeNombreUsuario(usuarioDTO.getNombre())) {
                return null;
            }

            usuarioExistente.setNombre(usuarioDTO.getNombre());

            Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);

            UsuarioDTO usuarioActualizadoDTO = new UsuarioDTO();
            usuarioActualizadoDTO.setIdUsuario(usuarioActualizado.getIdUsuario());
            usuarioActualizadoDTO.setNombre(usuarioActualizado.getNombre());

            return usuarioActualizadoDTO;
        }

        return null;
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setIdRol(usuario.getIdRol());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setActivo(usuario.getActivo());
            usuarioDTO.setCorreo(usuario.getCorreo());
            
            return usuarioDTO;
        }
        return null;
    }

    @Override
    public List<UsuarioDTO> buscarUsuariosPorNombre(String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombreContaining(nombre);
        
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setNombre(usuario.getNombre());
            usuariosDTO.add(usuarioDTO);
        }
        
        return usuariosDTO;
    }
    @Override
    public List<UsuarioDTO> mostrarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setIdRol(usuario.getIdRol());
            usuarioDTO.setNombre(usuario.getNombre());
            usuarioDTO.setActivo(usuario.getActivo());
            usuarioDTO.setCorreo(usuario.getCorreo());
            usuariosDTO.add(usuarioDTO);
        }

        return usuariosDTO;
    }
    @Override
    public boolean existeNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombre(nombreUsuario);
    }
}
