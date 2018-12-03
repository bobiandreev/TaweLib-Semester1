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

    @FXML private BorderPane librarianFinePaymentPane;

    @FXML private ListView<?> finePaymentList;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnApprove(ActionEvent event) {

    }

    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnNotApprove(ActionEvent event) {

    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    /**
   	 * Close the window.
   	 */
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) librarianFinePaymentPane.getScene().getWindow();
	    stage.close();
	}
}