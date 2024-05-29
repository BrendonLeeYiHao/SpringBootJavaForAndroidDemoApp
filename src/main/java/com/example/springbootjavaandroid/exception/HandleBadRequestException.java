package com.example.springbootjavaandroid.exception;

public class HandleBadRequestException extends BaseException {

    public HandleBadRequestException(String message) {
        super(message);
    }

    public HandleBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
