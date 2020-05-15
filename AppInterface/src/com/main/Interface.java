package com.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface implements ActionListener {
		
	private JFrame frame;
	private JPanel panel;
	
	private JTextField robotNameField;
	private JTextField attributeField1;
	private JTextField attributeField2;
	private JTextField attributeField3;
	
	private JLabel robotNameLabel;
	private JLabel attributeLabel1;
	private JLabel attributeLabel2;
	private JLabel attributeLabel3;
	
	private JButton submitBtn;
	
	private List<Component> components;
	
	// TODO: labels and fields are always grouped (think about making it a class to group them)
	public Interface() {
		frame = new JFrame();
		panel = new JPanel();
		
		robotNameLabel = new JLabel("Archetype Name");
		robotNameField = new JTextField(20);
		
		attributeLabel1 = new JLabel("Attritbute 1");
		attributeField1 = new JTextField(20);
		
		attributeLabel2 = new JLabel("Attritbute 2");
		attributeField2 = new JTextField(20);
		
		attributeLabel3 = new JLabel("Attritbute 3");
		attributeField3 = new JTextField(20);
		
		submitBtn = new JButton("Submit");
		
		components = Arrays.asList(
				robotNameLabel,
				robotNameField,
				attributeLabel1,
				attributeField1,
				attributeLabel2,
				attributeField2,
				attributeLabel3,
				attributeField3,
				submitBtn
				);
	}
	
	// TODO: clean up this MESS!!!
	public void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0, 4));
		
		submitBtn.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
//		robotNameField.setFont(new Font("", Font.PLAIN, 100));
//		submitBtn.setFont(new Font("", Font.PLAIN, 100));
		submitBtn.addActionListener(this);
		
		for (Component c : components) {
			panel.add(c);
		}
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Interface Test");
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Robot Name: " + robotNameField.getText());
	}

}