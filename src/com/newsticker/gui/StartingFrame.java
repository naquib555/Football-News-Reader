package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class StartingFrame extends JFrame {

	private TeamPanel teampanel;
	
	public StartingFrame() {
		
		super("Team Select");
		
		setLayout(new BorderLayout());
		
		teampanel = new TeamPanel();
		
		teampanel.setTeamListener(new TeamListener() {

			public void teamEventOccured(TeamEvent e) {
				
				String team = e.getComboBox();
				
				new MainFrame(team);
				dispose();
				
			}
			
		});
		
		
		add(teampanel, BorderLayout.CENTER);
		
		setSize(250, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
		
	}
	
}
