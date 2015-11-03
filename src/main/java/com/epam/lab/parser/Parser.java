package com.epam.lab.parser;

import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;

public interface Parser {

    Text parse(String string) throws ParsingException;
}
