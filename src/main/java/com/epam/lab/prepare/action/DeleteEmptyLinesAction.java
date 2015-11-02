package com.epam.lab.prepare.action;

import java.util.List;

/**
 * Action deleting empty line
 * 
 * @author Govorov Andrey
 */
public class DeleteEmptyLinesAction implements Action {

    @Override
    public List<String> doAction(List<String> lines) {
	if (!lines.isEmpty()) {
	    for (int i = 0; i < lines.size(); i++) {
		String line = lines.get(i);
		if (line.isEmpty()) {
		    lines.remove(i);
		}
	    }
	}
	return lines;
    }
}
