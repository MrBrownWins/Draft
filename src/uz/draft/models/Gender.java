package uz.draft.models;

public class Gender {
	public static final Gender MALE = new Gender("male");
	public static final Gender FEMALE = new Gender("female");
	
	private String gender;
	
	public Gender(String gender){
		this.gender = gender;
	}
	public String toString(){
		return gender;
	}
	public boolean equals(Gender g){
		if(this.gender.equals(g.toString())){
			return true;
		}else{
			return false;
		}
	}
}
