import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The BorrowRequestPageController which controls the BorrowRequestPage.fxml
 * @author Ming
 *
 */
public class BorrowRequestPageController {
	private static boolean decision;

    @FXML
    private Button approveID;

    @FXML
    private BorderPane borrowRequestPane;

    @FXML
    private ListView<String> borrowRequestList;
    
    private ArrayList<BorrowRequest> borrowRequests = new ArrayList<BorrowRequest>();
    
    public void initialize() {
    	borrowRequests.add(new BorrowRequest("Ming", "Harry Potter and the Sorcerer's Stone"));
    	borrowRequests.add(new BorrowRequest("June", "Harry Potter and the Goblet of Fire"));
    	addToList();
 
	}
    
    private void addToList() { //show it to interface
		for (BorrowRequest t : borrowRequests) {
			borrowRequestList.getItems().add(t.toString());
		}
	}
    
   
    @FXML
    private static void clickOnApprove(ActionEvent event) {
    	decision = true;
    /*	int selectedIndex = borrowRequestList.getSelectionModel().getSelectedIndex();
    	
    	if (selectedIndex < 0) {
			// Show a message
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}
    	
    	BorrowRequest selectedBookRequest = borrowRequests.get(selectedIndex);
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText(borrowRequests.get(selectedIndex).toString());
		alert.showAndWait();
		*/
    	Librarian.approveBorrow(decision);
    }

    @FXML
    private void clickOnNotApprove(ActionEvent event) {
    	decision = false;

    }
     
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowRequestPane.getScene().getWindow();
	    stage.close();
	}
}