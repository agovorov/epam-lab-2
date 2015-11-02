package com.epam.lab.display;

import java.util.List;

import com.epam.lab.parser.entity.Paragraph;
import com.epam.lab.parser.entity.Sentence;
import com.epam.lab.parser.entity.Text;
import com.epam.lab.parser.entity.token.Token;

/**
 * Display strategy for output data
 *  
 * @author Govorov Andrey
 */
public class DisplayConsole implements DisplayStrategy {

    /**
     * Display String data
     * 
     * @param data Display string
     */
    @Override
    public void show(String data) {
	System.out.println(data);
    }
    
    /**
     * Display List<String> data
     * 
     * @param list List of sting
     */
    @Override
    public void show(List<String> list) {
	System.out.println(list);
    }

    /**
     * Display Text object in tree view
     * 
     * @param text Displya Text object
     */
    @Override
    public void show(Text text) {
	if (!text.isEmpty()) {
	    for (Paragraph paragraph : text) {
		System.out.println(paragraph);

		for (Sentence sentence : paragraph) {
		    System.out.println("\t" + sentence);

		    for (Token word : sentence) {
			System.out.println("\t\t" + word);
		    }
		}
	    }
	}
    }
}
