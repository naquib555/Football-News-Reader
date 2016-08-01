package com.newsticker.football365news;

public class TeamName {
	
	private String team;
	
	public TeamName(String team) {
		this.team = team;
	}
	
	public String getTeamName() {
		if(team.equals("Arsenal")) team = "arsenal";
		else if(team.equals("Aston Villa")) team = "aston-villa";
		else if(team.equals("Burnley")) team = "burnley";
		else if(team.equals("Chelsea")) team = "chelsea";
		else if(team.equals("Crystal Palace")) team = "crystal-palace";
		else if(team.equals("Everton")) team = "everton";
		else if(team.equals("Hull City")) team = "hull-city";
		else if(team.equals("Leicester City")) team = "leicester-city";
		else if(team.equals("Liverpool")) team = "liverpool";
		else if(team.equals("Manchester City")) team = "manchester-city";
		else if(team.equals("Manchester United")) team = "manchester-united";
		else if(team.equals("Newcastle United")) team = "newscastle-united";
		else if(team.equals("Queens Park Rangers")) team = "queens-park-rangers";
		else if(team.equals("Southampton")) team = "southampton";
		else if(team.equals("Stoke City")) team = "stoke-city";
		else if(team.equals("Sunderland")) team = "sunderland";
		else if(team.equals("Swansea City")) team = "swansea-city";
		else if(team.equals("Southampton")) team = "southampton";
		else if(team.equals("Tottenham Hotspur")) team = "tottenham-hotspur";
		else if(team.equals("West Brom")) team = "west-brom";
		else if(team.equals("West Ham")) team = "west-ham";
		return team;
	}
	
}
