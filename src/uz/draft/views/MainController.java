package uz.draft.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import uz.draft.models.Championship;

public class MainController extends VBox{
	
	private Draft draftMainApp;
	
	@FXML private Label draftLabel;
	@FXML private Button makeDraftButton;
	@FXML private Button addChampionshipButton;
	@FXML private Button editChampionshipButton;
	@FXML private Button deleteChampionshipButton;
	
	@FXML private TableView<Championship> championshipTable;
	@FXML private TableColumn<Championship, String> championshipName;
	@FXML private TableColumn<Championship, String> championshipPrize;
	
	@FXML private GridPane detailsTable;
	@FXML private Label championshipNameLabel;
	@FXML private Label prizeLabel;
	@FXML private Label numberLabel;
	@FXML private Label refereeLabel;
	  
	@FXML public void handleMakeDraftButton(ActionEvent event){
		
	}
	@FXML public void handleAddChampionshipButton(){
	    	Championship newChampionship = new Championship();
	    	
	        boolean okClicked = draftMainApp.showChampionshipEditDialog(newChampionship);
	        if (okClicked) {
	            draftMainApp.getChampionshipData().add(newChampionship);
	            //save to db
	            draftMainApp.table.addChampionship(newChampionship);
	        }
	}
	    
	@FXML public void handleEditChampionshipButton() {
	        Championship selectedChampionship = championshipTable.getSelectionModel().getSelectedItem();
	        if (selectedChampionship != null) {
	            boolean okClicked = draftMainApp.showChampionshipEditDialog(selectedChampionship);
	            if (okClicked) {
	            	//update db
	            	draftMainApp.table.updateChampionship(selectedChampionship);
	            	showChampionshipDetails(selectedChampionship);
	            	
	            }

	        } else {
	            // Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(draftMainApp.getStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Championship Selected");
	            alert.setContentText("Please select a championship in the table.");

	            alert.showAndWait();
	        }
	    }
	
	@FXML private void handleDeleteChampionshipButton(ActionEvent event) {
		int selectedIndex = championshipTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Championship ch = championshipTable.getItems().get(selectedIndex);
			draftMainApp.table.deleteChampionship(ch);
			championshipTable.getItems().remove(ch);
			
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(draftMainApp.getStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Championship Selected");
			alert.setContentText("Please select a championship in the table.");

			alert.showAndWait();
		}
	}
	
	public MainController(){
		
	}
	
	@FXML private void initialize(){

		  championshipName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		  
		  showChampionshipDetails(null);
		  
		  championshipTable.getSelectionModel().selectedItemProperty().addListener(
		            (observable, oldValue, newValue) -> showChampionshipDetails(newValue));
		  

	}

	public void showChampionshipDetails(Championship ch){
		if(ch != null){				
			this.detailsTable.setVisible(true);
			this.championshipNameLabel.setText(ch.getName());
			this.prizeLabel.setText(ch.getPrize());
			this.numberLabel.setText("4");
			this.refereeLabel.setText(ch.getReferee());
		}else{
			this.championshipNameLabel.setText("");
			this.prizeLabel.setText("");
			this.numberLabel.setText("");
			this.refereeLabel.setText("");
			this.detailsTable.setVisible(false);
		}
	}
	public void setMainApp(Draft mainApp) {
        this.draftMainApp = mainApp;
        championshipTable.setItems(draftMainApp.getChampionshipData());

}

}
