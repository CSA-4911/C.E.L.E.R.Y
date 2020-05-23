package com.main;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Page {
	
	private Interface gui;
	private JFrame frame;
	private JPanel panel;
	private String csvFilePath;
	
	private ArrayList<JComponent> components;
	private ArrayList<JTextField> textFields;
	
	private final int SLOTS = 20;

	public Page(Interface gui, JFrame frame, JPanel panel) {
		components = new ArrayList<JComponent>();
		textFields = new ArrayList<JTextField>();
		
		components.add(new JLabel("Archetype Name"));
		addValueFields();
		for (int i = 1; i <= SLOTS; i++) {
			components.add(new JLabel("Attribute " + i));
			addValueFields();
		}
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(gui);
		components.add(submitBtn);
	}
	
	public Page(Interface gui, JFrame frame, JPanel panel, String csvFilePath) {
		this(gui, frame, panel);
		// TODO: add code to read csv file and write the contents into the interface
		// this code will be used to open existing files
	}
	
	private void addValueFields() {
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		
		components.add(textField1);
		components.add(new JLabel("Value"));
		components.add(textField2);
		
		textFields.add(textField1);
		textFields.add(textField2);
	}
	
}
