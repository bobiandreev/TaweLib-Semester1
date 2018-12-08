import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RecieveReturnPageController {

    @FXML
    private BorderPane recieveReturnPane;

    @FXML
    private TextField userID;

    @FXML
    private TextField item;

    @FXML
    private void clickOnRecieve(ActionEvent event) {
    	String username = this.userID.getText();
    	String item = this.item.getText();
    	try {
    	Librarian.receiveReturn(username, item);
    	} catch(NullPointerException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setHeaderText("Error!");
    		alert.setContentText("This user does not have this item!");
    		alert.showAndWait();
    	}
    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) recieveReturnPane.getScene().getWindow();
	    stage.close();
	} 
}
