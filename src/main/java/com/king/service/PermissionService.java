package com.king.service;

import com.king.dto.request.PermissionRequestDTO;
import com.king.model.Permission;
import com.king.repository.PermissionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PermissionService {

    @Inject
    PermissionRepository permissionRepository;

    public Permission addPermission(PermissionRequestDTO request) {
        Permission addPermission = new Permission();

        addPermission.setName(request.getName());
        addPermission.setGuardName(request.getName());

        permissionRepository.persist(addPermission);

        return addPermission;
    }
}
