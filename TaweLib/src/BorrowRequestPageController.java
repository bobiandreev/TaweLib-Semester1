import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The BorrowRequestPageController which controls the BorrowRequestPage.fxml
 * @author Ming
 *
 */
public class BorrowRequestPageController {

    @FXML
    private BorderPane borrowRequestPane;

    @FXML
    private ListView<?> borrowRequestList;

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
		Stage stage = (Stage) borrowRequestPane.getScene().getWindow();
	    stage.close();
	}
}