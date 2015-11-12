package com.manhattan.teams;

import com.manhattan.players.Coach;
import com.manhattan.players.PlayerList;

public class Team {
	private String teamName;
	private PlayerList teamPlayerList;
	private Coach coach;
	
	public Team(){
		
	}
	public Team(String name, PlayerList players){
		this.setTeamName(name);
		this.setTeamPlayerList(players);
	}
	
	public Team(String name, PlayerList players, Coach coach){
		this.setTeamName(name);
		this.setTeamPlayerList(players);
		this.setCoach(coach);
	}
	
	public void shuffle(){
		//shuffle playerList
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
