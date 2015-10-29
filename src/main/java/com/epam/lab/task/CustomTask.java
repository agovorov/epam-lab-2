package com.epam.lab.task;

import java.util.List;

import com.epam.lab.task.exception.TaskException;

public class CustomTask implements Task {

    @Override
    public void execute() throws TaskException {
    	throw new UnsupportedOperationException("Not implemented yet!");
    }

}
