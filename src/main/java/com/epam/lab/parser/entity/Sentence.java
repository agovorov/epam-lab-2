package com.epam.lab.parser.entity;

import com.epam.lab.parser.entity.token.OtherMark;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;
import com.epam.lab.parser.exception.UndefinedTokenException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sentence entity class
 *
 * @author Govorov Andrey
 */
public class Sentence implements Iterable<Token> {

    private List<Token> tokens;

    public Sentence() {
        tokens = new ArrayList<>();
    }

    public Sentence(List<Token> list) {
        super();
        tokens = list;
    }

    /**
     * Creating tokens from string line. Input string split into tokens and then return objects
     *
     * @param str
     */
    public Sentence(String str) {
        // Split to tokens
        List<String> listTokens = Token.splitToTokens(str);

        tokens = new ArrayList<>();
        for (String tokenStr : listTokens) {
            Token token = Token.getTokenType(tokenStr);
            tokens.add(token);
        }
    }

    public void addWord(Token token) {
        tokens.add(token);
    }

    /**
     * Any text will be added as Word object. Remember that
     *
     * @param str
     */
    public void addWord(String str) {
        Word word = new Word(str);
        tokens.add(word);
    }

    public Token getTokens(int index) {
        return tokens.get(index);
    }

    public int count() {
        return tokens.size();
    }

    @Override
    public Iterator<Token> iterator() {
        return tokens.iterator();
    }

    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Token token : tokens) {
            try {
                String tokenValue = Token.getTokenValue(token);
                result.append(tokenValue);
            } catch (UndefinedTokenException e) {
                // Ignore Wrong token. Never goes here
            }
        }
        return result.toString();
    }
}