import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateNewUserPageController Class which controls the CreateNewUserPage.fxml
 * @author Ming and Boris
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
    	String username = this.userID.getText();
    	String name = this.name.getText();
    	String mobileNumber = this.mobileNumber.getText();
    	String houseNumber = this.houseNumber.getText();
    	String streetName = this.streetName.getText();
    	String postcode = this.postcode.getText();
    	String profilePic = "Avatar5.png";
    	if (!Librarian.checkUserName(username)) {
    		Librarian.addUser(new User(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic));
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setHeaderText("Done");
    		alert.setContentText("New user created!");
    		alert.showAndWait();
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
        	alert.setHeaderText("Problem Found");
    		alert.setContentText("This username already exist!\n"
    				+ "Please add a new username!");
    		alert.showAndWait();
    	}
    	
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createNewUserPane.getScene().getWindow();
	    stage.close();
	}
    
}
