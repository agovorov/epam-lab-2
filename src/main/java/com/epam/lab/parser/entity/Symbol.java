package com.epam.lab.parser.entity;

/**
 * Class for character. Immutable object
 *
 * @author Govorov Andrey
 */
public class Symbol {
    private char letter;

    public Symbol(char c) {
        letter = c;
    }

    public char getSymbol() {
        return letter;
    }
}
