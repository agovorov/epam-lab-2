package com.epam.lab.prepare;

import java.util.List;
import com.epam.lab.prepare.exception.PreparationExceptions;

/**
 * Time: 11.13 Date: 27.10.2015
 * 
 * Prepare entity interface
 * 
 * @author Govorov Andrey
 */
public interface Preparator {

    List<String> prepareText(List<String> text) throws PreparationExceptions;
}
