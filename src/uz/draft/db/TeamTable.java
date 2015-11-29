package uz.draft.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uz.draft.models.Championship;
import uz.draft.models.Team;
import uz.draft.models.TeamList;

public class TeamTable extends Table{
	
	private PreparedStatement selectAllTeams = null;
	private PreparedStatement selectTeamsByChampionship = null;
	private PreparedStatement insertNewTeam = null;
	private PreparedStatement updateTeam = null;
	private PreparedStatement deleteTeam = null;

	private final static String TABLE_NAME = new String("teams");
	private ChampionshipTable table = new ChampionshipTable();
	
	public TeamTable() {
		super();
	}

	@Override
	public void connectDb() {
		if (this.isConnected() == false){
			super.connectDb();
		}
		try {
			
			selectAllTeams = this.getDbConnection().prepareStatement("SELECT * FROM "+ TABLE_NAME);
			selectTeamsByChampionship = this.getDbConnection().prepareStatement("SELECT * FROM " + TABLE_NAME +"WHERE championship = ?" );
			insertNewTeam = this.getDbConnection().prepareStatement("INSERT INTO "+TABLE_NAME + "(name, championship)" + "VALUES(?, ?)");
			updateTeam = this.getDbConnection().prepareStatement("UPDATE "+ TABLE_NAME +" SET name = ?, championship = ? WHERE name = ?");
			deleteTeam = this.getDbConnection().prepareStatement("DELETE FROM "+TABLE_NAME+ "WHERE name = ?");
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
			
			while (resultSet.next()){
						int id = resultSet.getInt("teamId");
						String name = resultSet.getString("name");
						Championship ch = this.table.getChampionshipByName(resultSet.getString("championship"));
						teams.add(new Team(id, name, ch));				
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
	public ObservableList<Team> selecTeamsByChampionship(Championship ch){
		ObservableList<Team> teams = null;
		ResultSet resultSet = null;

		try {
			this.selectTeamsByChampionship.setString(1, ch.getName());
			resultSet = this.selectTeamsByChampionship.executeQuery();
			
			teams = FXCollections.observableArrayList();
			while (resultSet.next()) {
				teams.add(new Team(
						resultSet.getInt("teamId"), 
						resultSet.getString("name"),ch));
			} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return teams;
	}
	
	public void addTeam(Team team) {
		try {
			this.insertNewTeam.setString(1, team.getTeamName());
			this.insertNewTeam.setString(2, team.getChampionship().getName());
			
			this.insertNewTeam.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.updateTeam(team);
		}
	}
	public void updateTeam(Team team){
		try {
			this.updateTeam.setString(1, team.getTeamName());
			this.updateTeam.setString(2, team.getChampionship().getName());
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
