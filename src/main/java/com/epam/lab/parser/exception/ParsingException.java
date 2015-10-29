package com.epam.lab.parser.exception;

public class ParsingException extends Exception {
    public ParsingException(String message) {
	super(message);
    }

    public ParsingException(String message, Exception cause) {
	super(message, cause);
    }
}
