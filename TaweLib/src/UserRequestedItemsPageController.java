
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

    @FXML
    private BorderPane requestedItemsPane;

    @FXML
    private ListView<String> requestedItemsList;
    
    private User curUser;
    
    public void initialize() {
    	curUser = LoginController.getLoggedUser();
    	for(Copy copy: curUser.getRequestedItems()) {
    		//returnRequestCopies.add(copy);
    		Resource copyOf = copy.getResource();
    		String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
    		+ ". You have requested this on " + copy.getDateRequested());
    		requestedItemsList.getItems().add(copyProperties);
    	}
    }

    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) requestedItemsPane.getScene().getWindow();
	    stage.close();
	}
}
