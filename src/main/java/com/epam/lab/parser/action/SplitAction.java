package com.epam.lab.parser.action;

import java.util.List;

public interface SplitAction {

    List<String> splitTo(List<String> lines);
    List<String> splitTo(String line);
}
