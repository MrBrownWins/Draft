package uz.draft.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Championship {
	
	private IntegerProperty id;
	private StringProperty name;
	private StringProperty prize;
	private StringProperty bestPlayer;

	public Championship(){
		this(null, null, null);
	}
	public Championship(String name){
        this.name = new SimpleStringProperty(name);
    }
	public Championship(String name, String prize,String bestPlayer){
        this.name = new SimpleStringProperty(name);
        this.prize = new SimpleStringProperty(prize);
        this.bestPlayer = new SimpleStringProperty(bestPlayer);

  	}
	public Championship(int id, String name){
		this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
	}
	public Championship(int id, String name, String prize,String bestPlayer){
		this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.prize = new SimpleStringProperty(prize);
        this.bestPlayer = new SimpleStringProperty(bestPlayer);

  	}
	
	//Properties
	public IntegerProperty idProperty(){
		return id;
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty prizeProperty(){
		return prize;
	}
	public StringProperty bestPlayerProperty(){
		return bestPlayer;
	}
	
	//Getters and Setters
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getPrize() {
		return prize.get();
	}
	public void setPrize(String prize) {
		this.prize.set(prize);;
	}

	public String getBestPlayer() {
		return bestPlayer.get();
	}

	public void setBestPlayer(String bestPlayer) {
		this.bestPlayer.set(bestPlayer);
	}	
}


//public MatchList draft(){
//	//should return array of matches of all teams
//	
//	Random random = new Random();
//	int r = 0;
//	
//	Match m = new Match();
//	TeamList l = this.getTeams();
//	
//	while(!l.isEmpty()){
//		r = random.nextInt(l.size());
//		m.guestTeam = l.remove(r);
//		
//		if( l.isEmpty()){
//			m.hostTeam = new Team();
//		}else{
//			r = random.nextInt(l.size());
//			m.hostTeam = l.remove(r);
//		}
//		
//		this.getMatches().add(m);
//	}
//	
//	return this.getMatches();
//}