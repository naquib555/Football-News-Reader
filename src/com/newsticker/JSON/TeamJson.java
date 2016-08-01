package com.newsticker.JSON;

import java.util.ArrayList;


public class TeamJson {

	private int id;
	private String name;
	private String shortName;
	private String crestUrl;
	private ArrayList<FixtureJson> fixture;
	public ArrayList<FixtureJson> getFixture() {
		return fixture;
	}

	public void setFixture(ArrayList<FixtureJson> fixture) {
		this.fixture = fixture;
	}

	public TeamJson(int id, String name, String shortName, String crestUrl) {
		this.id = id;
		this.name = name;
		this.shortName= shortName;
		this.crestUrl = crestUrl;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCrestUrl() {
		return crestUrl;
	}
	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}
	
	
	
}
