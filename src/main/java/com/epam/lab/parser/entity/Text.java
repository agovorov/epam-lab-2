package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Text entity class
 * 
 * @author Govorov Andrey
 */
public class Text implements Iterable<Paragraph> {

    private List<Paragraph> paragraphs;

    public Text() {
	paragraphs = new ArrayList<Paragraph>();
    }

    public void addParagraph(Paragraph paragraph) {
	paragraphs.add(paragraph);
    }

    public Paragraph getParagraph(int index) {
	return paragraphs.get(index);
    }

    public int count() {
	return paragraphs.size();
    }

    public Boolean isEmpty() {
	return paragraphs.isEmpty();
    }

    @Override
    public Iterator<Paragraph> iterator() {
	return paragraphs.iterator();
    }
}