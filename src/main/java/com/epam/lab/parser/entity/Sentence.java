package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.token.OtherMark;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;

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

    /**
     * All string as one Word object
     * 
     * @param str
     */
    public Sentence(String str) {
	tokens = new ArrayList<Token>();

	String[] stringParts = str.split(" ");
	if (stringParts.length > 0) {
	    for (String s : stringParts) {
		Word word = new Word(s + " ");
		tokens.add(word);
	    }
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
	    if (token instanceof Word) {
		result.append(((Word) token).getValue());
	    } else if (token instanceof PunctuationMark) {
		result.append(((PunctuationMark) token).getValue());
	    } else if (token instanceof OtherMark) {
		result.append(((OtherMark) token).getValue());
	    }
	}
	// getClass() + ": ! " +
	return result.toString();
    }

    public void showStructure() {
	System.out.println("\t" + this);
	for (Token token : tokens) {
	    System.out.print("\t\t" + token.getClass() + ": ");
	    if (token instanceof Word) {
		System.out.print('\'' + ((Word) token).getValue() + '\'');
	    } else if (token instanceof PunctuationMark) {
		System.out.print('\'' + ((PunctuationMark) token).getValue() + '\'');
	    } else if (token instanceof OtherMark) {
		System.out.print('\'' + ((OtherMark) token).getValue() + '\'');
	    }
	    System.out.println();
	}
    }
}