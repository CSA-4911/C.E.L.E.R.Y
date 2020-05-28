package com.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	private JFrame frame;
	private JPanel panel;
	
	private String name;
	
	public Window(String name) {
		frame = new JFrame();
		panel = new JPanel();
		
		this.name = name;
	}
	
	public void addComponent(JComponent component) {
		component.setFont(new Font("", Font.PLAIN, 30));
		panel.add(component);
	}
	
	public void finish() {
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setLayout(new GridLayout(0, 3));
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(new Dimension(1200, 200));
		frame.setTitle(name);
		frame.setVisible(true);
		frame.pack();
	}
	
}
