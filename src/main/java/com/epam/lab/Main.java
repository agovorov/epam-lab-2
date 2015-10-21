package com.epam.lab;

import org.apache.logging.log4j.*;

import com.epam.lab.display.DisplayStrategy;
import com.epam.lab.display.DisplayStrategyFactory;
import com.epam.lab.files.Importer;
import com.epam.lab.parser.TextParser;

/**
 * Создать программу обработки текста учебника по программированию с
 * использованием классов: Символ, Слово, Предложение, Знак препинания и др. Во
 * всех задачах с формированием текста заменять табуляции и последовательности
 * пробелов одним пробелом.
 * 
 * 3. Найти такое слово в первом предложении, которого нет ни в одном из
 * остальных предложений.
 * 
 * Вопросы: 
 * 	- Знак препинания: отдельный класс или Symbol 
 * 	- Использовать LinkedList или ArrayList 
 * 	- Как правильно использовать log4j. В каждом классе static final?
 * 
 * @author Govorov Andrey
 * @version 1.0
 */
public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		if (args.length != 1) {
			logger.error("Input file not specified.");
			throw new IllegalArgumentException(
					"Specify a file name as input arguments.\n" + "Example:\n"
							+ ">: java -jar Lab2.jar \"io.txt\"");
		}

		logger.info("System started.");

		// Where to print data
		DisplayStrategy displayStrategy = DisplayStrategyFactory
				.getWriter("console");

		// Read files from txt file
		String text = Importer.readFile(args[0]);

		// Parse text
		TextParser parser = new TextParser(text);
		parser.parse();
		parser.doTask();
		parser.displayInfo(displayStrategy);
	}
}
