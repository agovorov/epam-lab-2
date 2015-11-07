package com.epam.lab.parser.splitter;

import java.util.List;

public interface Splitter {

    List<String> splitText(String text, String param);
}
