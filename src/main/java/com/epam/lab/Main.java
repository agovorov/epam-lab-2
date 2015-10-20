package com.epam.lab;

import com.epam.display.DisplayStrategy;
import com.epam.display.DisplayStrategyFactory;
import com.epam.lab.parser.TextParser;
import com.epam.lab.files.Importer;

/**
 * Task 2: Создать программу обработки текста учебника по программированию с
 * использованием классов: Символ, Слово, Предложение, Знак препинания и др. Во
 * всех задачах с формированием текста заменять табуляции и последовательности
 * пробелов одним пробелом.
 * 
 * 14. В заданном тексте найти подстроку максимальной длины, являющуюся
 * палиндромом, т.е. читающуюся слева направо и справа налево одинаково.
 * 
 * Вопросы: 
 * 		- Знак препинания - отдельный класс или Symbol 
 * 		- Использовать LinkedList или ArrayList
 * 
 * @author Govorov Andrey
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException(
					"Specify a file name as input arguments.\n" + "Example:\n"
							+ ">: java -jar Lab2.jar \"io.txt\"");
		}

		// Where to display errors
		DisplayStrategy displayStrategy = DisplayStrategyFactory
				.getWriter("console");

		// Read files from txt file
		String text = Importer.readFile(args[0]);

		// Parse text
		TextParser parser = new TextParser(text);
		parser.parse();
		parser.displayInfo(displayStrategy);

	}
}
