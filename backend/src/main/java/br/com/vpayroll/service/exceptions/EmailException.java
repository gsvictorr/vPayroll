package br.com.vpayroll.service.exceptions;

public class EmailException extends RuntimeException {

    public EmailException(String error) {
        super(error);
    }
}
