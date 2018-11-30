import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserRequestItemsPageController {

    @FXML
    private BorderPane requestItemsPane;

    @FXML
    private ListView<?> requestItemsList;

    @FXML
    private Button confirmButton;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

     @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) requestItemsPane.getScene().getWindow();
	    stage.close();
	}
}
