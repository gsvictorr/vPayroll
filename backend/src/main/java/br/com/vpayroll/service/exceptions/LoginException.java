package br.com.vpayroll.service.exceptions;

import org.springframework.security.core.AuthenticationException;

public class LoginException extends AuthenticationException {
    public LoginException(String error) {
        super(error);
    }

}
