package com.epam.lab.prepare.action;

import java.util.List;

public interface Action {

    List<String> doAction(List<String> lines);
}
