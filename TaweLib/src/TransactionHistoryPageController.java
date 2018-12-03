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
public class TransactionHistoryPageController {

    @FXML private BorderPane transactionHistoryPane;

    @FXML private ListView<String> transactionHistoryList;
    
    private ArrayList<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();
    
    /**
   	 * Initialize the controller.
   	 * The following happen in this order:
   	 * 1) First an instance of the controller is created (the constructor is called),
   	 * 2) Next the @FXML variables are bound to the GUI components.
   	 * 3) Finally, this initialize method is called.
   	 */
    public void initialize() {
    	transactionHistories.add(new TransactionHistory("Ming", "Harry Potter and the Sorcerer's Stone"));
    	transactionHistories.add(new TransactionHistory("Andy", "Harry Potter and the Chamber of Secrets"));
    	transactionHistories.add(new TransactionHistory("Brian", "Harry Potter and the Prisoner of Azkaban"));
    	transactionHistories.add(new TransactionHistory("June", "Harry Potter and the Goblet of Fire"));
    	transactionHistories.add(new TransactionHistory("Vianne", "Harry Potter and the Order of the Phoenix"));
    	transactionHistories.add(new TransactionHistory("Christy", "Harry Potter and the Half-Blood Prince"));
    	transactionHistories.add(new TransactionHistory("Judy", "Harry Potter and the Deathly Hallows"));
    	transactionHistories.add(new TransactionHistory("Emily", "Harry Potter and the Cursed Child "));
    	
    	addToList();
 
	}
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    private void addToList() { //show it to interface
		for (TransactionHistory t : transactionHistories) {
			transactionHistoryList.getItems().add(t.getDescriptionForList());
		}
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
