package com.epam.lab.parser.entity.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.Symbol;

/**
 * Number entity class
 * 
 * @author Govorov Andrey
 */
public class Number extends Token implements Iterable<Symbol> {

    private List<Symbol> symbols;
    
    public Number() {
	symbols = new ArrayList<Symbol>();
    }
    
    public Number(String str) {
	// Split string to character array
	symbols = new ArrayList<Symbol>();
	char[] character = str.toCharArray();
	for(char c : character) {
	    Symbol symbol = new Symbol( c );
	    symbols.add(symbol);
	}
    }

    @Override
    public Iterator<Symbol> iterator() {
	return symbols.iterator();
    }
    
    public String toString() {
	StringBuilder result = new StringBuilder();
	for (Symbol symbol : symbols) {
	    result.append(symbol.returnSymbols());
	}
	return getClass() + ": " + result.toString();
    }
}
