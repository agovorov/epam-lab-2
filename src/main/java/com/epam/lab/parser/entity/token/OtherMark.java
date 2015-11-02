package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

/**
 * Entity class for unrecognized symbols
 * 
 * @author Govorov Andrey
 */
public class OtherMark extends Token {
    
    private Symbol symbol;

    public OtherMark(Symbol symbol) {
	super();
	this.symbol = symbol;
    }
    
    public OtherMark(String str) {
	super();
	this.symbol = new Symbol(str.charAt(0));
    }

    public Symbol returnValue() {
	return symbol;
    }
    
    public String toString() {
	return getClass() + ": `" + symbol.returnSymbols() + "`";
    }
}
