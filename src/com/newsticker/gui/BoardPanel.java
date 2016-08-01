package com.newsticker.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.newsticker.JSON.FixtureJson;
import com.newsticker.JSON.TeamJson;
import com.newsticker.JSON.TeamName;
import com.newsticker.JSON.json;
import com.newsticker.football365news.Json;

public class BoardPanel extends JPanel {

	private JTextArea scheduleArea;
	private JButton refreshButton;
	private JButton changeTeamButton;
//	private Json json;
	private json json;
	private String team;
	private TextPanel textpanel;
	
	
	//table try
	private JTable table;
	private ScheduleTableModel tablemodel;

	public BoardPanel(String Team) {

		this.team = Team;
		/*textpanel = new TextPanel();
		scheduleArea = new JTextArea();
		refreshButton = new JButton("REFRESH");*/
		changeTeamButton = new JButton("CHANGE TEAM");
//		json = new Json(Team);
		json = new json(Team);
		setPreferredSize(new Dimension(380, 0));

		
		//table try
		tablemodel = new ScheduleTableModel();
		table = new JTable(tablemodel);
		
		fixture();
		
		Border innerBorder = BorderFactory.createTitledBorder("BOARD");
		Border outerBorder = BorderFactory.createEmptyBorder();
		setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

		// fixture();
//		System.out.println(Team);
		
		
		
		
		

		setLayout(new BorderLayout());

		changeTeamButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new StartingFrame();
			}
		});
		add(new JLabel("SCHEDULE"), BorderLayout.PAGE_START);
		//add(textpanel);
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(changeTeamButton, BorderLayout.SOUTH);
		// add(refreshButton, BorderLayout.PAGE_END);

	}


	public void fixture() {
		TeamName teamname = new TeamName(team);
		String finalteam = teamname.getTeamName();
		tablemodel.setTeamName(finalteam);
		json.doJson();
		
//		tablemodel.setData(json.getTeamList());
		tablemodel.setTableSize(json.getTeamlist().size());
//		tablemodel.setData(json.getTeamlist());
		ArrayList<TeamJson> teamlist = json.getTeamlist();
		for (int i = 0; i < teamlist.size(); i++) {
			
			for (int j = 0; j < teamlist.get(i).getFixture().size(); j++) {
				if (teamlist.get(i).getShortName().equalsIgnoreCase(finalteam)) {
					if (teamlist.get(i).getFixture().get(j).getGoalsHomeTeam() == -1) {
						tablemodel.setData(teamlist.get(i).getFixture());
						System.out.println("MATCHDAY : "
						+ teamlist.get(i).getFixture().get(j)
								.getMatchday()
						+ "\n"
						+ teamlist.get(i).getFixture().get(j)
								.getHomeTeam()
						+ teamlist.get(i).getFixture().get(j)
								.getGoalsHomeTeam()
						+ " - "
						+ teamlist.get(i).getFixture().get(j)
								.getAwayTeam()
								+ teamlist.get(i).getFixture().get(j)
								.getGoalsAwayTeam()
								+ "  ("
								+ teamlist.get(i).getFixture().get(j).getDate()
								+ ")"
								+ "\n\n");
					}
						
					
				}
						
			}

		}
	}
}

