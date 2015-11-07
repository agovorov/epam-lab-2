package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.exception.UndefinedTokenException;
import com.epam.lab.property.RegexPropertyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract entity class for tokens(words, punctuation mark, numbers)
 *
 * @author Govorov Andrey
 */
public abstract class Token {

    // Patter for split sentence to tokens
    private final static String TOKENS_PATTERN = RegexPropertyManager.getInstance().getProperty("token_regex");

    // Belong
    private final static String WORD_PATTERN = RegexPropertyManager.getInstance().getProperty("word_pattern");
    private final static String NUMBER_PATTERN = RegexPropertyManager.getInstance().getProperty("number_pattern");
    private final static String PUNCTUATION_PATTERN = RegexPropertyManager.getInstance().getProperty("punctuation_pattern");
    private final static String WHITESPACE_PATTERN = RegexPropertyManager.getInstance().getProperty("whitespace_pattern");

    // Compiled patterns
    private final static Pattern patternWord = Pattern.compile(WORD_PATTERN);
    private final static Pattern patternNumber = Pattern.compile(NUMBER_PATTERN);
    private final static Pattern patternMark = Pattern.compile(PUNCTUATION_PATTERN);
    private final static Pattern patternWhitespace = Pattern.compile(WHITESPACE_PATTERN);


    /**
     * Split string to tokens
     *
     * @param str
     * @return
     */
    public final static List<String> splitToTokens(String str) {
        List<String> list = new ArrayList<>();

        //patternWordG
        Matcher matcher = Pattern.compile(TOKENS_PATTERN).matcher(str);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }

    /**
     * Create new object of token
     *
     * @param textToken
     * @return
     */
    public final static Token getTokenType(String textToken) {
        if (patternWord.matcher(textToken).matches()) {
            return new Word(textToken);
        } else if (patternNumber.matcher(textToken).matches()) {
            return new Number(textToken);
        } else if (patternMark.matcher(textToken).matches()) {
            return new PunctuationMark(textToken);
        } else if (patternWhitespace.matcher(textToken).matches()) {
            return new Whitespace();
        } else {
            return new OtherMark(textToken);
        }
    }

    /**
     * Return
     *
     * @param token
     * @return
     */
    public static final String getTokenValue(Token token) throws UndefinedTokenException {
        if (token instanceof Word) {
            return ((Word) token).getValue();
        } else if (token instanceof PunctuationMark) {
            return ((PunctuationMark) token).getValue();

        } else if (token instanceof Whitespace) {
            return ((Whitespace) token).getValue();

        } else if (token instanceof Number) {
            return ((Number) token).getValue();

        } else if (token instanceof OtherMark) {
            return ((OtherMark) token).getValue();
        }

        // Never goes here because of OtherMark
        throw new UndefinedTokenException("Specified undefined token.");
    }
}
