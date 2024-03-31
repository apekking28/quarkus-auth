package com.king.dto.request;

import com.king.model.Roles;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class RoleRequestDTO {
    @Schema(example = "USER", description = "Role of user")
    private Roles name;

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }
}
