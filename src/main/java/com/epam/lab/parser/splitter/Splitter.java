package com.epam.lab.parser.splitter;

import java.util.List;

import com.epam.lab.parser.action.SplitAction;

public interface Splitter {

    List<String> action(List<String> text, SplitAction splitAction);

    List<String> action(String text, SplitAction splitAction);
}
