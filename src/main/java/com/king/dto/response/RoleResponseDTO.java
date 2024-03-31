package com.king.dto.response;

import com.king.model.Roles;

import java.util.ArrayList;
import java.util.List;

public class RoleResponseDTO {

    private String id;
    private Roles name;
    private List<UserResponseDTO> users = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles roles) {
        this.name = roles;
    }

    public List<UserResponseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponseDTO> users) {
        this.users = users;
    }
}
