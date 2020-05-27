package com.utils;

import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JTextField;

public class CSVWriter {

	private String fileName;
	
	public CSVWriter(String fileName) {
		this.fileName = fileName;
	}
	
	public void write(ArrayList<JTextField> textFields) {
		try {
			PrintStream writer = new PrintStream(fileName);
			writer.print(textFields.get(0).getText());
			for (int i = 1; i < textFields.size(); i++) {
				writer.print("," + textFields.get(i).getText());
			}
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
