package com.utils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Evaluator {
	
	private String[][] archetype1Values;
	private String[][] archetype2Values;
		
	public Evaluator(String[][] archetype1Values, String[][] archetype2Values) {
		this.archetype1Values = archetype1Values;
		this.archetype2Values = archetype2Values;
	}
	
	// TODO: fix this janked evaluating system LOL
	public String evaluate() {
		int archetype1Tally = 0;
		int archetype2Tally = 0;
		for (int i = 0; i < archetype1Values[1].length; i++) {
			if (new Scanner(archetype1Values[1][i]).nextInt() > new Scanner(archetype2Values[1][i]).nextInt()) {
				archetype1Tally++;
			} else if (new Scanner(archetype2Values[1][i]).nextInt() > new Scanner(archetype1Values[1][i]).nextInt()) {
				archetype2Tally++;
			}
		}
		
		if (archetype1Tally > archetype2Tally) {
			return archetype1Values[0][0] + " WINS!";
		} else if (archetype2Tally > archetype1Tally) {
			return archetype2Values[0][0] + " WINS!";
		}
		
		return "TIE!";
	}
	
	public void showStats() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		panel.add(new JLabel());
		panel.add(new JLabel(archetype1Values[0][0]));
		panel.add(new JLabel(archetype2Values[0][0]));
		for (int i = 0; i < archetype1Values[0].length; i++) {
			if (i == 0) {
				panel.add(new JLabel("ID Number"));
			} else {
				panel.add(new JLabel(archetype1Values[0][i]));
			}
			
			panel.add(new JLabel(archetype1Values[1][i]));
			panel.add(new JLabel(archetype2Values[1][i]));
		}
		
		for (Component c : panel.getComponents()) {
			c.setFont(new Font("", Font.PLAIN, 50));
		}
		
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(new GridLayout(0, 3));
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(new Dimension(1200, 1400));
		frame.setTitle("Statistics");
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}
	
}
