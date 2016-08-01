package com.newsticker.gui;

import java.util.EventObject;

import javax.swing.JComboBox;

public class TeamEvent extends EventObject {

	private String comboBox;
	
	public TeamEvent(Object source, String comboBox) {
		super(source);
		this.comboBox = comboBox;
		
	}

	public String getComboBox() {
		return comboBox;
	}

	public void setComboBox(String comboBox) {
		this.comboBox = comboBox;
	}
	
	

}
