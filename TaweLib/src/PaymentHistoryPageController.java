import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaymentHistoryPageController {

    @FXML
    private ListView<String> paymentHistoryList;

    @FXML
    private BorderPane paymentHistoryPane;

    private User curUser;
    
    @FXML
    private void initialize() {
    	curUser = LoginController.getLoggedUser();
    	Collections.reverse(curUser.getPaymentHistory());
    	for (String string: curUser.getPaymentHistory()) {
    		paymentHistoryList.getItems().add(string);
    	}
    }
    
    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) paymentHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
