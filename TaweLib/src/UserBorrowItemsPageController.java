import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowItemsPageController Class which controls the UserBorrowItemsPage.fxml
 * @author Ming
 *
 */
public class UserBorrowItemsPageController {

    @FXML private BorderPane borrowItemsPane;

    @FXML private ListView<?> borrowItemsListborrowItemsList;

    @FXML private Button confirmButton;
    
    /**
   	 * Initialize the controller.
   	 * The following happen in this order:
   	 * 1) First an instance of the controller is created (the constructor is called),
   	 * 2) Next the @FXML variables are bound to the GUI components.
   	 * 3) Finally, this initialize method is called.
   	 */
    public void initialize() {
		confirmButton.setOnAction(e -> { handleConfirmButtonAction(); });

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
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowItemsPane.getScene().getWindow();
	    stage.close();
	}
}
