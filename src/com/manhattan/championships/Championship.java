package com.manhattan.championships;

import com.manhattan.players.Player;
import com.manhattan.teams.TeamList;
import com.manhattan.utils.Result;

public class Championship {
	TeamList teams;
	Result results;
	String prize;
	
	Player bestPlayer;
	
	
	public Championship(){
		
	}
	
	public void draft(TeamList teams){
		//should return array of matches of all teams
		
	}
	
	public boolean isFinished(){
		return true;
	}
	
}
