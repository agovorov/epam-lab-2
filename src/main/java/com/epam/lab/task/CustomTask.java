package com.epam.lab.task;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.display.DisplayStrategy;
import com.epam.lab.display.DisplayStrategyFactory;
import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.entity.token.Token;
import com.epam.lab.parser.entity.token.Word;
import com.epam.lab.task.exception.TaskException;

/**
 * My task
 * 
 * @author Govorov Andrey
 */
public class CustomTask implements Task {

    private Text text;
    private List<String> listOfTask;

    public CustomTask(Text text) {
	this.text = text;
	listOfTask = new ArrayList<String>();
    }

    @Override
    public void execute() throws TaskException {	
	if (!text.isEmpty()) {
	    // Get first sentence in first paragraph
	    Sentence firstSentence = text.getParagraph(0).getSentence(0);

	    // Each word
	    for (Token token : firstSentence) {
		if (token instanceof Word == false) {
		    continue;
		}

		// Search word in each paragraph and each sentence
		// Generate list of words
		Word tokenWord = (Word) token;

		boolean foundWord = false;
		int paragraphIndex = 0;
		int sentenceIndex = 0;
		for (Paragraph paragraph : text) {
		    paragraphIndex++;
		    for (Sentence sentence : paragraph) {
			sentenceIndex++;
			for (Token word : sentence) {
			    // Ignore first sentence in first paragraph
			    if (paragraphIndex == 1 && sentenceIndex == 1) {
				continue;
			    }

			    // We need only Word instance
			    if (word instanceof Word == false) {
				continue;
			    }

			    // Cast to Word
			    Word wordCast = (Word) word;
			    if (wordCast.compare(tokenWord)) {
				foundWord = true;
			    }
			}
		    }
		}

		if (!foundWord) {
		    listOfTask.add(tokenWord.valueOf());
		}
	    }
	}
    }

    @Override
    public void printData() {
	DisplayStrategy display = DisplayStrategyFactory.getWriter("console");
	display.show("Task words: ");
	display.show(listOfTask);
    }
}
