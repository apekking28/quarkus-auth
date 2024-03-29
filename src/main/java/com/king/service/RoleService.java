package com.king.service;

import com.king.dto.request.RoleRequestDTO;
import com.king.model.Role;
import com.king.model.Roles;
import com.king.repository.RoleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RoleService {

    @Inject
    RoleRepository roleRepository;

    @Transactional
    public Role addRole(RoleRequestDTO request) {
        Role addRole = new Role();
        addRole.setName(request.getName());

        roleRepository.persist(addRole);

        return addRole;
    }
}
