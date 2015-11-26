package uz.draft.models;

import java.util.ArrayList;

public class TeamList extends ArrayList<Team> {
	
	private static final long serialVersionUID = 1L;

	public TeamList(){
		super(11);
	}
	
	public TeamList(int number){
		super(number);
	}
	
	public Team find(String teamName){
		Team t = new Team();
		for(int i = 0; i < this.size(); i++){
			if(this.get(i).getTeamName() == teamName){
				t = this.get(i);
				break;
			}
		}
		return t;
	}
	
	
}
