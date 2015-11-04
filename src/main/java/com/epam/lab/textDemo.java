package com.epam.lab;

import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.Symbol;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Word;

/**
 * Class Text demonstartion
 *
 * @author Govorov Andrey
 */
public class textDemo {

    public static void main(String[] args) {
        // Сохдаем символы
        Symbol s1 = new Symbol('c');
        Symbol s2 = new Symbol('a');
        Symbol s3 = new Symbol('r');
        Symbol s4 = new Symbol('w');

        // Слова
        Word word1 = new Word();
        word1.addSymbol(s1);
        word1.addSymbol(s2);
        word1.addSymbol(s3);

        word1.removeSymbol(s1);
        System.out.println("Word 1: " + word1.getValue());

        PunctuationMark pmark = new PunctuationMark(" ");

        // Из символов строим слова
        Word word2 = new Word();
        word2.addSymbol(s4);
        word2.addSymbol(s2);
        word2.addSymbol(s3);
        word2.addSymbol(' ');
        word2.addSymbol('r');
        word2.addSymbol('u');
        word2.addSymbol('n');
        System.out.println("Word 2: " + word2.getValue());

        // Из слов строим предложение
        Sentence sentence = new Sentence();
        sentence.addWord(word1);
        sentence.addWord(pmark);
        sentence.addWord(word2);
        sentence.addWord(". ");
        sentence.addWord("Тут");
        sentence.addWord(" ");
        sentence.addWord("слово");
        sentence.addWord(". ");
        // sentence.showStructure();
        System.out.println("Sentence 1: " + sentence.getValue() + "\n");

        // Из предложений строим параграфы
        Paragraph par = new Paragraph();
        par.addSentence(sentence);
        par.addSentence("Новый параграф внесенный вручную.");
        // par.showStructure();
        // System.out.println("Paragrap: " + par.getValue() );

        Paragraph par2 = new Paragraph();
        par2.addSentence("Тут параграф созданный вручную! ");
        par2.addSentence("Тут параграф созданный вручную 2! ");

        // Из параграфом строим текст
        Text text = new Text();
        text.addParagraph(par);
        text.addParagraph(par2);
        text.showStructure();

        // Собираем обратно
        System.out.println("\nResult text: ");
        System.out.println(text.getText());
    }
}
