package com.epam.lab.prepare.action;

import java.util.List;

public class ReplaceAllAction implements Action {

    private String regex;
    private String replacement;

    public ReplaceAllAction(String regex, String replacement) {
	super();
	this.regex = regex;
	this.replacement = replacement;
    }

    @Override
    public List<String> doAction(List<String> lines) {
	if (!lines.isEmpty()) {
	    for (int i = 0; i < lines.size(); i++) {
		String line = lines.get(i);
		line = line.replaceAll(regex, replacement);
		lines.set(i, line);
	    }
	}
	return lines;
    }
}
