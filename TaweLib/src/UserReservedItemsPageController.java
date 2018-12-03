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
    private ListView<?> reservedItemsList;

    private void handleConfirmButtonAction() {
	// TODO Auto-generated method stub
	
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