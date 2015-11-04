package com.epam.lab.preparator.action;

import java.util.List;

/**
 * Actions that should be executed on every lines of text
 *
 * @author Govorov Andrey
 */
public interface Action {

    List<String> doAction(List<String> lines);

    String doAction(String text);
}
