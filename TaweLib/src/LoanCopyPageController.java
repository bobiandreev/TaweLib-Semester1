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
    	String username = this.userID.getText();
    	String item = this.item.getText();
    	Librarian.loanACopy(username, item);
    /*	User curUser = null;
    	Resource curResource = null;
    	for (User user: Librarian.getUsersList()) {
    		if (username.equals(user.getUsername().toString())) {
    			user = curUser;
    		}
    	}
    	for (Resource resource: SearchBrowse.getResources()) {
    		if(item.equals(resource.getTitle().toString())) {
    			resource = curResource;
    		}
    		*/
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
