package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

/**
 * Entity class for punctuation symbols
 *
 * @author Govorov Andrey
 */
public class PunctuationMark extends Token {

    private Symbol symbol;

    public PunctuationMark() {
        this.symbol = new Symbol(' ');
    }

    public PunctuationMark(Symbol symbol) {
        super();
        this.symbol = symbol;
    }

    public PunctuationMark(String str) {
        super();
        this.symbol = new Symbol(str.charAt(0));
    }

    public String getValue() {
        return String.valueOf(symbol.getSymbol());
    }

    @Override
    public String toString() {
        return getClass() + ": [symbol=`" + symbol.getSymbol() + "`]";
    }
}