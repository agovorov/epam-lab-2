package com.epam.lab.parser.entity;

import com.epam.lab.parser.entity.token.Number;
import com.epam.lab.parser.entity.token.*;
import com.epam.lab.parser.exception.UndefinedTokenException;

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
        paragraphs = new ArrayList<>();
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

    /**
     * @deprecated
     */
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
    public String getPlainText() {
        StringBuilder sb = new StringBuilder();
        if (!paragraphs.isEmpty()) {
            for (Paragraph paragraph : paragraphs) {
                for (Sentence sentence : paragraph) {
                    for (Token token : sentence) {
                        String tokenValue;
                        try {
                            tokenValue = token.getTokenValue(token);
                            sb.append(tokenValue);
                        } catch (UndefinedTokenException e) {
                            // Ignore wrong token
                        }
                    }
                }
            }
        }
        return sb.toString();
    }



    @Override
    public String toString() {
        return "Text [paragraphs.size=" + paragraphs.size() + "]";
    }
}