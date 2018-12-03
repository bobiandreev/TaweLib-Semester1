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

/**
 * The ChooseAvatarPageController Class which controls the ChooseAvatarPage.fxml
 * @author Ming
 *
 */
public class ChooseAvatarPageController {

	@FXML private BorderPane chooseAvatarPane;
	   
	Alert alert = new Alert(AlertType.INFORMATION);
	 
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML public void clickOnDrawAvatar(ActionEvent event){

    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnOK1(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnOK2(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnOK3(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnOK5(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnOk4(ActionEvent event) {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed!");
		alert.showAndWait();
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    /**
	 * Close the window.
	 */
    @FXML
    private void closeWindow() {
		Stage stage = (Stage) chooseAvatarPane.getScene().getWindow();
	    stage.close();
	}
    
}