package com.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import com.main.Interface;
import com.main.Interface.Page;

public class ButtonManager {

	private static ButtonManager buttonManager;
	
	private final JButton button1 = new JButton("Button 1");
	private final JButton button2 = new JButton("Button 2");
	private final JButton button3 = new JButton("Button 3");
    private final JButton button4 = new JButton("Button 4");
	private final JButton button5 = new JButton("Button 5");
	private final JButton button6 = new JButton("Button 6");
		
	public ButtonManager() {
		button1.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE2);
					}
				}
				);
		button2.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE2);
					}
				}
				);
		button3.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE2);
					}
				}
				);
        button4.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE1);
					}
				}
				);
		button5.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE1);
					}
				}
				);
		button6.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Interface.getInstance().createPage(Page.PAGE1);
					}
				}
				);
	}
	
	public static ButtonManager getInstance() {
		if (buttonManager == null) {
			buttonManager = new ButtonManager();
		}
		
		return buttonManager;
	}
		
    public List<JButton> getButtons1() {
		return Arrays.asList(
				button1,
				button2,
				button3
				);
	}
    
    public List<JButton> getButtons2() {
    	return Arrays.asList(
    			button4,
    			button5,
    			button6
    			);
    }
	
}