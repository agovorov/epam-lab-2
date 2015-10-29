package com.epam.lab.display;

import java.util.List;
/**
 * @deprecated
 */
public class DisplayConsole implements DisplayStrategy {

	/**
	 * Display data in console
	 */
	@Override
	public void show(String data) {
		System.out.println(data);
	}
	
	/**
	 * Display list in console
	 */
	@Override
	public void show(List<String> data) {
		System.out.println(data);
	}
}
