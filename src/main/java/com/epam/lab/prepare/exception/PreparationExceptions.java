package com.epam.lab.prepare.exception;

public class PreparationExceptions extends Exception {
    public PreparationExceptions(String message) {
	super(message);
    }

    public PreparationExceptions(String message, Exception cause) {
	super(message, cause);
    }
}