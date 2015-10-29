package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolSplitAction implements SplitAction {

	private static final String LETTER_PATTERN = "(?=\\S)[^\\\\]";

	// private static final String LETTER_PATTERN = "/\\W/g";

	@Override
	public List<String> splitTo(List<String> lines) {
		ArrayList<String> matches = new ArrayList<String>();
		Pattern pattern = Pattern.compile(LETTER_PATTERN);
		for (String string : lines) {
			Matcher matcher = pattern.matcher(string);
			while (matcher.find()) {
				String str = matcher.group();
				if (!str.isEmpty()) {
					matches.add(str.trim()); // Правильно ли тут использовать
												// trim?
				}
			}
		}
		return matches;
	}

	@Override
	public List<String> splitTo(String line) {
		ArrayList<String> matches = new ArrayList<String>();
		Pattern pattern = Pattern.compile(LETTER_PATTERN);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String str = matcher.group();
			if (!str.isEmpty()) {
				matches.add(str.trim());
			}
		}
		return matches;
	}
}