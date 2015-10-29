package com.epam.lab.parser;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.parser.action.ParagraphSplitAction;
import com.epam.lab.parser.action.SentenceSplitAction;
import com.epam.lab.parser.action.SymbolSplitAction;
import com.epam.lab.parser.action.WordSplitAction;
import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.Symbol;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;
import com.epam.lab.parser.exception.ParsingException;
import com.epam.lab.parser.splitter.SimpleSplitter;
import com.epam.lab.parser.splitter.Splitter;

public class SimpleParser implements Parser {

    private Text text;
    private Splitter splitter;

    public SimpleParser() {
	splitter = new SimpleSplitter();
    }

    @Override
    public Text parse(List<String> lines) throws ParsingException {
	text = new Text();

	// Split to paragraphs
	List<String> paragraphList = splitter.action(lines, new ParagraphSplitAction());
	for (String paragraphStr : paragraphList) {
	    Paragraph paragraph = new Paragraph();
	    List<String> sentenceList = splitter.action(paragraphStr, new SentenceSplitAction());

	    for (String sentenceStr : sentenceList) {
		Sentence sentence = new Sentence();
		List<String> wordList = splitter.action(sentenceStr, new WordSplitAction());

		for (String wordStr : wordList) {
		    Word word = new Word();
		    List<String> letterList = splitter.action(wordStr, new SymbolSplitAction());

		    for (String letterStr : letterList) {
			Symbol symbol = new Symbol();
			symbol.setSymbol(letterStr.charAt(0));
			word.addSymbol(symbol);
		    }
		    sentence.addToken(word);
		}
		paragraph.addSentence(sentence);
	    }
	    text.addParagraph(paragraph);
	}

	// Console out
	for (Paragraph paragraph : text) {
	    System.out.println(paragraph);

	    for (Sentence sentence : paragraph) {
		System.out.println("\t" + sentence);

		for (Token word : sentence) {
		    System.out.println("\t\t" + word);
		}
	    }
	}

	return text;
    }

    /**
     * Test method for print data in console
     * 
     * @param lines
     */
    private void printData(List<String> lines) {
	if (!lines.isEmpty()) {
	    for (int i = 0; i < lines.size(); i++) {
		String line = lines.get(i);
		System.out.println("|" + line + "|\n-----------------------");
	    }
	}
    }
}
