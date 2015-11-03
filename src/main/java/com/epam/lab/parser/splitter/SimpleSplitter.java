package com.epam.lab.parser.splitter;

import java.util.List;

import com.epam.lab.parser.action.SplitAction;

/**
 * Simple text splitter
 * 
 * @author Govorov Andrey
 */
public class SimpleSplitter implements Splitter {

    @Override
    public List<String> action(String text, SplitAction splitAction) {
	return splitAction.splitTo(text);
    }
}
