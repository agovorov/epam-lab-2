package com.epam.lab.textmanager;

import com.epam.lab.io.FileReader;
import com.epam.lab.io.SimpleFileReader;
import com.epam.lab.io.exception.ReadingException;
import com.epam.lab.parser.Parser;
import com.epam.lab.parser.RegexParser;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;
import com.epam.lab.preparator.Preparator;
import com.epam.lab.preparator.SimplePreporator;
import com.epam.lab.task.CustomTask;
import com.epam.lab.task.Task;
import com.epam.lab.task.exception.TaskException;
import com.epam.lab.textmanager.exception.TextManagerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of simple text manager
 *
 * @author Govorov Andrey
 */
public class SimpleTextManager implements TextManager {

    private static final Logger logger = LogManager.getLogger(SimpleTextManager.class);
    private FileReader reader;
    private Preparator preparator;
    private Parser parser;

    public SimpleTextManager(String filename) {
        this.reader = new SimpleFileReader(filename);
        this.preparator = new SimplePreporator();
        this.parser = new RegexParser();
    }

    @Override
    public void execute() throws TextManagerException {
        try {
            String content = reader.readToString();
            // content = preparator.prepareText(content);
            Text text = parser.parse(content);

            // Equal text
            String str = text.getPlainText();
            if (content.equals(str)) {
                System.out.println("Text is equal");
            } else {
                System.out.println("Text is NOT equal");
            }

            // Execute task
            Task task = new CustomTask(text);
            task.execute();
            task.printData();
        } catch (ReadingException e) {
            logger.error("Unable to read file", e);
            throw new TextManagerException("Reading error", e);
//        } catch (PreparationExceptions e) {
//            logger.error("Unable to prepare file", e);
//            throw new TextManagerException("Preporation error", e);
        } catch (ParsingException e) {
            logger.error("Unable to parse text", e);
            throw new TextManagerException("Unable to parse text", e);
        } catch (TaskException e) {
            logger.error("Unable to execute task", e);
            throw new TextManagerException("Unable to execute task", e);
        }
    }
}
