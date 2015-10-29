package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text implements Iterable<Paragraph> {

	private List<Paragraph> paragraphs;

	public Text() {
		paragraphs = new ArrayList<Paragraph>();
	}

	public void addParagraph(Paragraph paragraph) {
		paragraphs.add(paragraph);
	}

	public int count() {
		return paragraphs.size();
	}

	@Override
	public Iterator<Paragraph> iterator() {
		return paragraphs.iterator();
	}
}
