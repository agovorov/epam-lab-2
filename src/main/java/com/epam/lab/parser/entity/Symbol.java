package com.epam.lab.parser.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for character
 * 
 * @author Govorov Andrey
 */
public class Symbol {
    private char letter;

    public Symbol() {

    }
    
    public void setSymbol(char c) {
	letter = c;
    }

    public char returnSymbols() {
	return letter;
    }

    /**
     * Is real symbol or control symbol
     * 
     * @param symbol
     * @return
     */
    public static boolean isLetter(char symbol) {
	return Character.isLetterOrDigit(symbol);
    }
}
