package com.epam.lab.parser;

import java.util.List;

import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;

public interface Parser {

    @Deprecated
    Text parse(List<String> lines) throws ParsingException;

    Text parse(String string) throws ParsingException;
    
    String getSourceText(Text text);
}
