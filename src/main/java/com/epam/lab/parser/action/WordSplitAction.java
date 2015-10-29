package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordSplitAction implements SplitAction {

	private static final String WORD_PATTERN = "\\s|\\n";

	@Override
	public List<String> splitTo(List<String> lines) {
		ArrayList<String> matches = new ArrayList<String>();
		Pattern pattern = Pattern.compile(WORD_PATTERN);
		for (String string : lines) {
			String[] result = pattern.split(string);
			matches.addAll(Arrays.asList(result));
		}

		return matches;
	}

	@Override
	public List<String> splitTo(String line) {
		ArrayList<String> matches = new ArrayList<String>();
		Pattern pattern = Pattern.compile(WORD_PATTERN);
		String[] result = pattern.split(line);
		matches.addAll(Arrays.asList(result));

		return matches;
	}
}
