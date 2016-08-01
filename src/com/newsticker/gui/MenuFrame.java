package com.newsticker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuFrame extends JFrame {

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem changeTeam;
	// private JMenuItem importItem;
	private JMenuItem exitItem;
	private JMenu windowMenu;
	private JMenu showMenu;
//	private JCheckBoxMenuItem showFormItem;
	private JFileChooser fileChooser;
	private MenuListener listener;

	public JMenuBar createMenuBar() {
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		changeTeam = new JMenuItem("Change Team");
		// importItem = new JMenuItem("Import..");
		exitItem = new JMenuItem("Exit");
		fileChooser = new JFileChooser();

		fileMenu.add(changeTeam);
		// fileMenu.add(importItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		windowMenu = new JMenu("Window");
		showMenu = new JMenu("Show");
//		showFormItem = new JCheckBoxMenuItem("Person Form");
//		showFormItem.setSelected(true);

		windowMenu.add(showMenu);
//		showMenu.add(showFormItem);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		// *****set up Mnemonics******

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_A);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));

		// ******FileMenu*********

		changeTeam.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int changeAction = JOptionPane.showConfirmDialog(null,
						"Do you really want to change the team?",
						"Confirm Team Change", JOptionPane.OK_CANCEL_OPTION);
				
				if(changeAction == JOptionPane.OK_OPTION) {
					new StartingFrame();
					dispose();
				}
			}
		});

		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int exitAction = JOptionPane.showConfirmDialog(null,
						"Do you reall want to exit?", "Confirm Exit",
						JOptionPane.OK_CANCEL_OPTION);

				if (exitAction == JOptionPane.OK_OPTION)
					System.exit(0);

			}

		});

		// ***********WindowMenu**********

		return menuBar;
	}

	public void setMenuListener(MenuListener listener) {
		this.listener = listener;
	}

}
