package br.com.vpayroll.service.exceptions;

public class RegisterException extends RuntimeException {

    public RegisterException(String error) {
        super(error);
    }
}
