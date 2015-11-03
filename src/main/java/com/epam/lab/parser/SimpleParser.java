package com.epam.lab.parser;

import java.util.List;

import com.epam.lab.parser.action.ParagraphSplitAction;
import com.epam.lab.parser.action.SentenceSplitAction;
import com.epam.lab.parser.action.TokenSplitAction;
import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;
import com.epam.lab.parser.generator.SentenceGenerator;
import com.epam.lab.parser.splitter.SimpleSplitter;
import com.epam.lab.parser.splitter.Splitter;

/**
 * Simple parser implementation
 * 
 * @author Govorov Andrey
 */
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
		// All tokens from sentense
		List<String> str = splitter.action(sentenceStr, new TokenSplitAction());

		// Assembling sentence from tokens
		SentenceGenerator sentenceGenerator = new SentenceGenerator();
		Sentence sentence = sentenceGenerator.generateFromTokens(str);
		paragraph.addSentence(sentence);
	    }
	    text.addParagraph(paragraph);
	}
	return text;
    }

    @Override
    public Text parse(String stringContent) throws ParsingException {
	text = new Text();

	// Split to paragraphs
	List<String> paragraphList = splitter.action(stringContent, new ParagraphSplitAction());
	for (String paragraphStr : paragraphList) {
	    Paragraph paragraph = new Paragraph();
	    List<String> sentenceList = splitter.action(paragraphStr, new SentenceSplitAction());

	    for (String sentenceStr : sentenceList) {
		// All tokens from sentense
		List<String> str = splitter.action(sentenceStr, new TokenSplitAction());

		// Assembling sentence from tokens
		SentenceGenerator sentenceGenerator = new SentenceGenerator();
		Sentence sentence = sentenceGenerator.generateFromTokens(str);
		paragraph.addSentence(sentence);
	    }
	    text.addParagraph(paragraph);
	}
	return text;
    }

    /**
     * Assembling text from object
     */
    @Override
    public String getSourceText(Text text) {
	
	
	return null;
    }
}
