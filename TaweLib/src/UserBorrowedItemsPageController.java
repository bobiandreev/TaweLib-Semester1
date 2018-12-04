import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowedItemsPageController which controls the UserBorrowedItemsPage.fxml
 * @author Ming
 *
 */
public class UserBorrowedItemsPageController {
	private ArrayList<Copy> returnRequestCopies = new ArrayList<>();
    @FXML
    private BorderPane borrowedItemsPane;

    @FXML
    private ListView<String> borrowedItemsList;
    
    @FXML
    private Button requestToReturn;
    
    private User curUser;
    
    public void initialize() {
    	curUser = LoginController.getLoggedUser();
    	for(Copy copy: curUser.getBorrowedItems()) {
    		returnRequestCopies.add(copy);
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
    private void clickOnRequestToReturn(ActionEvent event) {
    	int selectedIndex = borrowedItemsList.getSelectionModel().getSelectedIndex();
    	Copy currentCopy = returnRequestCopies.get(selectedIndex);
    	curUser.requestReturn(currentCopy);
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Request successful");
		alert.setHeaderText("You have successfully requested to return the item!");
		//alert.setContentText("Approved!");
		alert.showAndWait();
    	
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
