import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    	Librarian.receiveReturn(username, item);
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
