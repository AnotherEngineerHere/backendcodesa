package com.example.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.RolDTO;
import com.example.demo.model.Rol;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    Rol toEntity(RolDTO rolDTO);

    RolDTO toDTO(Rol rol);
}
