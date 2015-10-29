package com.epam.lab.task.exception;

public class TaskException extends Exception {
    public TaskException(String message) {
	super(message);
    }

    public TaskException(String message, Exception cause) {
	super(message, cause);
    }
}
