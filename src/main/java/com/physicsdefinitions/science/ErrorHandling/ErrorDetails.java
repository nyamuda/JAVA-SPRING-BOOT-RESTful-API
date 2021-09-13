package com.physicsdefinitions.science.ErrorHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details, HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;

    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
