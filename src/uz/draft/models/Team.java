package uz.draft.models;

public class Team {
	private int teamId;
	private String teamName;
	private Coach coach;
	private PlayerList players;
	
	private Championship championship;
	
	/**
	 * Create type Team object
	 * @see     Team(String teamName), Team(int teamId,String teamName)
	 */
	
	public Team(){

	}
	
	/**
	 * Create type Team object with String type name   
	 * @param  String teamName
	 * @see     Team(), Team(int teamId,String teamName)
	 */
	
	public Team(String name){
		this.setTeamName(name);
	}
	
	/**
	 * Create type Team object with teamId and name   
	 * @param  int teamId, String teamName 
	 * @see     Team(), Team(String teamName)
	 */
	public Team(int teamId, String name){
		this.setTeamId(teamId);
		this.setTeamName(name);
	}
	
	public Championship getChampionship() {
		return championship;
	}

	public PlayerList getPlayers() {
		return players;
	}

	public void setPlayers(PlayerList players) {
		this.players = players;
	}
	
	public void addPlayer(Player player){
		this.getPlayers().add(player);
	}
	public void removePlayer(Player player){
		this.getPlayers().remove(player);
	}

	public int getTeamId(){
		return this.teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	
	public Coach getCoach() {
		return this.coach;
	}
	public void setTeamId(int teamId){
		this.teamId = teamId;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
}
