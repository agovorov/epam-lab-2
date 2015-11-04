package com.epam.lab.parser.generator;

import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.token.Number;
import com.epam.lab.parser.entity.token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class for generating sentence entity from list
 *
 * @author Govorov Andrey
 */
public class SentenceGenerator {

    private final static String WORD_PATTERN = "([а-яёА-Яa-zA-Z]+-[а-яёА-Яa-zA-Z]+)";
    private final static String WORD2_PATTERN = "([а-яёА-Яa-zA-Z]+)";
    private final static String NUMBER_PATTERN = "[0-9]+";
    private final static String MARK_PATTERN = "[^а-яёА-Яa-zA-Z0-9]";

    /**
     * Generate Sentence entity from list of tokens
     *
     * @param line
     * @return Sentence entity
     */
    public Sentence generateFromTokens(List<String> line) {
        List<Token> listToken = new ArrayList<Token>();

        Pattern patternWord = Pattern.compile(WORD_PATTERN);
        Pattern patternWord2 = Pattern.compile(WORD2_PATTERN);
        Pattern patternNumber = Pattern.compile(NUMBER_PATTERN);
        Pattern patternMark = Pattern.compile(MARK_PATTERN);

        if (!line.isEmpty()) {
            for (String str : line) {
                if (patternWord.matcher(str).matches()) {
                    listToken.add(new Word(str));
                } else if (patternWord2.matcher(str).matches()) {
                    listToken.add(new Word(str));
                } else if (patternNumber.matcher(str).matches()) {
                    listToken.add(new Number(str));
                } else if (patternMark.matcher(str).matches()) {
                    listToken.add(new PunctuationMark(str));
                } else {
                    listToken.add(new OtherMark(str));
                }
            }
        }

        return new Sentence(listToken);
    }
}
