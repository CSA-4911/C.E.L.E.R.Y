package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.utils.CSVReader;
import com.utils.CSVWriter;

public class Interface implements ActionListener {
		
	private JFrame frame;
	private JPanel panel;
	
	private ArrayList<JComponent> components;
	private ArrayList<JTextField> textFields;
	
	private ComponentFields componentFields;
	
	private final int SLOTS = 20;
		
	public Interface() {
		frame = new JFrame();
		panel = new JPanel();
		componentFields = new ComponentFields();
		
		addMenuBarSection();
		addMainSection();
	}
	
	private void addMenuBarSection() {		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");

		componentFields.newItem = new JMenuItem("New");
		componentFields.openItem = new JMenuItem("Open");
		componentFields.saveItem = new JMenuItem("Save");
		componentFields.cutItem = new JMenuItem("Cut");
		componentFields.copyItem = new JMenuItem("Copy");
		componentFields.pasteItem = new JMenuItem("Paste");
		
		fileMenu.add(componentFields.newItem);
		fileMenu.add(componentFields.openItem);
		fileMenu.add(componentFields.saveItem);
		
		editMenu.add(componentFields.cutItem);
		editMenu.add(componentFields.copyItem);
		editMenu.add(componentFields.pasteItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
			menuBar.getMenu(i).setFont(new Font("", Font.PLAIN, 25));
			for (int j = 0; j < menuBar.getMenu(i).getItemCount(); j++) {
				menuBar.getMenu(i).getItem(j).addActionListener(this);
				menuBar.getMenu(i).getItem(j).setFont(new Font("", Font.PLAIN, 25));
			}
		}
						
		frame.setJMenuBar(menuBar);
	}
	
	private void addMainSection() {
		components = new ArrayList<JComponent>();
		textFields = new ArrayList<JTextField>();
		
		components.add(new JLabel("Archetype Name"));
		addValueFields();
		for (int i = 1; i <= SLOTS; i++) {
			components.add(new JLabel("Attribute " + i));
			addValueFields();
		}
		
		componentFields.submitBtn = new JButton("Submit");
		componentFields.submitBtn.addActionListener(this);
		components.add(componentFields.submitBtn);
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
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(new GridLayout(0, 4));
		
		for (JComponent c : components) {
			c.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			c.setFont(new Font("", Font.PLAIN, 50));
			panel.add(c);
		}
		
		for (JTextField t : textFields) {
			t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("C.E.L.E.R.Y");
		frame.setVisible(true);
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(componentFields.submitBtn)) {
			CSVWriter writer = new CSVWriter("Output.csv");
			writer.write(textFields);
		} else if (event.getSource().equals(componentFields.newItem)) {
			for (JTextField t : textFields) {
				t.setText("");
			}
		} else if (event.getSource().equals(componentFields.openItem)) {
			JFileChooser chooser = new JFileChooser();
			chooser.setPreferredSize(new Dimension(1200, 700));
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				CSVReader reader = new CSVReader(chooser.getSelectedFile());
				reader.setTextFields(textFields, reader.read());
			}
		} else if (event.getSource().equals(componentFields.saveItem)) {
			JFileChooser chooser = new JFileChooser();
			chooser.setPreferredSize(new Dimension(1200, 700));
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				CSVWriter writer = new CSVWriter("stored files/" + chooser.getSelectedFile().getName() + ".csv");
				writer.write(textFields);
			}
		}
	}
	
	public class ComponentFields {
		// MENU ITEMS
		public JMenuItem newItem;
		public JMenuItem openItem;
		public JMenuItem saveItem;
		public JMenuItem cutItem;
		public JMenuItem copyItem;
		public JMenuItem pasteItem;
		
		// BUTTONS
		public JButton submitBtn;
	}

}
