package com.example.demo.serviceImp;

import com.example.demo.mapper.RolMapper;
import com.example.demo.model.Rol;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> obtenerTodosRoles() {
        return rolRepository.obtenerTodosRoles();
    }
}

