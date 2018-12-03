import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

<<<<<<< HEAD
    @FXML
    private TextField payAmount;

    @FXML
    private void clickOnShowCurrentBalance(ActionEvent event) {
    	//showCurrentBalanceBox.setText(Integer.toString(0));
    	String fines = String.valueOf(LoginController.getLoggedUser().getBalance());
		showCurrentBalanceBox.setText(fines);
=======
    @FXML private TextField payAmount;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */  
    @FXML private void clickOnShowCurrentBalance(ActionEvent event) {
    	showCurrentBalanceBox.setText(Integer.toString(0));
>>>>>>> branch 'master' of https://gitlab.com/ONixon/group-41.git
    }
    
<<<<<<< HEAD
    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	int paymentAmount = Integer.parseInt(this.payAmount.getText());
    	LoginController.getLoggedUser().payFine(paymentAmount);
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Payment Successful");
		alert.setContentText("You have paid " + paymentAmount + " pounds towards your fine.");
		alert.showAndWait();
=======
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */  
    @FXML private void clickOnConfirm(ActionEvent event) {

>>>>>>> branch 'master' of https://gitlab.com/ONixon/group-41.git
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