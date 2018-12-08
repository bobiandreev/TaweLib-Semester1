import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The LoanCopyPageController which controls the LoanCopyPage.fxml
 * 
 * @author Ming
 * @version 1.0
 */
public class LoanCopyPageController {

    @FXML
    private BorderPane loanCopyPane;

    @FXML
    private TextField userID;

    @FXML
    private TextField item;

    /**
     * Method to loan a copy.
     * 
     * @param event Mouse click on Loan.
     */
    @FXML
    private void clickOnLoan(ActionEvent event) {
	String username = this.userID.getText();
	String item = this.item.getText();
	Librarian.loanACopy(username, item);
    }

    /**
     * Method to close the window.
     * 
     * @param event Mouse click on Back button.
     */
    @FXML
    private void clickOnBack(ActionEvent event) {
	closeWindow();
    }

    /**
     * Method to close the window.
     */
    @FXML
    private void closeWindow() { // A method which close the window
	Stage stage = (Stage) loanCopyPane.getScene().getWindow();
	stage.close();
    }
}
