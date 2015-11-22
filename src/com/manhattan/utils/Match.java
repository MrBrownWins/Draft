package com.manhattan.utils;

import com.manhattan.teams.Team;

public class Match {
	Team hostTeam;
	Team guestTeam;

	Result result;
	
	Referee matchReferee;
	
	public Match(){
		
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
