import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChooseAvatarPageController {

	Alert alert = new Alert(AlertType.INFORMATION);
	
    @FXML
    private BorderPane chooseAvatarPane;

    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    public void clickOnDrawAvatar(ActionEvent event){

    }

    @FXML
    void clickOnOK1(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }

    @FXML
    void clickOnOK2(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }

    @FXML
    void clickOnOK3(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }

    @FXML
    void clickOnOK5(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }

    @FXML
    void clickOnOk4(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) chooseAvatarPane.getScene().getWindow();
	    stage.close();
	}
    
}