package com.manhattan.players;

import com.manhattan.teams.Team;
import com.manhattan.utils.Gender;

public class Coach extends Human {
	private Team team;

	public Coach() {
		// TODO Auto-generated constructor stub
	}

	public Coach(String name, int age, Gender gender) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	}

	public Coach(String name, int age, Gender gender, Team team) {
		super(name, age, gender);
		this.setTeam(team);
	}

	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Coach " + super.toString();
	}

}
