package uz.draft.models;

public class Player extends Human {
	private static int numberOfPlayers = 0;
	
	private Team team;
	
	public Player() {
	
	}
	public Player(String name, int age,Gender gender){
		super(name, age, gender);
		
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public static void setNumberOfPlayers(int numberOfPlayers) {
		Player.numberOfPlayers = numberOfPlayers;
	}
	
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		if(this.team != null){
			this.team.removePlayer(this);
		}
		this.team = team;
		this.getTeam().addPlayer(this);
	}
	

}
