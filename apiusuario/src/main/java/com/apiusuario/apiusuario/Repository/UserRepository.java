package com.apiusuario.apiusuario.Repository;

import com.apiusuario.apiusuario.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByEmail(String username);
}
