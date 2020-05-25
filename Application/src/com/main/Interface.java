package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	private ActionListeners actionListeners;
	
	private final int SLOTS = 20;
		
	public Interface() {
		frame = new JFrame();
		panel = new JPanel();
		actionListeners = new ActionListeners();
		
		addMenuBarSection();
		addMainSection();
	}
	
	private void addMenuBarSection() {		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");

		actionListeners.newItem = new JMenuItem("New");
		actionListeners.openItem = new JMenuItem("Open");
		actionListeners.saveItem = new JMenuItem("Save");
		actionListeners.cutItem = new JMenuItem("Cut");
		actionListeners.copyItem = new JMenuItem("Copy");
		actionListeners.pasteItem = new JMenuItem("Paste");
		
		fileMenu.add(actionListeners.newItem);
		fileMenu.add(actionListeners.openItem);
		fileMenu.add(actionListeners.saveItem);
		
		editMenu.add(actionListeners.cutItem);
		editMenu.add(actionListeners.copyItem);
		editMenu.add(actionListeners.pasteItem);
		
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
		
		actionListeners.submitBtn = new JButton("Submit");
		actionListeners.submitBtn.addActionListener(this);
		components.add(actionListeners.submitBtn);
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
		if (event.getSource().equals(actionListeners.submitBtn)) {
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
	
	public class ActionListeners {
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
