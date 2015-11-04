package com.epam.lab.preparator;

import com.epam.lab.preparator.action.Action;
import com.epam.lab.preparator.action.ReplaceAllAction;
import com.epam.lab.preparator.action.TrimAction;
import com.epam.lab.preparator.exception.PreparationExceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Simple text preporator
 *
 * @author Govorov Andrey
 */
public class SimplePreporator implements Preparator {
    //
    // TODO: Интересное поведение IDE при одном элементе массива: пытается
    // изменить тип Actions на конкретную реализацию
    //

    // Default actions
    private List<Action> defaultActions = Arrays.asList(
            new ReplaceAllAction("\uFEFF", ""), // UTF BOM symbol
            new ReplaceAllAction(" {2,}", " "), // 2 or more whitespaces
            new ReplaceAllAction("\t", " "),    // Tab symbol
            new TrimAction()
    );

    /**
     * Executes every action
     *
     * @param text
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

    @Override
    public String prepareText(String text) throws PreparationExceptions {
        if (!defaultActions.isEmpty()) {
            for (Action action : defaultActions) {
                text = action.doAction(text);
            }
        }
        return text;
    }
}
