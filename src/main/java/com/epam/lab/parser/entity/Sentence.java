package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.token.Token;

/**
 * Sentence entity class
 * 
 * @author Govorov Andrey
 */
public class Sentence implements Iterable<Token> {

    private List<Token> tokens;

    public Sentence() {
	tokens = new ArrayList<Token>();
    }

    public Sentence(List<Token> list) {
	super();
	tokens = list;
    }

    public void addToken(Token token) {
	tokens.add(token);
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
}