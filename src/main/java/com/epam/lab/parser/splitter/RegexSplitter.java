package com.epam.lab.parser.splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Govorov Andrey
 */
public class RegexSplitter implements Splitter {

    public List<String> splitText(String text, String regex) {
        ArrayList<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String str = matcher.group();
            if (!str.isEmpty()) {
                matches.add(str);
            }
        }
        return matches;
    }
}
