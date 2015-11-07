package com.epam.lab.parser.entity;

import com.epam.lab.parser.entity.token.OtherMark;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;

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
        sentences = new ArrayList<>();
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

    @Override
    public Iterator<Sentence> iterator() {
        return sentences.iterator();
    }
}
