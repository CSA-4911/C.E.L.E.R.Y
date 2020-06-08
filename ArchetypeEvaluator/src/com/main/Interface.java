package com.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.utils.CSVReader;
import com.utils.Evaluator;

public class Interface implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	
	private ComponentFields componentFields;
	
	private String[][] archetype1Values;
	private String[][] archetype2Values;
	
	public Interface() {
		frame = new JFrame();
		panel = new JPanel();
		componentFields = new ComponentFields();
		
		addMainSection();
	}
	
	public void addMainSection() {
		componentFields.archetype1Label = new JLabel("Archetype 1", SwingConstants.CENTER);
		componentFields.archetype2Label = new JLabel("Archetype 2", SwingConstants.CENTER);
		componentFields.results = new JLabel("", SwingConstants.CENTER);
		componentFields.archetype1Btn = new JButton("Select");
		componentFields.archetype2Btn = new JButton("Select");
		componentFields.compareBtn = new JButton("Compare");
		
		componentFields.archetype1Btn.addActionListener(this);
		componentFields.archetype2Btn.addActionListener(this);
		componentFields.compareBtn.addActionListener(this);
		
		panel.add(componentFields.archetype1Label);
		panel.add(new JLabel("vs", SwingConstants.CENTER));
		panel.add(componentFields.archetype2Label);
		panel.add(componentFields.archetype1Btn);
		panel.add(componentFields.compareBtn);
		panel.add(componentFields.archetype2Btn);
		panel.add(new JLabel());
		panel.add(componentFields.results);
	}
	
	public void initialize() {
		panel.setBorder(BorderFactory.createEmptyBorder(500, 50, 500, 50));
		panel.setLayout(new GridLayout(0, 3));
		
		for (Component c : panel.getComponents()) {
			c.setFont(new Font("", Font.PLAIN, 100));
		}
		
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Archetype Evaluator");
		frame.setVisible(true);
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(componentFields.archetype1Btn)) {
			JFileChooser chooser = new JFileChooser();
			chooser.setPreferredSize(new Dimension(1200, 700));
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				CSVReader reader = new CSVReader(chooser.getSelectedFile());
				archetype1Values = reader.read();
				componentFields.archetype1Label.setText(archetype1Values[0][0]);
			}
		} else if (event.getSource().equals(componentFields.archetype2Btn)) {
			JFileChooser chooser = new JFileChooser();
			chooser.setPreferredSize(new Dimension(1200, 700));
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				CSVReader reader = new CSVReader(chooser.getSelectedFile());
				archetype2Values = reader.read();
				componentFields.archetype2Label.setText(archetype2Values[0][0]);
			}
		} else if (event.getSource().equals(componentFields.compareBtn)) {
			Evaluator evaluator = new Evaluator(archetype1Values, archetype2Values);
			componentFields.results.setText(evaluator.evaluate());
			evaluator.showStats();
		}
	}
	
	public class ComponentFields {
		// LABELS
		public JLabel archetype1Label;
		public JLabel archetype2Label;
		public JLabel results;
		
		// BUTTONS
		public JButton archetype1Btn;
		public JButton archetype2Btn;
		public JButton compareBtn;
	}
	
}
