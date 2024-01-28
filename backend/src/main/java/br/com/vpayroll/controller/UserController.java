package br.com.vpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vpayroll.dto.user.UserRequest;
import br.com.vpayroll.dto.user.UserResponse;
import br.com.vpayroll.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse registerUser = userService.registerUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verifyUser(code)) {
            return "Conta verificada";
        } else {
            return "Falha ao verificar conta";
        }

    }
}
