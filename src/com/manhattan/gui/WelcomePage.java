package com.manhattan.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WelcomePage extends Application {
	
	//shows Welcome Page 
	public static void show(String[] args){
		WelcomePage.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		String title = new String("Welcome to Draft!");
		Image pes = new Image("file:images/pes.jpg", true);
		ImageView i = new ImageView(pes);
		
		Button createButton = new Button("Create");
		createButton.setLayoutX(20);
		createButton.setLayoutY(20);
		createButton.setAlignment(Pos.CENTER_LEFT);
		
		StackPane stack = new StackPane();
		stack.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
		
		stack.setMaxSize(900, 900);
		stack.setAlignment(Pos.CENTER);
		stack.getChildren().add(i);
		stack.getChildren().add(createButton);
		
		Scene s = new Scene(stack, 660, 380);
		
		primaryStage.setScene(s);
		primaryStage.setTitle(title);
		primaryStage.show();
		
	}
	
	

}
