package com.epam.lab.parser;

import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;
import com.epam.lab.parser.splitter.RegexSplitter;
import com.epam.lab.property.RegexPropertyManager;

import java.util.List;

/**
 * Simple parser implementation
 *
 * @author Govorov Andrey
 */
public class RegexParser implements Parser {

    private final String PARAGRAPH_PATTERN_SPLIT = RegexPropertyManager.getInstance().getProperty("paragraph_regex");
    private final String SENTENCE_PATTERN_SPLIT = RegexPropertyManager.getInstance().getProperty("sentence_regex");

    private Text text;
    private RegexSplitter splitter;

    public RegexParser() {
        splitter = new RegexSplitter();
    }

    @Override
    public Text parse(String stringContent) throws ParsingException {
        text = new Text();

        // Splitting whole text to paragraphs
        List<String> paragraphList = splitter.splitText(stringContent, PARAGRAPH_PATTERN_SPLIT);
        for (String paragraphString : paragraphList) {
            Paragraph paragraph = new Paragraph();

            // Splitting each paragraph to sentences
            List<String> sentenceList = splitter.splitText(paragraphString, SENTENCE_PATTERN_SPLIT);
            if (!sentenceList.isEmpty()) {
                for (String s : sentenceList) {
                    paragraph.addSentence(s);
                }
            }
            text.addParagraph(paragraph);
        }
        return text;
    }
}
