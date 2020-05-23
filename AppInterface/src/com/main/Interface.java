package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface implements ActionListener {
		
	private JFrame frame;
	private JPanel panel;
	
	private ArrayList<JComponent> components;
	private ArrayList<JTextField> textFields;
	
	private final int SLOTS = 20;
		
	public Interface() {
		frame = new JFrame();
		panel = new JPanel();
		
		components = new ArrayList<JComponent>();
		textFields = new ArrayList<JTextField>();
		
		components.add(new JLabel("Archetype Name"));
		addValueFields();
		for (int i = 1; i <= SLOTS; i++) {
			components.add(new JLabel("Attribute " + i));
			addValueFields();
		}
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);
		components.add(submitBtn);
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
	
	public void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(new GridLayout(0, 4));
		
		for (JComponent c : components) {
			c.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			c.setFont(new Font("", Font.PLAIN, 20));
			panel.add(c);
		}
		
		for (JTextField t : textFields) {
			t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
		// TODO: clean this menu bar up
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveAsItem = new JMenuItem("Save As");
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem cutItem = new JMenuItem("Cut");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");
		
		menuBar.setFont(new Font("", Font.PLAIN, 20));
		fileMenu.setFont(new Font("", Font.PLAIN, 20));
		editMenu.setFont(new Font("", Font.PLAIN, 20));
		newItem.setFont(new Font("", Font.PLAIN, 20));
		openItem.setFont(new Font("", Font.PLAIN, 20));
		saveAsItem.setFont(new Font("", Font.PLAIN, 20));
		cutItem.setFont(new Font("", Font.PLAIN, 20));
		copyItem.setFont(new Font("", Font.PLAIN, 20));
		pasteItem.setFont(new Font("", Font.PLAIN, 20));

		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveAsItem);
		
		newItem.addActionListener(this);
		
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		frame.setJMenuBar(menuBar);
		// end of clean up phase
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Interface Test");
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			PrintStream writer = new PrintStream("Output.csv");
			writer.print(textFields.get(0).getText());
			for (int i = 1; i < textFields.size(); i++) {
				writer.print("," + textFields.get(i).getText());
			}
			
			writer.close();
		} catch (Exception e) {
			System.err.print(e);
		}
	}

}
