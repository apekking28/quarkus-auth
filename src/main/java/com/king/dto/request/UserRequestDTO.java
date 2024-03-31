package com.king.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class UserRequestDTO {
    @Schema(example = "john doe", description = "Name of user")
    private String name;

    @Schema(example = "johndoe@gmail.com", description = "Email of user")
    private String email;

    @Schema(example = "Password1!", description = "Password of user")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
