package com.physicsdefinitions.science.ErrorHandling;

import java.time.LocalDateTime;

// import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    // handle specific exception
    // @ExceptionHandler(ConstraintViolationException.class)
    // private ResponseEntity<Object> handleNotFound(ConstraintViolationException
    // ex, WebRequest request) {
    // ErrorDetails errorDetails = new ErrorDetails(ZonedDateTime.now(),
    // ex.getMessage(),
    // request.getDescription(false), HttpStatus.BAD_REQUEST);

    // return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    // }

    // handle api exception
    @ExceptionHandler(ApiException.class)
    private ResponseEntity<Object> handleAPIException(ApiException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getLocalizedMessage(),
                request.getDescription(false), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // handle global exceptions

}
