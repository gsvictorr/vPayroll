package br.com.vpayroll.service.exceptions;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String error) {
        super(error);
    }
}