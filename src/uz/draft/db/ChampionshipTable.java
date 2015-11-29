package uz.draft.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uz.draft.models.Championship;

public class ChampionshipTable extends Table {
	
	private PreparedStatement selectAllChampionship = null;
	private PreparedStatement insertNewChampionship = null;
	private PreparedStatement deleteChampionship = null;
	private PreparedStatement updateChampionship = null;
	
	private final static String TABLE_NAME = new String("championships");
	public ChampionshipTable(){
		super();
		connectDb();
	}
	
	@Override
	public void connectDb() {
		if (this.isConnected() == false){
			super.connectDb();
		}
		try {
			
			selectAllChampionship = this.getDbConnection().prepareStatement("SELECT * FROM " + TABLE_NAME);
			insertNewChampionship = this.getDbConnection().prepareStatement("INSERT INTO "+ TABLE_NAME + "(name, prize,referee)" + "VALUES(?, ?,?)");
			updateChampionship = this.getDbConnection().prepareStatement("UPDATE "+ TABLE_NAME + " SET name = ?, prize = ?, referee = ? WHERE name = ?");
			deleteChampionship = this.getDbConnection().prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE name = ?");
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

	public ObservableList<Championship> allChampionships() {
		
		ObservableList<Championship> championships = null;
		ResultSet resultSet = null;

		try {
			resultSet = this.selectAllChampionship.executeQuery();
			championships = FXCollections.observableArrayList();

			while (resultSet.next()) {
				championships.add(new Championship(
						resultSet.getInt("id"), 
						resultSet.getString("name"),
						resultSet.getString("prize"),
						resultSet.getString("referee")
						));
				}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return championships;
	}
	
	public void addChampionship(Championship ch) {
		try {
			this.insertNewChampionship.setString(1, ch.getName());
			this.insertNewChampionship.setString(2, ch.getPrize());
			this.insertNewChampionship.setString(3, ch.getReferee());
			this.insertNewChampionship.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			this.updateChampionship(ch);
		}
	}
	public void updateChampionship(Championship ch){
		try {
			this.updateChampionship.setString(1, ch.getName());
			this.updateChampionship.setString(2, ch.getPrize());
			this.updateChampionship.setString(3, ch.getReferee());
			this.updateChampionship.setString(4, ch.getName());
			
			updateChampionship.executeUpdate();
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void deleteChampionship(Championship ch){
		try {
			this.deleteChampionship.setString(1, ch.getName());
			this.deleteChampionship.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
