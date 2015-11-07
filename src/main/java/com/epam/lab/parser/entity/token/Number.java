package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    /**
     * Create number token from string. Splitting string into char array first ant then
     * create Symbol object
     *
     * @param str
     */
    public Number(String str) {
        symbols = new ArrayList<Symbol>();
        char[] character = str.toCharArray();
        for (char c : character) {
            Symbol symbol = new Symbol(c);
            symbols.add(symbol);
        }
    }

    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : symbols) {
            result.append(symbol.getSymbol());
        }

        return result.toString();
    }


    @Override
    public Iterator<Symbol> iterator() {
        return symbols.iterator();
    }

    public String toString() {
        return getClass() + "[ symbols.size= " + symbols.size() + "]";
    }
}
