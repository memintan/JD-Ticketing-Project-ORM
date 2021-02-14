package com.ticketing.implementation;

import com.ticketing.dto.RoleDTO;
import com.ticketing.entitiy.Role;
import com.ticketing.repository.RoleRepository;
import com.ticketing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> listAllRoles() {
        List<Role> list = roleRepository.findAll();
        //convert to DTO and return it --> why we need mapper?
        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
