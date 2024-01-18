package br.com.vstok.dto.user;

import br.com.vstok.config.roles.UserRole;

public record UserResponse(Long id, String name, String email, String password, UserRole role) {
}
