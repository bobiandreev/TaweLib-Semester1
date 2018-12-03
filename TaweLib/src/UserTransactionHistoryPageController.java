import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserTransactionHistoryPageController Class which controls the UserTransactionHistoryPage.fxml
 * @author Ming
 *
 */

public class UserTransactionHistoryPageController {

    @FXML private BorderPane transactionHistoryPane;

    @FXML private ListView<String> transactionHistoryList;
    
    //private ArrayList<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();
    
    /**
   	 * Initialize the controller.
   	 * The following happen in this order:
   	 * 1) First an instance of the controller is created (the constructor is called),
   	 * 2) Next the @FXML variables are bound to the GUI components.
   	 * 3) Finally, this initialize method is called.
   	 */
    public void initialize() {

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
		Stage stage = (Stage) transactionHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
