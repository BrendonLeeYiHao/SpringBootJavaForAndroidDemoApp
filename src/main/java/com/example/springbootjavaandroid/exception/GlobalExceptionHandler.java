package com.example.springbootjavaandroid.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandleNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(HandleNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage() + "\n" + ex.getCause());
    }

    @ExceptionHandler(HandleBadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(HandleBadRequestException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getCause());
    }
}