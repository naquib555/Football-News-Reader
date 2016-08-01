package com.newsticker.xml;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.newsticker.football365news.TeamName;

public class ReadXML {

	private NodeList titlelist;
	private NodeList descriptionlist;
	private NodeList publicationdatelist;
	private String url;
	
	
	public ReadXML(String Team, String espn) {
//		System.setProperty("http.proxyHost", "192.168.1.5");
//		System.setProperty("http.proxyPort", "8080");
		TeamName teamname = new TeamName(Team);
		String team = teamname.getTeamName();
		
		url = "http://www.espn.co.uk/rss/sport/story/feeds/0.xml?sport=3;type=2";
		System.out.println(url);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(url);
			
			titlelist = doc.getElementsByTagName("title");
			descriptionlist = doc.getElementsByTagName("description");
			publicationdatelist = doc.getElementsByTagName("pubDate");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ReadXML(String Team, int football355) {
//		System.setProperty("http.proxyHost", "192.168.1.5");
//		System.setProperty("http.proxyPort", "8080");
		TeamName teamname = new TeamName(Team);
		String team = teamname.getTeamName();
		
		url = "http://www.football365.com/" + team + "/rss";
		System.out.println(url);
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(url);
			
			titlelist = doc.getElementsByTagName("title");
			descriptionlist = doc.getElementsByTagName("description");
			publicationdatelist = doc.getElementsByTagName("pubDate");
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public NodeList getTitlelist() {
		return titlelist;
	}

	public void setTitlelist(NodeList titlelist) {
		this.titlelist = titlelist;
	}

	public NodeList getDescriptionlist() {
		return descriptionlist;
	}

	public void setDescriptionlist(NodeList descriptionlist) {
		this.descriptionlist = descriptionlist;
	}

	public NodeList getPublicationdatelist() {
		return publicationdatelist;
	}

	public void setPublicationdatelist(NodeList publicationdatelist) {
		this.publicationdatelist = publicationdatelist;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
