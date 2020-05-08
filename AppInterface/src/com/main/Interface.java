package com.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface {

    private static Interface gui;
    
    private JFrame frame;
    private JPanel panel;
    private List<JButton> buttons;

    public Interface() {
        frame = new JFrame();
        panel = new JPanel();
    }
    
    public static Interface getInstance() {
        if (gui == null) {
            gui = new Interface();
        }
        
        return gui;
    }
    
    public void initialize() {
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		panel.setLayout(new GridLayout(0, 3));
        createPage();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.add(panel, BorderLayout.CENTER);
	    frame.setPreferredSize(screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("C.E.L.E.R.Y");
		frame.pack();
    }
    
    public void createPage() {
		removeAllButtons();
        		
        // TODO: STILL UNDER CONSTRUCTION
		// for (JButton b : buttons) {
// 			b.setFont(new Font("", Font.PLAIN, 100));
// 			panel.add(b);
// 		}
		
		frame.setVisible(true);
	}
	
	public void removeAllButtons() {
		if (buttons != null) {
			for (JButton b : buttons) {
				panel.remove(b);
			}
		}
	}

}