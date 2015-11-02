package com.epam.lab.prepare;

import java.util.Arrays;
import java.util.List;

import com.epam.lab.prepare.action.Action;
import com.epam.lab.prepare.action.DeleteEmptyLinesAction;
import com.epam.lab.prepare.action.ReplaceAllAction;
import com.epam.lab.prepare.action.TrimAction;
import com.epam.lab.prepare.exception.PreparationExceptions;

/**
 * Simple text preporator
 * 
 * @author Govorov Andrey
 *
 */
public class SimplePreporator implements Preparator {
    //
    // TODO: Интересное поведение IDE при одном элементе массива: пытается
    // изменить тип Actions на конкретную реализацию
    //

    // Default actions
    private List<Action> defaultActions = Arrays.asList(
	    new DeleteEmptyLinesAction(),
	    new ReplaceAllAction("\uFEFF", ""), // UTF BOM symbol
	    new ReplaceAllAction(" {2,}", " "), // 2 or more whitespaces
	    new ReplaceAllAction("\t", " "), // Tab symbol
	    new TrimAction()
    );

    /**
     * Executes every action
     * 
     * @param List of strings
     * @return Lines of prepared strings
     */
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
