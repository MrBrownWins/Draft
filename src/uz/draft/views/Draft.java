package uz.draft.views;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uz.draft.db.ChampionshipTable;
import uz.draft.models.Championship;


public class Draft extends Application {
	final static String TITLE = new String("Welcome to Draft!");
	final  Image ICON = new Image("file:resources/img/draft-icon.png");
	
	public final String MAIN_VIEW = new String("layouts/MainView.fxml");
	public final String DIALOG_VIEW = new String("layouts/ChampionshipDialog.fxml");
	public ChampionshipTable table = new ChampionshipTable();
	
	private Stage mainStage;
	private AnchorPane rootLayout;
	
    private ObservableList<Championship> championshipData = FXCollections.observableArrayList();
    
    public Draft(){
    	this.championshipData = table.allChampionships();
   
    }  	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		this.setStage(primaryStage);
	
		initRootLayout();
		showMainView();
	
	}
	 public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Draft.class.getResource("layouts/RootLayout.fxml"));
	            rootLayout = (AnchorPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene mainScene = new Scene(rootLayout);
				mainStage.setScene(mainScene);
	            mainStage.setTitle(TITLE);
				mainStage.getIcons().add(ICON);
				mainStage.centerOnScreen();
				mainStage.show();
				
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	private void showMainView()  {
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Draft.class.getResource(MAIN_VIEW));
			VBox mainView = (VBox)loader.load();
			
            rootLayout.getChildren().add(mainView);	        
			
			MainController controller = loader.getController();
	        controller.setMainApp(this);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean showChampionshipEditDialog(Championship ch) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Draft.class.getResource(DIALOG_VIEW));
			VBox page = (VBox) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Championship");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(mainStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the Championship into the controller.
			ChampionshipDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setChampionship(ch);
			
			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void setStage(Stage stage) {
		this.mainStage = stage;
	}

	public Stage getStage() {
		return this.mainStage;
	}
	
	public ObservableList<Championship> getChampionshipData() {
		return championshipData;
	}

	public void setChampionshipData(ObservableList<Championship> championshipData) {
		this.championshipData = championshipData;
	}
	 //shows Main Page 
  	public static void show(String[] args){
  		Draft.launch(args);
  	}

}
