package com.epam.lab.parser.entity;

/**
 * Class for character. Immutable object
 * 
 * @author Govorov Andrey
 */
public class Symbol {
    private char letter;

    public Symbol(char c) {
	super();
	letter = c;
    }

    public char returnSymbols() {
	return letter;
    }
}
