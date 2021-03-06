package com.newsticker.JSON;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class json {

	private StringBuilder stringbuilderTeam;
	private static StringBuilder stringbuilderFixture;
	private InputStream streamTeam;
	private static InputStream streamFixture;
	private static BufferedInputStream bufferedTeam;
	private static BufferedInputStream bufferedFixture;
	public ArrayList<TeamJson> teamlist;
	private int size = 0;

	public json(String team) {
		try {
			URL urlTeam = new URL(
					"http://www.football-data.org/soccerseasons/354/teams");
			URL urlFixture = new URL("http://www.football-data.org/fixtures");
			streamTeam = urlTeam.openStream();
			streamFixture = urlFixture.openStream();

			bufferedTeam = new BufferedInputStream(streamTeam);
			bufferedFixture = new BufferedInputStream(streamFixture);
			stringbuilderTeam = new StringBuilder();
			stringbuilderFixture = new StringBuilder();

			teamBuilder();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doJson() {
		json j = new json("s");
		System.out.println(j.getStringbuilderTeam());

		try {
			JSONArray jsonteamarray = new JSONArray(j.getStringbuilderTeam()
					.toString());
			teamlist = new ArrayList<TeamJson>();
			for (int i = 0; i < jsonteamarray.length(); i++) {
				JSONObject jsonobject = jsonteamarray.getJSONObject(i);
				// String id = (String) jsonobject.get("id");
				int id = (int) jsonobject.get("id");
				String name = (String) jsonobject.get("name");
				String shortName = (String) jsonobject.get("shortName");
				String crestUrl = (String) jsonobject.get("crestUrl");
				try {
					URL urlFixture = new URL(
							"http://www.football-data.org/teams/" + id
									+ "/fixtures");
					streamFixture = urlFixture.openStream();
					bufferedFixture = new BufferedInputStream(streamFixture);
					stringbuilderFixture = new StringBuilder();
					j.fixtureBuilder();
					JSONArray jsonfixturearray = new JSONArray(j
							.getStringbuilderFixture().toString());

					ArrayList<FixtureJson> teamFixture = new ArrayList<FixtureJson>();
					for (int ii = 0; ii < jsonfixturearray.length(); ii++) {
						JSONObject jsonobjectfix = jsonfixturearray
								.getJSONObject(ii);
						// String iiid = (String) jsonobjectfix.get("id");
						int iiid = (int) jsonobjectfix.get("id");
						String date = (String) jsonobjectfix.get("date");
						int matchday = (int) jsonobjectfix.get("matchday");
						String homeTeam = (String) jsonobjectfix
								.get("homeTeam");
						String awayTeam = (String) jsonobjectfix
								.get("awayTeam");
						int goalsHomeTeam = (int) jsonobjectfix
								.get("goalsHomeTeam");
						int goalsAwayTeam = (int) jsonobjectfix
								.get("goalsAwayTeam");

						FixtureJson fixture = new FixtureJson(iiid, date,
								matchday, homeTeam, awayTeam, goalsHomeTeam,
								goalsAwayTeam);

						teamFixture.add(fixture);

					}
					TeamJson team = new TeamJson(id, name, shortName, crestUrl);
					team.setFixture(teamFixture);
					size++;
					/*
					 * for (int k = 0; k < team.getFixture().size(); k++) { //
					 * if (team.getShortName().equalsIgnoreCase("manu"))
					 * System.out.println(team.getFixture().get(k)
					 * .getHomeTeam() + " vs " +
					 * team.getFixture().get(k).getAwayTeam()); }
					 */
					// System.out.println(team.getShortName());

					teamlist.add(team);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			// System.out.println(jsonarray.getJSONObject(0));
			// jsonarray.

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getSize() {
		return size;
	}

	public void teamBuilder() {
		try {
			while (true) {
				int data = bufferedTeam.read();

				if (data == -1)
					break;
				else {
					stringbuilderTeam.append((char) data);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StringBuilder fixtureBuilder() {
		try {
			while (true) {
				int data = bufferedFixture.read();

				if (data == -1)
					break;
				else {
					stringbuilderFixture.append((char) data);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stringbuilderFixture;

	}

	public StringBuilder getStringbuilderTeam() {
		return stringbuilderTeam;
	}

	public StringBuilder getStringbuilderFixture() {
		return stringbuilderFixture;
	}

	public ArrayList<TeamJson> getTeamlist() {
		// TODO Auto-generated method stub
		return teamlist;
	}

}