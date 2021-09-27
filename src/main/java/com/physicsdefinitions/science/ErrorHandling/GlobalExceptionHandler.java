package com.physicsdefinitions.science.ErrorHandling;

// import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Object> handleNotFound(MethodArgumentNotValidException ex) {

        Map<String, String> validationError = new HashMap<>();
        validationError.put("error", ex.getAllErrors().get(0).getDefaultMessage());

        return new ResponseEntity<Object>(validationError, HttpStatus.BAD_REQUEST);
    }

    // handle api exception
    @ExceptionHandler(ApiException.class)
    private ResponseEntity<Object> handleAPIException(ApiException ex, WebRequest request) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("error", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
