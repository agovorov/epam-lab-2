package com.epam.lab.parser;

import com.epam.lab.Main;
import com.epam.lab.display.DisplayStrategy;

public class TextParser {
	private String content = null;

	public TextParser(String content) {
		this.content = content;
	}

	/**
	 * Parse text
	 * @return
	 */
	public String parse() {
		
		
		return content;
	}

	/**
	 * Display data
	 */
	public void displayInfo(DisplayStrategy display) {
		display.show(content);
	}
}
