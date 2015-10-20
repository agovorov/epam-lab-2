package com.epam.lab.display;

public class DisplayConsole2 implements DisplayStrategy {

	/**
	 * Display data in console
	 */
	@Override
	public void show(String data) {
		System.out.println("*** Console 2 output ***");
		System.out.println(data);
	}

}
