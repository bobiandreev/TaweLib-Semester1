import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The RecieveReturnPageController Class which controls the RecieveReturnPage.fxml 
 * @author Ming
 *
 */
public class RecieveReturnPageController {

    @FXML private BorderPane recieveReturnPane;

    @FXML private TextField userID;

    @FXML private TextField item;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnRecieve(ActionEvent event) {

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
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) recieveReturnPane.getScene().getWindow();
	    stage.close();
	} 
}
