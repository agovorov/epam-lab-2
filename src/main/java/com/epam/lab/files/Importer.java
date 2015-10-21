package com.epam.lab.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Importer {
	private static final Logger logger = LogManager.getLogger(Importer.class);

	/**
	 * Read text from file
	 * 
	 * @param filename File name
	 * @return Stirng
	 */
	public static String readFile(String filename) {
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				result += sCurrentLine + "\n";
			}
		} catch (IOException e) {
			logger.error("Error while reading file `" + filename + "`", e);
		}
		return result;
	}
}
