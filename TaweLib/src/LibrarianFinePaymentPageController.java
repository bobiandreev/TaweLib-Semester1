import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The LibrarianFinePaymentPageController Class which controls the LibrarianFinePaymentPage.fxml
 * @author Ming
 *
 */
public class LibrarianFinePaymentPageController {

    @FXML
    private BorderPane librarianFinePaymentPane;

    @FXML
    private ListView<?> finePaymentList;

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
		Stage stage = (Stage) librarianFinePaymentPane.getScene().getWindow();
	    stage.close();
	}
}