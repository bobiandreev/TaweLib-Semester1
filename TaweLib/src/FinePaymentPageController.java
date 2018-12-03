import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The FinePaymentPageController Class which controls the FinePaymentPage.fxml
 * @author Ming
 *
 */
public class FinePaymentPageController {

    @FXML private BorderPane finePaymentPane;

    @FXML private Label showCurrentBalanceBox;

    @FXML private TextField payAmount;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnShowCurrentBalance(ActionEvent event) {
    	showCurrentBalanceBox.setText(Integer.toString(0));
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnConfirm(ActionEvent event) {

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
		Stage stage = (Stage) finePaymentPane.getScene().getWindow();
	    stage.close();
	}
}