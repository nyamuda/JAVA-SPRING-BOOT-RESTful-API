package com.physicsdefinitions.science.ErrorHandling;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

}
