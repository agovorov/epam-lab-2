package com.epam.lab.parser.splitter;

import com.epam.lab.parser.action.SplitAction;

import java.util.List;

public interface Splitter {

    List<String> action(String text, SplitAction splitAction);
}
