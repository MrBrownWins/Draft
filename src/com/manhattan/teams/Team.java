package com.manhattan.teams;

import java.util.Collections;
import java.util.Vector;

import com.manhattan.players.PlayerList;
import com.manhattan.utils.Coach;

public class Team {
	private String teamName;
	private PlayerList teamPlayerList;
	private Coach coach;
	private static Vector<Team> allTeams;
	private static int numTeams = Team.allTeams.size();
	
	public Team(){
		Team.allTeams.addElement(this);
	}
	public Team(String name, PlayerList players){
		this.setTeamName(name);
		this.setTeamPlayerList(players);
		Team.allTeams.addElement(this);

	}
	
	public Team(String name, PlayerList players, Coach coach){
		this.setTeamName(name);
		this.setTeamPlayerList(players);
		this.setCoach(coach);
		Team.allTeams.addElement(this);

	}
	
	public static Vector<Team> all(){
		return Team.allTeams;
	}
	public static int NumberOfTeams(){
		return Team.numTeams;
	}
	
	public void shuffle(){
		//shuffle playerList
		Collections.shuffle(this.getTeamPlayerList().getPlayers());
	}
	
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @return the teamPlayerList
	 */
	public PlayerList getTeamPlayerList() {
		return teamPlayerList;
	}
	/**
	 * @return the coach
	 */
	public Coach getCoach() {
		return coach;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @param teamPlayerList the teamPlayerList to set
	 */
	public void setTeamPlayerList(PlayerList teamPlayerList) {
		this.teamPlayerList = teamPlayerList;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	
}
