package com.newsticker.gui;

import java.util.EventObject;

import javax.swing.JCheckBoxMenuItem;


public class MenuEvent<T> extends EventObject {

	private T item;
	
	public MenuEvent(Object source) {
		super(source);
	}
	
	public MenuEvent(Object source, T item) {
		super(source);

		this.item = item;
		
	}

	public T getItem() {
		return item;
	}

}