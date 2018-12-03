import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MessagePageController {

    @FXML
    private BorderPane messagePane;

    @FXML
    private ListView<?> messageList;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) messagePane.getScene().getWindow();
	    stage.close();
	}
}
