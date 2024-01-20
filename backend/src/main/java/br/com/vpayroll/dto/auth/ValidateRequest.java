package br.com.vpayroll.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record ValidateRequest(@NotBlank String token) {

}
