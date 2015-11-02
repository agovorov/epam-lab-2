package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Split list of strings to tokens (word, punctuation mark, numbers)
 * 
 * @author Govorov Andrey
 */
public class TokenSplitAction implements SplitAction {

    private final static String TOKEN_PATTERN = "(([а-яёА-Яa-zA-Z]+-[а-яёА-Яa-zA-Z]+)|([а-яёА-Яa-zA-Z]+)|([0-9]+)|[^а-яёА-Яa-zA-Z0-9])";

    /**
     * Split each line by pattern
     * 
     * @param lines Lines of string
     * @return List
     */
    @Override
    public List<String> splitTo(List<String> lines) {
	throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Split each line by pattern
     * 
     * @param lines Lines of string
     * @return List
     */
    @Override
    public List<String> splitTo(String txt) {
	List<String> list = new ArrayList<String>();
	Matcher matcher = Pattern.compile(TOKEN_PATTERN).matcher(txt);

	while (matcher.find()) {
	    list.add(matcher.group(1));
	}

	return list;
    }
}
