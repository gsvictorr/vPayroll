package br.com.vpayroll.exceptions.auth;

import org.springframework.security.core.AuthenticationException;

public class LoginException extends AuthenticationException {
    public LoginException(String error) {
        super(error);
    }

}
