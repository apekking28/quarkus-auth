package com.king.repository;

import com.king.model.Role;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoleRepository implements PanacheRepositoryBase<Role, String> {

    public Role findByName() {
        return find("name  = 'USER'").firstResult();
    }
}
