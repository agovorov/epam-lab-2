package com.epam.lab.prepare;

import java.util.Arrays;
import java.util.List;

import com.epam.lab.prepare.action.Action;
import com.epam.lab.prepare.action.DeleteEmptyLinesAction;
import com.epam.lab.prepare.action.ReplaceAllAction;
import com.epam.lab.prepare.action.TrimAction;
import com.epam.lab.prepare.exception.PreparationExceptions;

public class SimplePreporator implements Preparator {

    //
    // TODO: Интересное поведение IDE при одном элементе массива
    //
    private List<Action> defaultActions = Arrays.asList(
	new DeleteEmptyLinesAction(),
	new ReplaceAllAction("\uFEFF", ""), 	// UTF BOM symbol
	new ReplaceAllAction(" {2,}", " "),	// 2 or more whitespaces 
	new ReplaceAllAction("\t", " "), 	// Tab symbol 
	new TrimAction()
    );

    @Override
    public List<String> prepareText(List<String> text) throws PreparationExceptions {
	if (!defaultActions.isEmpty()) {
	    for (Action action : defaultActions) {
		text = action.doAction(text);
	    }
	}
	return text;
    }
}
