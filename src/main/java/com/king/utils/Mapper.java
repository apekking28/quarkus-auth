package com.king.utils;

import com.king.dto.response.RoleResponseDTO;
import com.king.dto.response.UserResponseDTO;
import com.king.model.Role;
import com.king.model.User;

public class Mapper {

    private Mapper() {
    }

    public static RoleResponseDTO roleDto(Role role) {
        RoleResponseDTO roleDto = new RoleResponseDTO();

        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setUsers(role.getUsers()
                .stream()
                        .map(Mapper::userDto)
                .toList());

        return roleDto;
    }

    public static UserResponseDTO userDto(User user) {
        UserResponseDTO userDto = new UserResponseDTO();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
