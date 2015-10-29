package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceSplitAction implements SplitAction {

	// private static final String SENTENCE_PATTERN = "\\n|\\r|\\.|\\!|\\?";
	private static final String SENTENCE_PATTERN = "([^.!?]*([.]{3}|[.!?]))";

	// ["']?[А-ЯA-Z][^.?!]+((?![.?!]['"]?\s["']?[А-ЯA-Z][^.?!]).)+[.?!'"]+

	@Override
	public List<String> splitTo(List<String> lines) {
		ArrayList<String> matches = new ArrayList<String>();

		Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
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
		Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
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
