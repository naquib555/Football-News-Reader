package com.newsticker.gui;

import java.util.EventObject;

import org.w3c.dom.NodeList;

public class NewsEvent extends EventObject {

	private NodeList titleList;
	private NodeList descriptionList;
	private NodeList publicationdatelist;
	private TextPanel textpanel;
	private String teamurl;

	public NewsEvent(Object source, NodeList titleList,
			NodeList descriptionList, NodeList publicationdatelist,
			TextPanel textpanel, String teamurl) {
		
		super(source);
		this.titleList = titleList;
		this.descriptionList = descriptionList;
		this.publicationdatelist = publicationdatelist;
		this.textpanel = textpanel;
		this.teamurl = teamurl;
		
	}
	
	public String getTeamurl() {
		return teamurl;
	}

	public NodeList getTitleList() {
		return titleList;
	}

	public void setTitleList(NodeList titleList) {
		this.titleList = titleList;
	}

	public NodeList getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(NodeList descriptionList) {
		this.descriptionList = descriptionList;
	}

	public NodeList getPublicationdatelist() {
		return publicationdatelist;
	}

	public void setPublicationdatelist(NodeList publicationdatelist) {
		this.publicationdatelist = publicationdatelist;
	}

	public TextPanel getTextpanel() {
		return textpanel;
	}

	public void setTextpanel(TextPanel textpanel) {
		this.textpanel = textpanel;
	}

}
