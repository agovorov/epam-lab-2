package com.epam.lab.task;

import com.epam.lab.task.exception.TaskException;

public interface Task {

    void execute() throws TaskException;
}
