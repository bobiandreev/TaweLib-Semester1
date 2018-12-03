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

    @FXML
    private BorderPane transactionHistoryPane;

    @FXML
    private ListView<String> transactionHistoryList;
    
    //private ArrayList<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();
    
    public void initialize() {

	}

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) transactionHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
