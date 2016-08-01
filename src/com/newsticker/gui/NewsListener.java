package com.newsticker.gui;
import java.util.EventListener;


public interface NewsListener extends EventListener {

	public void newsEventOccured(NewsEvent e);
}
