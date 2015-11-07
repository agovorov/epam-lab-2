package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    /**
     * Constructor with String parameter
     *
     * @param str
     */
    public Word(String str) {
        symbols = new ArrayList<Symbol>();
        char[] character = str.toCharArray();
        for (char c : character) {
            Symbol symbol = new Symbol(c);
            symbols.add(symbol);
        }
    }

    /**
     * Constructor insert symbols in specified position
     *
     * @param index
     * @param str
     */
    public Word(int index, String str) {
        symbols = new ArrayList<Symbol>();
        char[] character = str.toCharArray();
        for (char c : character) {
            Symbol symbol = new Symbol(c);
            symbols.add(index, symbol);
        }
    }

    /**
     * Return list of symbols in word (Unmutable object)
     *
     * @return
     */
    public List<Symbol> getSymbols() {
        return new ArrayList<Symbol>(symbols);
    }

    /**
     * Add Symbol object in word
     *
     * @param symbol
     */
    public void addSymbol(Symbol symbol) {
        symbols.add(symbol);
    }

    /**
     * Add character in word
     *
     * @param c
     */
    public void addSymbol(char c) {
        Symbol symbol = new Symbol(c);
        symbols.add(symbol);
    }

    /**
     * Add character in word in specified position
     *
     * @param index
     * @param c
     */
    public void addSymbol(int index, char c) {
        Symbol symbol = new Symbol(c);
        symbols.add(index, symbol);
    }

    /**
     * Add Symbol object in word in specified position
     *
     * @param index
     * @param symbol
     */
    public void addSymbol(int index, Symbol symbol) {
        symbols.add(index, symbol);
    }

    /**
     * Return length of the collection
     *
     * @return Count on elements
     */
    public int count() {
        return symbols.size();
    }

    /**
     * Return string variant of Word object
     *
     * @return Text representation of object
     */
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : symbols) {
            result.append(symbol.getSymbol());
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
            sb1.append(symbol.getSymbol());
        }

        StringBuilder sb2 = new StringBuilder();
        for (Symbol symbol : word) {
            sb2.append(symbol.getSymbol());
        }

        return sb1.toString().equalsIgnoreCase(sb2.toString());
    }

    @Override
    public Iterator<Symbol> iterator() {
        return symbols.iterator();
    }

    @Override
    public String toString() {
        return getClass() + ": [symbols.size=" + symbols.size() + "]";
    }

    /**
     * Remove Symbol from Word object
     *
     * @param Symbol object
     */
    public void removeSymbol(Symbol s2) {
        symbols.remove(s2);
    }

    /**
     * Remove Symbols object from Word object by index
     *
     * @param index
     */
    public void removeSymbol(int index) {
        if (index < symbols.size()) {
            symbols.remove(index);
        }
    }
}