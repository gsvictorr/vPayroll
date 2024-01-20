package br.com.vpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vpayroll.dto.auth.AuthRequest;
import br.com.vpayroll.dto.auth.AuthResponse;
import br.com.vpayroll.dto.auth.ValidateRequest;
import br.com.vpayroll.dto.auth.ValidateResponse;
import br.com.vpayroll.model.User;
import br.com.vpayroll.service.TokenService;
import br.com.vpayroll.service.exceptions.ExceptionResponse;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "http://localhost:3000/*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest) {
        if (authRequest.email().isEmpty() || authRequest.password().isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body((new ExceptionResponse("Email ou senha não podem ser vazios.")));
        }
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.email(),
                    authRequest.password());

            var authentication = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) authentication.getPrincipal());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body((new ExceptionResponse("Email ou senha não encontrados")));
        }

    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateResponse> validateToken(@RequestBody @Valid ValidateRequest validateRequest) {

        var outputValid = tokenService.validateToken(validateRequest.token());

        var isValid = false;

        if (!outputValid.isBlank()) {
            isValid = true;
        }

        return ResponseEntity.ok().body(new ValidateResponse(isValid));

    }

}
