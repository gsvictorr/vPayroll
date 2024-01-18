package br.com.vstok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vstok.dto.auth.AuthRequest;
import br.com.vstok.dto.auth.AuthResponse;
import br.com.vstok.model.User;
import br.com.vstok.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest) {
        if (authRequest.email().isEmpty() || authRequest.password().isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email e senha não podem estar vazios.");
        }
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.email(),
                    authRequest.password());

            var authentication = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) authentication.getPrincipal());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha não encontrados.");
        }

    }

}
