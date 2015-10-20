package com.epam.lab.parser.entity;

/**
 * Class for character
 * 
 * @author Govorov Andrey
 */
public class Symbol {
	private char symbol;

	public Symbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Is real symbol or control symbol
	 * 
	 * @param symbol
	 * @return 
	 */
	public boolean isLetter(char symbol) {
		return Character.isLetterOrDigit(symbol);
	}

	@Override
	public int hashCode() {
		final int prime = 50;
		int result = 1;
		result = prime * result + symbol;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (symbol != other.symbol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Symbol [symbol=" + symbol + "]";
	}
}
