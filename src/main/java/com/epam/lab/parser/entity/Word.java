package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Word {
	// Work is a array of symbols
	private List<Symbol> word;

	/**
	 * Default constructor
	 */
	public Word() {
		word = new ArrayList<>();
	}
	
	public Word(List<Symbol> symbols) {
		word = new ArrayList<>();
		word.addAll(symbols);
	}
}
