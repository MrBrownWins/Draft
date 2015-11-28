package uz.draft.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uz.draft.models.Coach;
import uz.draft.models.Team;
import uz.draft.models.TeamList;
import uz.draft.utils.Gender;

public class TeamTable extends Table{
	
	private PreparedStatement selectAllTeams = null;
	private PreparedStatement insertNewTeam = null;
	private PreparedStatement updateTeam = null;
	private PreparedStatement deleteTeam = null;

	public TeamTable() {
		super();
	}

	@Override
	public void connectDb() {
		if (this.isConnected() == false){
			super.connectDb();
		}
		try {
			
			selectAllTeams = this.getDbConnection().prepareStatement("SELECT * FROM teams");
			insertNewTeam = this.getDbConnection().prepareStatement("INSERT INTO teams" + "(name, coach)" + "VALUES(?, ?)");
			updateTeam = this.getDbConnection().prepareStatement("UPDATE teams SET name = ?, coach = ? WHERE name = ?");
			deleteTeam = this.getDbConnection().prepareStatement("DELETE FROM teams WHERE name = ?");
			super.setConnected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			super.setConnected(false);
		}

	}
	
	@Override
	public void closeDb(){
		try {
			this.getDbConnection().close();
			super.setConnected(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TeamList allTeam() {
		TeamList teams = null;
		ResultSet resultSet = null;

		try {
			
			resultSet = selectAllTeams.executeQuery();
			teams = new TeamList();

			while (resultSet.next()) {
				Team t = new Team(resultSet.getInt("teamId"), resultSet.getString("name"));
				Coach c = new Coach(resultSet.getString("coach"), 33 , Gender.MALE, t);
				t.setCoach(c);
				
				teams.add(t);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teams;
	}
	
	public void addTeam(Team team) {
		try {
			this.insertNewTeam.setString(1, team.getTeamName());
			this.insertNewTeam.setString(2, team.getCoach().getName());
			
			this.insertNewTeam.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.updateTeam(team);
		}
	}
	public void updateTeam(Team team){
		try {
			this.updateTeam.setString(1, team.getTeamName());
			this.updateTeam.setString(2, team.getCoach().getName());
			this.updateTeam.setString(3, team.getTeamName());
			
			updateTeam.executeUpdate();
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void deleteTeam(Team team){
		try {
			this.deleteTeam.setString(1, team.getTeamName());
			this.deleteTeam.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
