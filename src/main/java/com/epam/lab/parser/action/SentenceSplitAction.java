package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Split list of strings by to sentences
 *
 * @author Govorov Andrey
 */
public class SentenceSplitAction implements SplitAction {

    private static final String SENTENCE_PATTERN = "([^.!?]*([.]{3}|[.!?]))";

    /**
     * Split string by pattern
     *
     * @param line Input text
     * @return List
     */
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
