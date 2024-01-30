package br.com.vpayroll.exceptions.auth;

public class EmailException extends RuntimeException {

    public EmailException(String error) {
        super(error);
    }
}
