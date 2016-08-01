package com.newsticker.gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.newsticker.JSON.FixtureJson;
import com.newsticker.JSON.TeamJson;

public class ScheduleTableModel extends AbstractTableModel {

	private ArrayList<FixtureJson> teamlist;
	private String finalteam;
	private int size;
	
	private String [] colNames = {"MatchDay", "Date", "Home Team", "Away Team"};
	public ScheduleTableModel() {
		
	}
	
	public void setTableSize(int size) {
		this.size = size;
	}
	
	public void setData(ArrayList<FixtureJson> fixtureJson) {
		this.teamlist = fixtureJson;
	}
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return teamlist.size();
	}
	
	public void setTeamName(String team) {
		finalteam = team;
	}
	
	public String getTeamName() {
		return finalteam;
	}
	
	

	public Object getValueAt(int row, int col) {
		FixtureJson fixture = teamlist.get(row);
		if (fixture.getGoalsHomeTeam() != -1) {
						switch(col) {
						
						case 0:
							return fixture.getMatchday();
						case 1:
							return fixture.getDate();
						case 2:
							return fixture.getHomeTeam() +  "       -  " + fixture.getGoalsHomeTeam();
						case 3:
							return fixture.getGoalsAwayTeam() + "  -      " + "  " + fixture.getAwayTeam();
						}
		}else {
			
			switch(col) {
			case 0:
				return fixture.getMatchday();
			case 1:
				return fixture.getDate();
			case 2:
				return fixture.getHomeTeam() + "      -";
			case 3:
				return "  -      " + fixture.getAwayTeam();
			}
		}
		return null;
	}
	
}
