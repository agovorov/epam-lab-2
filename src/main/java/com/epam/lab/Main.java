package com.epam.lab;

import java.io.File;
import java.io.IOException;

import com.epam.lab.files.Importer;

// http://www.javaportal.ru/java/ide/ten_t_eclipse.html
public class Main {
	public static void main(String[] args) {	
		if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Specify a file name as input arguments.\n" +
                            "Example:\n" +
                            ">: java -jar Lab2.jar \"io.txt\""
            );
        }
		
		// C:\tmp\epam-lab-2
		// File file = new File("C:\\tmp\\epam-lab-2\\io.txt");
		
		File file = new File( args[0] );
		
		String text = null;
		try {
			text = Importer.readFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(text);

		/*
        String filename = System.getProperty("user.dir")+"\\"+args[0];
        
		String text = null;
		try {
			text = Importer.readFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(text);
		*/
	}
}
