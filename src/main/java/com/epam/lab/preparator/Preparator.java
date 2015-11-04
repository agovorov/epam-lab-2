package com.epam.lab.preparator;

import com.epam.lab.preparator.exception.PreparationExceptions;

import java.util.List;

/**
 * Time: 11.13 Date: 27.10.2015
 * <p/>
 * Prepare entity interface
 *
 * @author Govorov Andrey
 */
public interface Preparator {

    List<String> prepareText(List<String> text) throws PreparationExceptions;

    String prepareText(String text) throws PreparationExceptions;
}
