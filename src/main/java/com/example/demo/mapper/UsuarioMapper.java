package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "idUsuario", ignore = true)
    Usuario toEntity(UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO(Usuario usuario);
}
