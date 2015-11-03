package com.epam.lab.preparator.exception;

public class PreparationExceptions extends Exception {
    public PreparationExceptions(String message) {
	super(message);
    }

    public PreparationExceptions(String message, Exception cause) {
	super(message, cause);
    }
}