package uz.draft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Table {
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5050/draftdb";
	private static final String USERNAME = "draft";
	private static final String PASSWORD = "draft";

	private Connection dbConnection = null;
	private boolean isConnected;
	
	public Table(){
		this.connectDb();
	}
	public void connectDb(){
		try {
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			this.setConnected(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.setConnected(false);
		}
		
	}
	
	public void closeDb(){
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.setConnected(false);
		}
	}
	
	public Connection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
}
