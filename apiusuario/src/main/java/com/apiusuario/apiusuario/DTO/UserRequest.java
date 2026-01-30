package com.apiusuario.apiusuario.DTO;

import com.apiusuario.apiusuario.Entity.UseRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest{

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 10, max = 20)
    @Email
    private String email;
    @NotNull
    @Size(min = 6, max = 12)
    private String password;
    @NotNull
    private UseRole role;

    public UserRequest(){

    }

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

    public UseRole getRole() {
        return role;
    }

    public void setRole(UseRole role) {
        this.role = role;
    }
}
