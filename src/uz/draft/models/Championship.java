package uz.draft.models;

import java.util.Random;

public class Championship {
	private int id;
	private String Name;
	
	private TeamList teams;
	private MatchList matches;
	private Result results;
	
	String prize;
	Player bestPlayer;

	public Championship(){
		
	}
	
	public void addTeam(Team team){
		this.getTeams().add(team);
	}
	public void removeTeam(Team team){
		this.getTeams().remove(team);
	}
	
	public MatchList draft(){
		//should return array of matches of all teams
		
		Random random = new Random();
		int r = 0;
		
		Match m = new Match();
		TeamList l = this.getTeams();
		
		while(!l.isEmpty()){
			r = random.nextInt(l.size());
			m.guestTeam = l.remove(r);
			
			if( l.isEmpty()){
				m.hostTeam = new Team();
			}else{
				r = random.nextInt(l.size());
				m.hostTeam = l.remove(r);
			}
			
			this.getMatches().add(m);
		}
		
		return this.getMatches();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public TeamList getTeams() {
		return teams;
	}

	public void setTeams(TeamList teams) {
		this.teams = teams;
	}

	public MatchList getMatches() {
		return matches;
	}

	public void setMatches(MatchList matches) {
		this.matches = matches;
	}

	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Player getBestPlayer() {
		return bestPlayer;
	}

	public void setBestPlayer(Player bestPlayer) {
		this.bestPlayer = bestPlayer;
	}	
}
