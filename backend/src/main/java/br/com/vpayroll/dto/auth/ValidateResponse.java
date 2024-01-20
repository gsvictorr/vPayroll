package br.com.vpayroll.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ValidateResponse(@JsonProperty("token_valid") boolean tokenValid) {

}
