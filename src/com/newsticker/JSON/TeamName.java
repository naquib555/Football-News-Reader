package com.newsticker.JSON;

public class TeamName {
	
private String team;
	
	public TeamName(String team) {
		this.team = team;
	}
	
	public String getTeamName() {
		if(team.equals("Arsenal")) team = "Arsenal";
		else if(team.equals("Aston Villa")) team = "Aston Villa";
		else if(team.equals("Burnley")) team = "Burnley";
		else if(team.equals("Chelsea")) team = "Chelsea";
		else if(team.equals("Crystal Palace")) team = "Crystal";
		else if(team.equals("Everton")) team = "Everton";
		else if(team.equals("Hull City")) team = "Hull";
		else if(team.equals("Leicester City")) team = "Leicester";
		else if(team.equals("Liverpool")) team = "Liverpool";
		else if(team.equals("Manchester City")) team = "ManCity";
		else if(team.equals("Manchester United")) team = "Manu";
		else if(team.equals("Newcastle United")) team = "Newscastle";
		else if(team.equals("Queens Park Rangers")) team = "QPR";
		else if(team.equals("Southampton")) team = "Southampton";
		else if(team.equals("Stoke City")) team = "Stoke";
		else if(team.equals("Sunderland")) team = "Sunderland";
		else if(team.equals("Swansea City")) team = "Swansea";
		else if(team.equals("Southampton")) team = "Southampton";
		else if(team.equals("Tottenham Hotspur")) team = "Tottenham";
		else if(team.equals("West Brom")) team = "West Bromwich";
		else if(team.equals("West Ham")) team = "West Ham";
		return team;
	}


}
