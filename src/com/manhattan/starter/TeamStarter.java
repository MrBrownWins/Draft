package com.manhattan.starter;

import com.manhattan.players.Player;
import com.manhattan.utils.Gender;

public class TeamStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player gk = new Player();
		Player fr = new Player("Ronaldo", 23, Gender.MALE);
		
		System.out.printf("Goal keaper: %s\n", gk.toString());
		System.out.printf("Forwarder: %s\n", fr.toString());

		System.out.printf("Player Number: %d and %s", Player.getNumberOfPlayers(), fr.getPlayerId());

	}

}
