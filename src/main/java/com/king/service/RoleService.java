package com.king.service;

import com.king.dto.request.RoleRequestDTO;
import com.king.dto.response.RoleResponseDTO;
import com.king.model.Role;
import com.king.repository.RoleRepository;
import com.king.utils.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class RoleService {

    @Inject
    RoleRepository roleRepository;

    public Role addRole(RoleRequestDTO request) {
        Role addRole = new Role();
        addRole.setName(request.getName());

        roleRepository.persist(addRole);

        return addRole;
    }

    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.listAll().stream().map(Mapper::roleDto).toList();
    }

    public Role updateRole(String roleId, RoleRequestDTO request) {
        Role existingRole = roleRepository.findByIdOptional(roleId).orElseThrow(() -> new IllegalArgumentException("Role with id " + roleId + " not found"));

        existingRole.setName(request.getName());

        return existingRole;
    }

    public String deleteRole(String roleId) {
        Role existingRole = roleRepository.findByIdOptional(roleId).orElseThrow(() -> new IllegalArgumentException("Role with id " + roleId + " not found"));

        roleRepository.delete(existingRole);

        return "Successfully delete role with id " + roleId;
    }
}
