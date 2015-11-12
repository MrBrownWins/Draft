package com.manhattan.players;

import java.util.Vector;

public class PlayerList {
	Vector<Player> players;
	public PlayerList(){
		
	}
	public PlayerList(	Vector<Player> players){
		this.setPlayers(players);
	}
	public void add(Player player){
		this.players.add(player);
	}
	public int getSize(){
		return this.players.size();
	}
	public void addPlayer(Player player){
		this.players.addElement(player);
	}
	public void removePlayer(Player player){
		this.players.remove(player);
	}
	public boolean hasPlayer(Player player){
		for(int i = 0; i < this.getSize(); i++){
			if(this.players.get(i).equals(player)){
				return true;
			}
		}
		return false;
	}
	public boolean isEmpty(){
		return this.players.isEmpty();
	}
	/**
	 * @return the players
	 */
	public Vector<Player> getPlayers() {
		return players;
	}
	
	/**
	 * @param players the players to set
	 */
	public void setPlayers(Vector<Player> players) {
		this.players = players;
	}
	
	
}
