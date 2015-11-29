package uz.draft.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Team {
	private IntegerProperty teamId;
	private StringProperty teamName;
	private ObjectProperty<Championship> championship;
	
	/**
	 * Create type Team object
	 * @see     Team(String teamName), Team(int teamId,String teamName)
	 */
	
	public Team(){
		this(null, null);
	}
	
	/**
	 * Create type Team object with String type name   
	 * @param  String teamName
	 * @see     Team(), Team(int teamId,String teamName)
	 */
	
	public Team(String name, Championship ch){
		this.teamName = new SimpleStringProperty(name);
		this.championship = new SimpleObjectProperty<Championship>(ch);
	}
	/**
	 * Create type Team object with teamId name championship   
	 * @param  int teamId, String teamName, championship
	 * @see     Team(), Team(String teamName)
	 */
	public Team(int teamId, String name, Championship ch){
		this.teamId = new SimpleIntegerProperty(teamId);
		this.teamName = new SimpleStringProperty(name);
		this.championship = new SimpleObjectProperty<Championship>(ch);
	}
	
	//Properties
	public IntegerProperty teamIdProperty(){
		return this.teamId;
	}
	public StringProperty teamNameProperty(){
		return this.teamName;
	}
	public ObjectProperty<Championship> championshipProperty(){
		return this.championship;
	}

	//Setters and Getters
	public int getTeamId(){
		return this.teamId.get();
	}
	public String getTeamName() {
		return teamName.get();
	}
	public Championship getChampionship() {
		return championship.get();
	}
	
	public void setTeamId(int teamId){
		this.teamId.set(teamId);;
	}
	public void setTeamName(String teamName) {
		this.teamName.set(teamName);
	}
	public void setChampionship(Championship ch){
		this.championship.set(ch);
	}
	
}
