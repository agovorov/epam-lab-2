package com.epam.lab.io;

import java.util.List;

import com.epam.lab.io.exception.ReadingException;

/**
 * File read interface
 * 
 * @author Govorov Andrey
 */
public interface FileReader {

    List<String> readAllLines() throws ReadingException;
    
    String readToString() throws ReadingException;
}
