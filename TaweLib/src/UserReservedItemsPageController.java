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

    @FXML
    private BorderPane reservedItemsPane;

    @FXML
    private ListView<String> reservedItemsList = new ListView<>();

    private User curUser;
    
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
    
    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) reservedItemsPane.getScene().getWindow();
	    stage.close();
	}
}