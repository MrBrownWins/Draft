package uz.draft.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class MainPageController {
	@FXML public static ListView<MenuItem> championshipList;
	@FXML private Label actionTarget;
	@FXML private Button newButton;
	@FXML private Button deleteButton;
	
	@FXML protected void handleNewButtonAction(ActionEvent event) {
		//championshipList.getChildrenUnmodifiable().add();
        actionTarget.setText("New Button Pressed");
    }
	
	
	
	

}
