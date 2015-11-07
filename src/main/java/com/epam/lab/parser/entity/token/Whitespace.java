package com.epam.lab.parser.entity.token;

import com.epam.lab.parser.entity.Symbol;

public class Whitespace extends Token {
    private Symbol symbol;

    public Whitespace() {
        this.symbol = new Symbol(' ');
    }

    public String getValue() {
        return String.valueOf(symbol.getSymbol());
    }

    @Override
    public String toString() {
        return getClass() + ": [symbol=`" + symbol.getSymbol() + "`]";
    }
}
