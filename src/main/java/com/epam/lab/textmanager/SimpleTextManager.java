package com.epam.lab.textmanager;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.io.FileReader;
import com.epam.lab.io.SimpleFileReader;
import com.epam.lab.io.exception.ReadingException;
import com.epam.lab.parser.Parser;
import com.epam.lab.parser.SimpleParser;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;
import com.epam.lab.prepare.Preparator;
import com.epam.lab.prepare.SimplePreporator;
import com.epam.lab.prepare.exception.PreparationExceptions;
import com.epam.lab.textmanager.exception.TextManagerException;

public class SimpleTextManager implements TextManager {

    private FileReader reader;
    private Preparator preparator;
    private Parser parser;
    private static final Logger logger = LogManager.getLogger(SimpleTextManager.class);

    public SimpleTextManager(String filename) {
	this.reader = new SimpleFileReader(filename);
	this.preparator = new SimplePreporator();
	this.parser = new SimpleParser();
    }

    @Override
    public void execute() throws TextManagerException {

	try {
	    List<String> lines = reader.readAllLines();
	    lines = preparator.prepareText(lines);
	    Text text = parser.parse(lines);

	    // Test line
	    // System.out.println("RESULT: ");
	    // System.out.println(text);
	    // for (Text txt : text) {
	    // System.out.println(text);
	    // }
	} catch (PreparationExceptions e) {
	    logger.error("Unable to prepare file", e);
	    throw new TextManagerException("Preporation error", e);
	} catch (ReadingException e) {
	    logger.error("Unable to read file", e);
	    throw new TextManagerException("Reading error", e);
	} catch (ParsingException e) {
	    logger.error("Unable to parse text", e);
	    throw new TextManagerException("Unable to parse text", e);
	}
    }
}
