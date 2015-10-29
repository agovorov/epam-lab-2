package com.epam.lab.parser.entity.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.epam.lab.parser.entity.Symbol;

public class Word extends Token implements Iterable<Symbol> {
	
	private List<Symbol> symbols;

	public Word() {
		symbols = new ArrayList<Symbol>();
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
	
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    for(Symbol symbol : symbols) {
		result.append( symbol.returnSymbols() );
	    }
	    return getClass() + ": " + result.toString();
	}

	@Override
	public Iterator<Symbol> iterator() {
		return symbols.iterator();
	}
}