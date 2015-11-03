package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.display.DisplayStrategy;
import com.epam.lab.display.DisplayStrategyFactory;
import com.epam.lab.parser.entity.token.OtherMark;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;

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

    /**
     * Add paragraph object in list
     * 
     * @param paragraph
     */
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

    public void showStructure() {
	System.out.println("\t" + this.getClass() + ": ");
	for (Paragraph paragraph : paragraphs) {
	    System.out.println("\t\t" + paragraph.getClass() + ": ");
	    for (Sentence sentence : paragraph) {
		System.out.println("\t\t\t" + sentence.getClass() + ": ");
		for (Token token : sentence) {
		    System.out.print("\t\t\t\t" + token.getClass() + ": ");
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
    }

    /**
     * Extract text to string
     * 
     * @return simple text
     */
    public String getText() {
	StringBuilder sb = new StringBuilder();
	if (!paragraphs.isEmpty()) {
	    for (Paragraph paragraph : paragraphs) {
		for (Sentence sentence : paragraph) {
		    for (Token token : sentence) {
			String tmpToken = "";
			if (token instanceof Word) {
			    tmpToken = ((Word) token).getValue();
			} else if (token instanceof PunctuationMark) {
			    tmpToken = ((PunctuationMark) token).getValue();
			} else if (token instanceof OtherMark) {
			    tmpToken = ((OtherMark) token).getValue();
			}
			sb.append(tmpToken);
		    }
		}
		sb.append('\n');
	    }
	}
	return sb.toString();
    }

    @Override
    public String toString() {
	return "Text [paragraphs.size=" + paragraphs.size() + "]";
    }
}