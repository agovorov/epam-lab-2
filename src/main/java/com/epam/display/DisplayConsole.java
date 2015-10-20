package com.epam.display;

public class DisplayConsole implements DisplayStrategy {

	/**
	 * Display data in console
	 */
	@Override
	public void show(String data) {
		System.out.println("------ Console output -----");
		System.out.println(data);
	}

}
