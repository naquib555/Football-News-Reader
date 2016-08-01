package com.newsticker.gui;

import java.util.EventListener;

public interface TeamListener extends EventListener {

	public void teamEventOccured(TeamEvent e);
}
