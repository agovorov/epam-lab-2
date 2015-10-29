package com.epam.lab.textmanager.exception;

public class TextManagerException extends Exception {
    public TextManagerException(String message) {
	super(message);
    }

    public TextManagerException(String message, Exception cause) {
	super(message, cause);
    }
}
