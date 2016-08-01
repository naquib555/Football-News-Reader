package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainFrame extends JFrame {

	private ScorePanel scorepanel;
	private NewsPanel newspanel;
	private BoardPanel boardpanel;
	private MenuFrame menuframe;

	public MainFrame(String team) {

		super("Football News Ticker");

		scorepanel = new ScorePanel();
		newspanel = new NewsPanel(team);
		boardpanel = new BoardPanel(team);

		menuframe = new MenuFrame();

		setLayout(new BorderLayout());

		newspanel.setNewsListener(new NewsListener() {

			public void newsEventOccured(NewsEvent e) {

				NodeList titleList = e.getTitleList();
				NodeList descriptionList = e.getDescriptionList();
				NodeList publicationdateList = e.getPublicationdatelist();
				TextPanel textpanel = e.getTextpanel();

				for (int i = 1; i < descriptionList.getLength(); i++) {
					Element titleitem;
					Element descriptionitem;
					Element publicationdateitem;
					if (e.getTeamurl().equals("espn")) {
						titleitem = (Element) titleList.item(i);
						descriptionitem = (Element) descriptionList.item(i);
						publicationdateitem = (Element) publicationdateList
								.item(i - 1);
					} else {
						titleitem = (Element) titleList.item(i+1);
						descriptionitem = (Element) descriptionList.item(i);
						publicationdateitem = (Element) publicationdateList
								.item(i - 1);
					}

					try {
						if (titleitem != null)
							textpanel.appendText("NEWS : " + i + ". "
									+ titleitem.getFirstChild().getNodeValue()
									+ "\n");
					} catch (DOMException e1) {
					}

					if (descriptionitem != null)
						textpanel.appendText("--"
								+ descriptionitem.getFirstChild()
										.getNodeValue() + "\n");

					if (publicationdateitem != null)
						textpanel.appendText("-"
								+ publicationdateitem.getFirstChild()
										.getNodeValue() + "\n\n");

				}
			}
		});

		// add(scorepanel, BorderLayout.NORTH);
		add(newspanel, BorderLayout.EAST);
		add(boardpanel, BorderLayout.CENTER);

		setJMenuBar(menuframe.createMenuBar());
		setMinimumSize(new Dimension(1150, 500));
		setResizable(false);
		// setMaximumSize(new Dimension(800, 600));
		setSize(1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}
