package com.epam.lab.parser.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Govorov Andrey
 * @deprecated
 */
public final class Tool {
    // No extension
    private Tool() {
    }

    public static String convertToString(List<String> str) {
	StringBuilder sb = new StringBuilder();
	if (!str.isEmpty()) {
	    for (String s : str) {
		sb.append(s);
		sb.append("\n");
	    }
	}
	return sb.toString();
    }

    /**
     * Split text on the parts depends of pattern
     * 
     * @param str
     *            input text
     * @param pattern
     * @return
     */
    public static List returnList(String str, String pattern, boolean removePunctuation) {
	List list = new ArrayList<String>();
	String[] splittedText = str.split(pattern);
	for (String textEntity : splittedText) {
	    textEntity = textEntity.trim();
	    boolean hasData = !textEntity.isEmpty();
	    if (hasData) {
		if (removePunctuation) {
		    textEntity = Tool.removePunctuationMark(textEntity);
		}
		// list.add("\"" + textEntity.trim() + "\"");
		list.add(textEntity.trim());
	    }
	}
	return list;
    }

    /**
     * Remove all "," and "."
     * 
     * @param str
     * @return String
     */
    public static String removePunctuationMark(String str) {
	return str.replaceAll("\\.|\\,|\\;|\"", " ");
    }

    /**
     * Remove new line symbols from string
     * 
     * @param str
     * @return
     */
    /*
     * public static String removeNewLineSymbol(String str) { return str;
     * //return str.replaceAll("\n|\r\n", " "); }
     */

    /**
     * Is UTF-8 BOM character
     * 
     * @deprecated
     * @param character
     * @return
     */
    public static boolean isBOMCharacter(char character) {
	return "\uFEFF".charAt(0) == character;
    }
}
