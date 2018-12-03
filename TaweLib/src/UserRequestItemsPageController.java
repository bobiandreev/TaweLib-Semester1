import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserRequestedItemsPageController Class which controls the UserRequestedItemsPage.fxml
 * @author Ming
 *
 */
public class UserRequestItemsPageController {

    @FXML private BorderPane requestItemsPane;

    @FXML private ListView<String> requestItemsList;

    @FXML private Button confirmButton;

	/**
	 * Initialize the controller.
	 * The following happen in this order:
	 * 1) First an instance of the controller is created (the constructor is called),
	 * 2) Next the @FXML variables are bound to the GUI components.
	 * 3) Finally, this initialize method is called.
	 */
	public void initialize() {

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
		Stage stage = (Stage) requestItemsPane.getScene().getWindow();
	    stage.close();
	}
}
