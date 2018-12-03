import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserFinePaymentPageController Class which controls the UserFinePaymentPage.fxml
 * @author Ming
 *
 */
public class UserFinePaymentPageController {

    @FXML private BorderPane userFinePaymentPane;

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
		Stage stage = (Stage) userFinePaymentPane.getScene().getWindow();
	    stage.close();
	}
}