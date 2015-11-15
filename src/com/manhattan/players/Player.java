package com.manhattan.players;

import com.manhattan.utils.Gender;
import com.manhattan.utils.Human;

public class Player extends Human {
	private static int numberOfPlayers = 0;
	private String playerId;

	public Player() {
		// TODO Auto-generated constructor stub
		super();
		Player.setNumberOfPlayers(Player.getNumberOfPlayers() + 1);
		this.setPlayerId();
	}
	public Player(String name, int age,Gender gender){
		super(name, age, gender);
		Player.setNumberOfPlayers(Player.getNumberOfPlayers() + 1);
		this.setPlayerId();
		
	}
	/**
	 * @return the playerId
	 */
	public String getPlayerId() {
		return playerId;
	}
	
	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId() {
		this.playerId = String.valueOf(1000000 + Player.getNumberOfPlayers()).substring(1, 7);
	}
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public static void setNumberOfPlayers(int numberOfPlayers) {
		Player.numberOfPlayers = numberOfPlayers;
	}
	@Override
	public String toString(){
		return "PlayerId: " + this.playerId + super.toString();
	}
	@Override 
	public boolean equals(Human player){
		if(this.getPlayerId() == ((Player) player).getPlayerId()){
			return true;
		}
		return false;
	}

}
