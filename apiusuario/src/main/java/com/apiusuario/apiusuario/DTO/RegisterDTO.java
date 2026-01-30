package com.apiusuario.apiusuario.DTO;

import com.apiusuario.apiusuario.Entity.UseRole;

public record RegisterDTO(String email, String password, UseRole role) {
}
