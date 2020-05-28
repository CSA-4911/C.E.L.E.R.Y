package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

public class CSVReader {

	private File file;
	
	public CSVReader(File file) {
		this.file = file;
	}
	
	public String[] read() {
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reader.nextLine().split(",");
	}
	
	public void setTextFields(ArrayList<JTextField> textFields, String[] values) {
		for (int i = 0; i < values.length; i++) {
			textFields.get(i).setText(values[i]);
		}
	}
	
}
