package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ScorePanel extends JPanel {

	private TextPanel textpanel;
	private JTextArea score;
	private JLabel liveScore;
	private JPanel scorepanel;

	public ScorePanel() {

		textpanel = new TextPanel();
		score = new JTextArea();
		liveScore = new JLabel("Live Score");

//		Dimension dim = getPreferredSize();
//		dim.height = 100;
		setPreferredSize(new Dimension(100, 50));

//		Border innerborder = BorderFactory.createTitledBorder(
//				BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY),
//				"SCORE :", TitledBorder.CENTER, TitledBorder.ABOVE_TOP);
//		Border outerborder = BorderFactory.createEmptyBorder();
//		setBorder(BorderFactory.createCompoundBorder(innerborder, outerborder));

		Border innerborder = BorderFactory.createTitledBorder("Score");
		Border outerborder = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createCompoundBorder(innerborder, outerborder));
		
		layout();
		
	}
	
	public void layout() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//row 1
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.weightx = 0;
		gc.weighty = 0;
		
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JTextField(), gc);
	}
	
}
