package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Split list of strings to symbols
 *
 * @author Govorov Andrey
 */
public class SymbolSplitAction implements SplitAction {

    private static final String LETTER_PATTERN = "(?=\\S)[^\\\\]";

    /**
     * Split string by pattern
     *
     * @param txt Input text
     * @return List
     */
    @Override
    public List<String> splitTo(String txt) {
        ArrayList<String> matches = new ArrayList<String>();
        Pattern pattern = Pattern.compile(LETTER_PATTERN);
        Matcher matcher = pattern.matcher(txt);
        while (matcher.find()) {
            String str = matcher.group();
            if (!str.isEmpty()) {
                matches.add(str.trim());
            }
        }
        return matches;
    }
}