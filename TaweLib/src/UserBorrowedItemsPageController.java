import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowedItemsPageController which controls the UserBorrowedItemsPage.fxml
 * @author Ming
 *
 */
public class UserBorrowedItemsPageController {

    @FXML
    private BorderPane borrowedItemsPane;

    @FXML
    private ListView<String> borrowedItemsList;
    
    private User curUser;
    
    public void initialize() {
    	curUser = LoginController.getLoggedUser();
    	for(Copy copy: curUser.getBorrowedItems()) {
    		Resource copyOf = copy.getResource();
    		String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
    		+ ". You have borrowed this on " + copy.getDateBorrowed()); 
    		if (copy.getDueDate() != null) {
    			copyProperties += ("\nThis item should be returned by " + copy.getDueDateString());
    		}
    		borrowedItemsList.getItems().add(copyProperties);
    	}
    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowedItemsPane.getScene().getWindow();
	    stage.close();
	}
}
