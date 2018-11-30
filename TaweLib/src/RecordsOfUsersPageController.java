import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The RecordsOfUsersPageController Class which controls the RecordsOfUsersPage.fxml
 * @author Ming
 *
 */
public class RecordsOfUsersPageController {

	@FXML
    private BorderPane recordsOfUsersPane;
    
    @FXML
    private ListView<?> recordOfUsersList;
    
    public void initialize() {

	}

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) recordsOfUsersPane.getScene().getWindow();
	    stage.close();
	}
}
