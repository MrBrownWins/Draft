package com.manhattan.utils;

import java.util.Date;

import com.manhattan.teams.Team;

public class Match {
	Team hostTeam;
	Team guestTeam;
	
	String matchPlace;
	Date matchTime;
	Result result;
	
	Referee matchReferee;
	
	public Match(){
		
	}
	public Match(Date matchtime){
		this.setMatchTime(matchtime);
	}
	
	public Team getHostTeam() {
		return hostTeam;
	}
	public void setHostTeam(Team hostTeam) {
		this.hostTeam = hostTeam;
	}
	public Team getGuestTeam() {
		return guestTeam;
	}
	public void setGuestTeam(Team guestTeam) {
		this.guestTeam = guestTeam;
	}
	public String getMatchPlace() {
		return matchPlace;
	}
	public void setMatchPlace(String matchPlace) {
		this.matchPlace = matchPlace;
	}
	public Date getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Referee getMatchReferee() {
		return matchReferee;
	}
	public void setMatchReferee(Referee matchReferee) {
		this.matchReferee = matchReferee;
	}
	
	
}
