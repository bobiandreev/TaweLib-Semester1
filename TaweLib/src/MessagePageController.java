import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The MessagePageController  Class which controls the MessagePage.fxml 
 * @author Ming
 *
 */
public class MessagePageController {

    @FXML private BorderPane messagePane;

    @FXML private ListView<String> messageList;
    
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
    @FXML private void closeWindow() {
		Stage stage = (Stage) messagePane.getScene().getWindow();
	    stage.close();
	}
}
