import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserReservedItemsPageController Class which controls the UserReservedItemsPage.fxml
 * @author Ming
 *
 */
public class UserReservedItemsPageController {

    @FXML private BorderPane reservedItemsPane;

    @FXML private ListView<String> reservedItemsList;

    /**
	 * Initialize the controller.
	 * The following happen in this order:
	 * 1) First an instance of the controller is created (the constructor is called),
	 * 2) Next the @FXML variables are bound to the GUI components.
	 * 3) Finally, this initialize method is called.
	 */
	public void initialize() {

	}
	
    private void handleConfirmButtonAction() {
	// TODO Auto-generated method stub
	
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
   @FXML private void closeWindow() { 
		Stage stage = (Stage) reservedItemsPane.getScene().getWindow();
	    stage.close();
	}
}