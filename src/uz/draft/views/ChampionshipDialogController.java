package uz.draft.views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uz.draft.models.Championship;

public class ChampionshipDialogController extends MainController{

    @FXML private TextField championshipNameField;
    @FXML private TextField prizeField;
    @FXML private TextField refereeField;

    @FXML private Label statusMessageLabel;
    @FXML private Button okButton;
    @FXML private Button cancelButton;
    
    private Stage dialogStage;
    private Championship championship;
    private boolean okClicked = false;

    @FXML private void initialize() {
    	
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setChampionship(Championship ch) {
        this.championship = ch;
        championshipNameField.setText(ch.getName());
        prizeField.setText(ch.getPrize());
        refereeField.setText(ch.getReferee());

    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML private void handleOkButton() {
        if (checkInputData()) {
        	championship.setName(championshipNameField.getText());
        	championship.setPrize(prizeField.getText());
        	championship.setReferee(refereeField.getText());
            
        	okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML private void handleCancelButton() {
        dialogStage.close();
    }

    private boolean checkInputData() {
        String errorMessage = "";

        if (championshipNameField.getText() == null || championshipNameField.getText().length() == 0) {
            errorMessage += "Pleace enter at least championship name!\n"; 
        }
    
        if (errorMessage.length() == 0) {
            return true;
        } else {
        	statusMessageLabel.setText(errorMessage);
            return false;
        }
    }
}
