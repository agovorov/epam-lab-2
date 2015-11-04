package com.epam.lab;

import com.epam.lab.parser.Parser;
import com.epam.lab.parser.SimpleParser;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.exception.ParsingException;

public class ParseDemo {

    public static void main(String[] args) {
        String str = "Плазменное образование сингулярно отталкивает расширяющийся электрон. "
                + "Колебание квазипериодично синхронизует осциллятор. Газ, в согласии с традиционными представлениями, "
                + "противоречиво облучает солитон. \n"
                + "Экситон возбудим. Частица, в первом приближении, индуцирует термодинамический объект почти "
                + "так же, как в резонаторе газового лазера. ";

        Parser parser = new SimpleParser();
        try {
            Text text = parser.parse(str);
            text.showStructure();

            // Выводим текст
            System.out.println("\n\nResult: ");
            System.out.println(text.getText());
        } catch (ParsingException e) {
            e.printStackTrace();
        }
    }
}
