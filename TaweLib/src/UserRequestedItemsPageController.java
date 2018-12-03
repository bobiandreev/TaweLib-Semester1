
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserRequestedItemsPageController Class which controls the UserRequestedItemsPage.fxml
 * @author Ming
 *
 */
public class UserRequestedItemsPageController {

    @FXML private BorderPane requestedItemsPane;

    @FXML private ListView<?> requestedItemsList;
    
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
		Stage stage = (Stage) requestedItemsPane.getScene().getWindow();
	    stage.close();
	}
}
