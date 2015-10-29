package com.epam.lab.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.io.exception.ReadingException;

/**
 * Simple file reader
 * 
 * @author Andrey Govorov
 */
public class SimpleFileReader implements FileReader {
    private String filename;
    private static final Logger logger = LogManager.getLogger(SimpleFileReader.class);

    public SimpleFileReader(String filename) {
	super();
	this.filename = filename;
    }

    /**
     * Read text file in UTF8 charset and return String value
     */
    @Override
    public List<String> readAllLines() throws ReadingException {
	File file = new File(filename);
	if (!file.exists()) {
	    logger.error("Specified file '" + filename + "' does not exist.");
	    throw new ReadingException("Specified file '" + filename + "' does not exist.");
	}

	try {
	    List<String> result = Files.readAllLines(file.toPath(), Charset.forName("utf-8"));

	    if (result.isEmpty()) {
		logger.error("File is empty `" + filename + "`");
		throw new ReadingException("Extracted list is empty.");
	    }

	    return result;
	} catch (IOException e) {
	    logger.error("Error while reading file `" + filename + "`", e);
	    throw new ReadingException("I/O error. Check the file.", e);
	}
    }
}
