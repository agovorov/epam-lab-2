package com.epam.lab.parser.exception;

public class UndefinedTokenException extends Exception{
    public UndefinedTokenException(String message) {
        super(message);
    }

    public UndefinedTokenException(String message, Exception cause) {
        super(message, cause);
    }
}
