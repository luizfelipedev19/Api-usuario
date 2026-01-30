package com.apiusuario.apiusuario.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Esta anotação é obrigatória para capturar exceções globais
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionDTO> handleBadCredentials() {
       // ResponseEntity.status() é um método estático, não precisa de 'new'
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionDTO("Usuário ou senha inválidos.", 401));
    }
}