package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

/**
 * Entity class for punctuation symbols
 * 
 * @author Govorov Andrey
 */
public class PunctuationMark extends Token {

    private Symbol symbol;

    public PunctuationMark(Symbol symbol) {
	super();
	this.symbol = symbol;
    }

    public PunctuationMark(String str) {
	super();
	this.symbol = new Symbol(str.charAt(0));
    }

    /**
     * Return symbol
     * 
     * @return symbol
     */
    public Symbol returnValue() {
	return symbol;
    }

    public String toString() {
	return getClass() + ": `" + symbol.returnSymbols() + "`";
    }
}