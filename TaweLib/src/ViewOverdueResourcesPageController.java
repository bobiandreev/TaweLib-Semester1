import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The ViewOverdueResourcesPageController Class which controls the ViewOverdueResourcesPage.fxml
 * @author Ming
 *
 */
public class ViewOverdueResourcesPageController {

    @FXML
    private BorderPane overdueResourcesPane;

    @FXML
    private ListView<String> overdueResourcesList;
    
    public void initialize() {
    	for (User user : Librarian.getUsersList()) {
    		if (user.getBorrowedItems() != null) {
    			for (Copy copy : user.getBorrowedItems()) {
    				if (copy.getDueDate() != null) {
    					String message = "This " + copy.getResource().getTitle()
            					+ " copy, with number " + copy.getCopyId() + 
            					" should have been returned from " + 
            					copy.getBorrowedBy().getUsername() + " by " +
            					copy.getDueDateString() + ".";
            			overdueResourcesList.getItems().add(message);
    				}	
        		}
    		}
    	}
    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) overdueResourcesPane.getScene().getWindow();
	    stage.close();
	}
}
