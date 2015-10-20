package com.epam.lab.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Importer {
	public static String readFile(String filename) {
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				result += sCurrentLine + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
