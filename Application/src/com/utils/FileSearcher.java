package com.utils;

import java.io.File;

public class FileSearcher {

	private String directory;
	
	public FileSearcher(String directory) {
		this.directory = directory;
	}
	
	public File search(String fileName) {
		File folder = new File(directory);
		for (File file : folder.listFiles()) {
			if (fileName.equals(file.getName())) {
				return file;
			}
		}
		
		return null;
	}
	
}
