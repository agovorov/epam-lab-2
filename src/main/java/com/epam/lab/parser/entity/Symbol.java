package com.epam.lab.parser.entity;

/**
 * Class for character
 * 
 * @author Govorov Andrey
 */
public class Symbol {
    private char letter;

    public Symbol(char c) {
	super();
	letter = c;
    }

    public void setSymbol(char c) {
	letter = c;
    }

    public char returnSymbols() {
	return letter;
    }
}
