package br.com.vpayroll.exceptions;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String error) {
        super(error);
    }
}