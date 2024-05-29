package com.example.springbootjavaandroid.exception;

public class HandleNotFoundException extends BaseException {

    public HandleNotFoundException(String message) {
        super(message);
    }

    public HandleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
