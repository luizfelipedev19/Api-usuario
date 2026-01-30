package com.apiusuario.apiusuario.Service;

import com.apiusuario.apiusuario.DTO.UserRequest;
import com.apiusuario.apiusuario.DTO.UserResponse;
import com.apiusuario.apiusuario.Entity.UseRole;
import com.apiusuario.apiusuario.Entity.Usuarios;
import com.apiusuario.apiusuario.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    public Usuarios toEntity(UserRequest request){
        Usuarios usuario = new Usuarios();

        usuario.setName(request.getName());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        usuario.setRole(request.getRole());

        return usuario;

    }

    public UserResponse toResponse(Usuarios usuarios){
        UserResponse response = new UserResponse();

        response.setId(usuarios.getId());
        response.setEmail(usuarios.getEmail());
        response.setPassword(usuarios.getPassword());

        return response;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
}
