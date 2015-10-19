package com.epam.lab.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Importer {
	public static String readFile(File file2) throws IOException {
        
		System.out.println(file2);
		
		Files.readAllLines(file2.toPath(), Charset.forName("utf-8"));
		
		/*
		List<String> result = Files.readAllLines(
				file2.toPath(), Charset.forName("utf-8")
        );
        
		       
		System.out.println(file2.toPath());*/
		//byte[] encoded = Files.readAllBytes(file.toPath());
		//System.out.println(encoded);
		return "test";
		
        
		/*
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
		*/
	}
}
