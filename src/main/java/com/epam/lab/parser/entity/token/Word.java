package com.epam.lab.parser.entity.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.Symbol;

/**
 * Word entity class
 * 
 * @author Govorov Andrey
 */
public class Word extends Token implements Iterable<Symbol> {

    private List<Symbol> symbols;

    public Word() {
	symbols = new ArrayList<Symbol>();
    }

    public Word(String str) {
	symbols = new ArrayList<Symbol>();
	char[] character = str.toCharArray();
	for (char c : character) {
	    Symbol symbol = new Symbol(c);
	    symbols.add(symbol);
	}
    }

    public List<Symbol> getSymbols() {
	return symbols;
    }

    public void addSymbol(Symbol symbol) {
	symbols.add(symbol);
    }

    public int count() {
	return symbols.size();
    }

    public String valueOf() {
	StringBuilder result = new StringBuilder();
	for (Symbol symbol : symbols) {
	    result.append(symbol.returnSymbols());
	}

	return result.toString();
    }

    /**
     * Compare two word objects
     * 
     * @param word
     * @return boolean
     */
    public boolean compare(Word word) {
	StringBuilder sb1 = new StringBuilder();
	for (Symbol symbol : symbols) {
	    sb1.append(symbol.returnSymbols());
	}

	StringBuilder sb2 = new StringBuilder();
	for (Symbol symbol : word) {
	    sb2.append(symbol.returnSymbols());
	}

	return sb1.toString().equalsIgnoreCase(sb2.toString());
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