package uz.draft.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainPage extends Application {
	final static String TITLE = new String("Welcome to Draft!");
	final Image ICON = new Image("file:images/p.png");
	
	final static String VIEW_FILE = new String("MainPage.fxml");
	final static String STYLESHEET_URL = new String("application.css");

	//shows Main Page 
	public static void show(String[] args){
		MainPage.launch(args);
	}
	
	public void loadDb(){
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource(VIEW_FILE));
		Scene mainScene = new Scene(root);
		
		mainScene.getStylesheets().add(getClass().getResource(STYLESHEET_URL).toExternalForm());
		primaryStage.isResizable();
		primaryStage.setScene(mainScene);
		primaryStage.setTitle(TITLE);
		primaryStage.getIcons().add(ICON);
		primaryStage.centerOnScreen();
		primaryStage.show();
		

		
	}
	
	

}
