import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateNewUserPageController Class which controls the CreateNewUserPage.fxml
 * @author Ming
 *
 */
public class CreateNewUserPageController {

    @FXML
    private BorderPane createNewUserPane;

    @FXML
    private TextField userID;

    @FXML
    private TextField name;

    @FXML
    private TextField mobileNumber;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField streetName;

    @FXML
    private TextField postcode;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createNewUserPane.getScene().getWindow();
	    stage.close();
	}
    
}
