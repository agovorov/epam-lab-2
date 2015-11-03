package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.token.OtherMark;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;

/**
 * Paragraph entity class
 * 
 * @author Govorov Andrey
 */
public class Paragraph implements Iterable<Sentence> {

    private List<Sentence> sentences;

    public Paragraph() {
	sentences = new ArrayList<Sentence>();
    }

    public void addSentence(Sentence sentence) {
	sentences.add(sentence);
    }

    public void addSentence(String string) {
	Sentence sentence = new Sentence(string);
	sentences.add(sentence);
    }

    public Sentence getSentence(int index) {
	return sentences.get(index);
    }

    public int count() {
	return sentences.size();
    }

    @Override
    public Iterator<Sentence> iterator() {
	return sentences.iterator();
    }

    public void showStructure() {
	System.out.println("\t" + this);
	for (Sentence sentence : sentences) {
	    System.out.println("\t\t" + sentence.getClass() + ": ");
	    for (Token token : sentence) {
		System.out.print("\t\t\t" + token.getClass() + ": ");
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

    public String getValue() {
	StringBuilder result = new StringBuilder();
	for (Sentence sentence : sentences) {
	    for (Token token : sentence) {
		if (token instanceof Word) {
		    result.append(((Word) token).getValue());
		} else if (token instanceof PunctuationMark) {
		    result.append(((PunctuationMark) token).getValue());
		} else if (token instanceof OtherMark) {
		    result.append(((OtherMark) token).getValue());
		}
	    }
	}
	// getClass() + ": ! " +
	return result.toString();
    }
}
