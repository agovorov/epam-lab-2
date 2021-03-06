package com.epam.lab;

import com.epam.lab.textmanager.SimpleTextManager;
import com.epam.lab.textmanager.TextManager;
import com.epam.lab.textmanager.exception.TextManagerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Создать программу обработки текста учебника по программированию с
 * использованием классов: Символ, Слово, Предложение, Знак препинания и др. Во
 * всех задачах с формированием текста заменять табуляции и последовательности
 * пробелов одним пробелом.
 *
 * @author Govorov Andrey
 * @version 1.0
 */
public class Main {

    private static final int ARG_FILENAME = 0;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("System started.");
        if (args.length != 1) {
            logger.error("Input file not specified.");
            throw new IllegalArgumentException(
                    "Specify a file name as input arguments.\n" + "Example:\n" + ">: java -jar Lab2.jar \"io.txt\"");
        }

        // Create text manager
        String filename = args[ARG_FILENAME];
        TextManager textManager = new SimpleTextManager(filename);
        try {
            textManager.execute();
        } catch (TextManagerException e) {
            logger.error("TextManager exception", e);
        }
    }
}
