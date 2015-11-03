package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Split list of strings to words
 * 
 * @author Govorov Andrey
 */
public class WordSplitAction implements SplitAction {

    private static final String WORD_PATTERN = "\\s|\\n";

    /**
     * Split each line by pattern to words
     * 
     * @param lines Lines of string
     * @return List
     */
    @Override
    public List<String> splitTo(String line) {
	ArrayList<String> matches = new ArrayList<String>();
	Pattern pattern = Pattern.compile(WORD_PATTERN);
	String[] result = pattern.split(line);
	matches.addAll(Arrays.asList(result));

	return matches;
    }
}
