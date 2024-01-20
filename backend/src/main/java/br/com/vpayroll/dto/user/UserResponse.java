package br.com.vpayroll.dto.user;

import br.com.vpayroll.config.roles.UserRole;

public record UserResponse(Long id, String name, String email, String password, UserRole role) {
}
