package com.apiusuario.apiusuario.Controller;

import com.apiusuario.apiusuario.DTO.AuthenticationDTO;
import com.apiusuario.apiusuario.DTO.LoginDTO;
import com.apiusuario.apiusuario.DTO.RegisterDTO;
import com.apiusuario.apiusuario.Entity.Usuarios;
import com.apiusuario.apiusuario.Repository.UserRepository;
import com.apiusuario.apiusuario.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data){
        try {
            // 1. Criamos o token de autenticação com e-mail e senha
            var usernamePassword = new UsernamePasswordAuthenticationToken(
                    data.email(),
                    data.password()
            );

            // 2. O manager chama o seu UsuarioService para buscar no banco
            // Se a senha não bater aqui, ele lança uma BadCredentialsException
            var auth = this.authenticationManager.authenticate(usernamePassword);

            // 3. Se passou, gera o token JWT
            var token = tokenService.gerarToken((Usuarios) auth.getPrincipal());

            return ResponseEntity.ok(new LoginDTO(token));
        } catch (Exception e) {
            // Se houver erro de senha ou usuário não existir, retornamos 401 ou 403 explicativo
            return ResponseEntity.status(403).body("Falha na autenticação: Credenciais inválidas.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data){
        if (userRepository.findByEmail(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }

        //aqui eu criptografo a senha
        String encryptPassword = passwordEncoder.encode((data.password()));

        //crio o usuario
        Usuarios newUser = new Usuarios(
                data.email(),
                encryptPassword,
                data.role()
        );
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
