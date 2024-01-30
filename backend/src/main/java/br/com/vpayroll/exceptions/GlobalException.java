package br.com.vpayroll.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vpayroll.exceptions.auth.LoginException;
import br.com.vpayroll.exceptions.auth.RegisterException;

@RestControllerAdvice
public class GlobalException {

    // ValidException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String value = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(value, message);
        });
        return errors;
    }

    // LoginException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LoginException.class)
    public Map<String, String> userNotFoundException(LoginException ex){
        Map<String, String> errorsMap = new HashMap<String, String>();
        errorsMap.put("error", ex.getMessage());
        return errorsMap;
    }

    // RegisterException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegisterException.class)
    public Map<String, String> registerException(RegisterException ex){
        Map<String, String> errorsMap = new HashMap<String, String>();
        errorsMap.put("error", ex.getMessage());
        return errorsMap;
    }
}
