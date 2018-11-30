import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The LoanCopyPageController which controls the LoanCopyPage.fxml
 * @author Ming
 *
 */
public class LoanCopyPageController {

    @FXML
    private BorderPane loanCopyPane;

    @FXML
    private TextField userID;

    @FXML
    private TextField item;

    @FXML
	private void clickOnLoan(ActionEvent event) {

    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) loanCopyPane.getScene().getWindow();
	    stage.close();
	}
}
