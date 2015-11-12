package com.manhattan.players;

import com.manhattan.utils.Gender;

public abstract class Human {
	private int age;
	private String name;
	private Gender gender;

	public Human() {
		// TODO Auto-generated constructor stub
	
	}
	public Human(String name,int age, Gender gender){
		this.setAll(name, age, gender);
	}
	public void setAll(String name,int age,Gender gender){
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " name: " + this.name + " ,age: " + this.age +" ,gender:" + this.gender;
	}
	
	public boolean equals(Human other){
		if(this.getName().toLowerCase() == other.getName().toLowerCase()
				&& this.getAge() == other.getAge()){
				return true;
		}
		return false;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}