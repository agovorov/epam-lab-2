package com.epam.lab.io.exception;

public class ReadingException extends Exception {

    public ReadingException(String message) {
	super(message);
    }

    public ReadingException(String message, Exception cause) {
	super(message, cause);
    }
}
