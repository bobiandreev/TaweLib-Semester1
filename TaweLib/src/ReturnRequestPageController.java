import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The ReturnRequestPageController which controls the ReturnRequestPage.fxml
 * @author Ming
 *
 */
public class ReturnRequestPageController {

    @FXML
    private BorderPane returnRequestPane;

    @FXML
    private ListView<?> returnRequestList;

    @FXML
    private void clickOnApprove(ActionEvent event) {

    }

    @FXML
    private void clickOnNotApprove(ActionEvent event) {

    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) returnRequestPane.getScene().getWindow();
	    stage.close();
	}
}