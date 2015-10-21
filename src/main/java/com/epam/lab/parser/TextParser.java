package com.epam.lab.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
		Pattern symbols = new Pattern(content, 0);
		List letterList = returnList(content, symbols);
		
		return content;
	}
	
	private List returnList(String str, Pattern pattern) {
		List<String> result = new ArrayList<String>();
		
		str.split(regexp);
		return result; 
	}

	/**
	 * Display data
	 */
	public void displayInfo(DisplayStrategy display) {
		display.show(content);
	}

	/**
	 * Doing task
	 */
	public void doTask() {
		// TODO Auto-generated method stub
		
	}
}
