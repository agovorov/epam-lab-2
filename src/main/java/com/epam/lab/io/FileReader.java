package com.epam.lab.io;

import com.epam.lab.io.exception.ReadingException;

import java.util.List;

/**
 * File read interface
 *
 * @author Govorov Andrey
 */
public interface FileReader {

    List<String> readAllLines() throws ReadingException;

    String readToString() throws ReadingException;
}
