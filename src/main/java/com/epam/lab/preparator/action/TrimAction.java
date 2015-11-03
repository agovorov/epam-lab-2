package com.epam.lab.preparator.action;

import java.util.List;

/**
 * Action trimming symbols
 * 
 * @author Govorov Andrey
 */
public class TrimAction implements Action {

    @Override
    public List<String> doAction(List<String> lines) {
	if (!lines.isEmpty()) {
	    for (int i = 0; i < lines.size(); i++) {
		String line = lines.get(i);
		line = line.trim();
		lines.set(i, line);
	    }
	}
	return lines;
    }

    @Override
    public String doAction(String text) {
	if (!text.isEmpty()) {
	    text = text.trim();
	}
	return text;
    }
}