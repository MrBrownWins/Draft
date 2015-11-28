package uz.draft.models;

import uz.draft.utils.Gender;
import uz.draft.utils.Human;

public class Coach extends Human {
	private Team team;

	/**
	 * Create type Coach object with name, age, gender   
	 * @param  String name, int age, Gender gender
	 * @see  Coach(String name, int age, Gender gender, Coach(String name, int age, Gender gender, Team team)
	 */
	public Coach() {

	}
	public Coach(int id,String name, int age, Gender gender) {
		super(id,name, age, gender);
	}
	/**
	 * Create type Coach object with name, age, gender   
	 * @param  String name, int age, Gender gender
	 * @see     Coach(), Coach(String name, int age, Gender gender, Team team)
	 */
	public Coach(String name, int age, Gender gender) {
		super(name, age, gender);
	}

	/**
	 * Create type Coach object with name, age, gender, team  
	 * @param  String name, int age, Gender gender, Team team
	 * @see     Coach(), Coach(String name, int age, Gender gender)
	 */
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
