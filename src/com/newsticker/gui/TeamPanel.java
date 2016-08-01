package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TeamPanel extends JPanel {

	private JComboBox<String> comboBox;
	private JButton okButton;
	private JLabel wait;
	
	private TeamListener listener;
	
	public TeamPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 150;
		setPreferredSize(dim);
		
		Border innerborder = BorderFactory.createTitledBorder("Choose Team");
		Border outerborder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(innerborder, outerborder));
		
		comboBox = new JComboBox<String>();
		okButton = new JButton("OK");
		wait = new JLabel("Please Wait....");
		wait.setVisible(false);
		
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		
		comboModel.addElement("Arsenal");
		comboModel.addElement("Aston Villa");
		comboModel.addElement("Burnley");
		comboModel.addElement("Chelsea");
		comboModel.addElement("Crystal Palace");
		comboModel.addElement("Everton");
		comboModel.addElement("Hull City");
		comboModel.addElement("Leicester City");
		comboModel.addElement("Liverpool");
		comboModel.addElement("Manchester City");
		comboModel.addElement("Manchester United");
		comboModel.addElement("Newcastle United");
		comboModel.addElement("Queens Park Ranger");
		comboModel.addElement("Southampton");
		comboModel.addElement("Stoke City");
		comboModel.addElement("Swansea City");
		comboModel.addElement("Tottenham");
		comboModel.addElement("West Brom");
		comboModel.addElement("West Ham");
		
		comboBox.setModel(comboModel);
//		comboBox.setSelectedIndex(0);
		
		okButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				wait.setVisible(true);
				
				String comboItem = (String) comboBox.getSelectedItem();
				
				TeamEvent ev = new TeamEvent(this, comboItem);
					
				if(listener != null)
					listener.teamEventOccured(ev);
				
			}
		});
		
		setLayout(new GridBagLayout());
		
		
		GridBagConstraints gc = new GridBagConstraints();

		// ******FIRST LINE*******//***********nameField***************

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		add(new JLabel("Select your Desired Team"), gc);

		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_START;
		add(comboBox, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(wait, gc);
		
	}
	
	public void setTeamListener(TeamListener listener) {
		this.listener = listener;
	}
	
}
