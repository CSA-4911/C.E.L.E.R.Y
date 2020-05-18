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
	private JTextField valueFieldRobot;
	private JTextField valueField1;
	private JTextField valueField2;
	private JTextField valueField3;

	private JLabel robotNameLabel;
	private JLabel attributeLabel1;
	private JLabel attributeLabel2;
	private JLabel attributeLabel3;
	private JLabel valueLabelRobot;
	private JLabel valueLabel1;
	private JLabel valueLabel2;
	private JLabel valueLabel3;
	
	private JButton submitBtn;
	
	private List<Component> components;
	private List<JTextField> textFields;
	
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
		
		valueLabelRobot = new JLabel("Value");
		valueFieldRobot = new JTextField(20);
		
		valueLabel1 = new JLabel("Value");
		valueField1 = new JTextField(20);
		
		valueLabel2 = new JLabel("Value");
		valueField2 = new JTextField(20);
		
		valueLabel3 = new JLabel("Value");
		valueField3 = new JTextField(20);
				
		submitBtn = new JButton("Submit");
		
		components = Arrays.asList(
				robotNameLabel,
				robotNameField,
				valueLabelRobot,
				valueFieldRobot,
				attributeLabel1,
				attributeField1,
				valueLabel1,
				valueField1,
				attributeLabel2,
				attributeField2,
				valueLabel2,
				valueField2,
				attributeLabel3,
				attributeField3,
				valueLabel3,
				valueField3,
				submitBtn
				);
		
		textFields = Arrays.asList(
				valueFieldRobot,
				attributeField1,
				valueField1,
				attributeField2,
				valueField2,
				attributeField3,
				valueField3
				);
	}
	
	// TODO: clean up this MESS!!!
	public void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0, 4));
		
		submitBtn.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		submitBtn.addActionListener(this);
		
		for (Component c : components) {
			c.setFont(new Font("", Font.PLAIN, 50));
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
		String output = robotNameField.getText();
		for (JTextField t : textFields) {
			output += "," + t.getText();
		}		
	}

}