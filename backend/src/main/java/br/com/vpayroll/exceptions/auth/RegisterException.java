package br.com.vpayroll.exceptions.auth;

public class RegisterException extends RuntimeException {

    public RegisterException(String error) {
        super(error);
    }
}
