package com.utils;

import java.io.File;
import java.util.Scanner;

public class CSVReader {

	private File file;
	
	public CSVReader(File file) {
		this.file = file;
	}
	
	public String[][] read() {
		Scanner reader = null;
		String[][] values = null;
		try {
			reader = new Scanner(file);			
			String[] rawValues = reader.nextLine().split(",");
			values = new String[2][rawValues.length / 2];
			int index = 0;
			for (int i = 0; i < rawValues.length; i+=2) {
				values[0][index] = rawValues[i];
				values[1][index] = rawValues[i + 1];
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return values;
	}
	
}
