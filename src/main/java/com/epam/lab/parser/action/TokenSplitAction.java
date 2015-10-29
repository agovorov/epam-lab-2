package com.epam.lab.parser.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.lab.parser.entity.token.PunctuationMark;
import com.epam.lab.parser.entity.token.Token;

public class TokenSplitAction implements SplitAction {

    @Override
    public List<String> splitTo(List<String> lines) {
	/*List<Token> listToken = new ArrayList<Token>();
	String regex = "(([а-яА-Яa-zA-Z]+-[а-яА-Яa-zA-Z]+)|([а-яА-Яa-zA-Z]+)|([0-9]+)|[^[а-яА-Яa-zA-Z0-9])";
	
	String isWord = "([а-яА-Яa-zA-Z]+-[а-яА-Яa-zA-Z]+)";
	String isWord2 = "([а-яА-Яa-zA-Z])";
	String isNumber = "[0-9]+";
	String isPuntktuation = "[^а-яА-Яa-zA-Z]";
	
	Mathcer matcher = Pattern.compile(regex).matcher(line);
	*/
	
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> splitTo(String line) {
	// Sentence to token
	List<Token> listToken = new ArrayList<Token>();
	String regex = "(([а-яА-Яa-zA-Z]+-[а-яА-Яa-zA-Z]+)|([а-яА-Яa-zA-Z]+)|([0-9]+)|[^[а-яА-Яa-zA-Z0-9])";
	
	String isWord = "([а-яА-Яa-zA-Z]+-[а-яА-Яa-zA-Z]+)";
	String isWord2 = "([а-яА-Яa-zA-Z])";
	String isNumber = "[0-9]+";
	String isPuntktuation = "[^а-яА-Яa-zA-Z]";
	
	Matcher matcher = Pattern.compile(regex).matcher(line);
	while (matcher.find()) {
	    if (matcher.group(1).matcher(isWord)) {
		listToken.add(new Word( mathcer.group(1)) );
	    } else if (matcher.group(1).matches(isWord2)) {
		new Word( mathcer.group(1));
		//listToken.add();
	    } else if (matcher.group(1).matches(isNumber)) {
		new Number( mathcer.group(1) );
	    } else if (matcher.group(1).matches(isPuntktuation)) {
		new PunctuationMark(matches.group(1));
	    } else {
		new OtherMark(matches.group(1));
	    }
	}
	
	return new Sentence(listToken);
    }

}
