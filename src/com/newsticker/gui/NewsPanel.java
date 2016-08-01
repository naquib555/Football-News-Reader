package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.w3c.dom.NodeList;

import com.newsticker.xml.ReadXML;

public class NewsPanel extends JPanel {

	private TextPanel textpanel;
	private JButton newsReload;
	private JLabel newsLabel;

	private NewsListener listener;
	private ReadXML xml365;
	private ReadXML xmlespn;

	public NewsPanel(String team) {

		textpanel = new TextPanel();
		newsReload = new JButton("Reload News");
		newsLabel = new JLabel("NEWS");

		xml365 = new ReadXML(team, 365);
		xmlespn = new ReadXML(team, "espn");
		setPreferredSize(new Dimension(400, 0));
		// setBorder(BorderFactory.createLoweredBevelBorder());
		Border innerborder = BorderFactory.createTitledBorder("");
		Border outerborder = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createCompoundBorder(innerborder, outerborder));
		// setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 100));

		setLayout(new BorderLayout());

		// textpanel.appendText("Hello");

		newsLabel.setAlignmentX(CENTER_ALIGNMENT);
		newsLabel.setAlignmentY(CENTER_ALIGNMENT);

		newsReload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				

				NodeList titleList = xml365.getTitlelist();
				NodeList descriptionList = xml365.getDescriptionlist();
				NodeList publicationdatelist = xml365.getPublicationdatelist();
				TextPanel textpanel = NewsPanel.this.textpanel;
				String teamurl = "365";
				
				textpanel.clearText();
				
				textpanel.appendText("------------ TEAM NEWS ------------\n");
				NewsEvent newsevent = new NewsEvent(this, titleList,
						descriptionList, publicationdatelist, textpanel, teamurl);

				if (listener != null) {
					listener.newsEventOccured(newsevent);
				}
				
				NodeList titleList1 = xmlespn.getTitlelist();
				NodeList descriptionList1 = xmlespn.getDescriptionlist();
				NodeList publicationdatelist1 = xmlespn.getPublicationdatelist();
				TextPanel textpanel1 = NewsPanel.this.textpanel;
				String teamurl1 = "espn";
				
				textpanel.appendText("------------ GENERAL NEWS ------------\n");
				NewsEvent newsevent1 = new NewsEvent(this, titleList1,
						descriptionList1, publicationdatelist1, textpanel1, teamurl1);

				if (listener != null) {
					listener.newsEventOccured(newsevent1);
				}

				
			}
		});

		add(newsLabel, BorderLayout.NORTH);
		add(textpanel);
		add(newsReload, BorderLayout.SOUTH);

	}

	public void setNewsListener(NewsListener listener) {
		this.listener = listener;
	}
}