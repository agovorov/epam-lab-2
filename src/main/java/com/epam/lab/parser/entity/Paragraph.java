package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}
