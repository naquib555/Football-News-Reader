package com.newsticker.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class TextPanel extends JPanel {

	private TextArea textarea;
	
	
	public TextPanel() {
		
		textarea = new TextArea();
		
		
		textarea.setEditable(false);
		
		textarea.setSize(new Dimension(58, 40));
		
		setLayout(new BorderLayout());
		
		//add(new JScrollPane(textarea), BorderLayout.CENTER);
		add(textarea, BorderLayout.CENTER);
	}
	
	public void appendText(String text) {
		textarea.append(text);
	}
	
	public void clearText() {
		textarea.append("");
	}
	
}
