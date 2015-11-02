package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Split list of strings to paragraphs
 * 
 * @author Govorov Andrey
 */
public class ParagraphSplitAction implements SplitAction {

    private static final String PARAGRAPH_PATTERN = "\n";

    /**
     * Split each line by pattern
     * 
     * @param lines Lines of string
     * @return List
     */
    @Override
    public List<String> splitTo(List<String> lines) {
	ArrayList<String> matches = new ArrayList<String>();
	Pattern pattern = Pattern.compile(PARAGRAPH_PATTERN);
	for (String string : lines) {
	    String[] result = pattern.split(string);
	    matches.addAll(Arrays.asList(result));
	}

	return matches;
    }

    /**
     * Split string by pattern
     * 
     * @param txt Input text
     * @return List
     */
    @Override
    public List<String> splitTo(String txt) {
	ArrayList<String> matches = new ArrayList<String>();
	Pattern pattern = Pattern.compile(PARAGRAPH_PATTERN);
	String[] result = pattern.split(txt);
	matches.addAll(Arrays.asList(result));

	return matches;
    }
}