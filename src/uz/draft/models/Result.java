package uz.draft.models;

public class Result {
	String lScore;
	String RScore;
	
	public Result(){
		this.setAll("");
	}
	public Result(String result){
		this.setAll(result);
	}
	public void setAll(String r){
		if(! r.isEmpty()){
			String[] re = r.split(":");			
			this.setLeftScore(re[0]);
			this.setRightScore(re[1]);
		}else{
			this.setLeftScore("0");
			this.setRightScore("0");
		}
	}
		
	public String toString(){
		return this.getLeftScore() + ":" + this.getRightScore();
	}
	
	public String getLeftScore() {
		return lScore;
	}
	public String getRightScore() {
		return RScore;
	}
	public void setLeftScore(String lScore) {
		this.lScore = lScore;
	}
	public void setRightScore(String rScore) {
		RScore = rScore;
	}
	
}
