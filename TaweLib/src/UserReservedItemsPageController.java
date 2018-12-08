import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1> Manage User Requested Items. </h1>
 * The UserReservedItemsPageController Class which controls the UserReservedItemsPage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-04
 */
public class UserReservedItemsPageController {

    @FXML
    private BorderPane reservedItemsPane;

    @FXML
    private ListView<String> reservedItemsList = new ListView<>();

    private User curUser;
    
    /**
     * This method sets up the reserved status (alongside requested date) 
     * of a resource for the User. 
     * (Stores resource into list to signify reserved state.)
     */
    public void initialize() {
    	curUser = LoginController.getLoggedUser();
    	for(Copy copy: curUser.getReservedFor()) {
    		//returnRequestCopies.add(copy);
    		Resource copyOf = copy.getResource();
    		String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
    		+ ". This has been reserved for you on " + copy.getDateRequested());
    		reservedItemsList.getItems().add(copyProperties);
    	}
    }
    
    /**
	 * Actions will be made when the user clicks on the button.
	 * Returns to previous window by closing the current/most recent one.
	 * 
	 * @param event - When the mouse clicks on the button.
	 */
    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    
    /**
     * This method closes the window.
     */
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) reservedItemsPane.getScene().getWindow();
	    stage.close();
	}
}