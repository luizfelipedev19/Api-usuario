package com.apiusuario.apiusuario.Entity;

public enum UseRole {

    ADMIN("admin"),
    USER("user");

    private String Role;

    UseRole(String Role){
        this.Role = Role;
    }

    public String getRole() {
        return Role;
    }
}
