package com.newsticker.JSON;

public class FixtureJson {

	private int id;
	private String date;
	private int matchday;
	private String homeTeam;
	private String awayTeam;
	private int goalsHomeTeam;
	private int goalsAwayTeam;

	public FixtureJson(int id, String date, int matchday,
			String homeTeam, String awayTeam, int goalsHomeTeam,
			int goalsAwayTeam) {
		this.id = id;
		this.date = date;
		this.matchday = matchday;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.goalsHomeTeam = goalsHomeTeam;
		this.goalsAwayTeam = goalsAwayTeam;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMatchday() {
		return matchday;
	}

	public void setMatchday(int matchday) {
		this.matchday = matchday;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getGoalsHomeTeam() {
		return goalsHomeTeam;
	}

	public void setGoalsHomeTeam(int goalsHomeTeam) {
		this.goalsHomeTeam = goalsHomeTeam;
	}

	public int getGoalsAwayTeam() {
		return goalsAwayTeam;
	}

	public void setGoalsAwayTeam(int goalsAwayTeam) {
		this.goalsAwayTeam = goalsAwayTeam;
	}

}
