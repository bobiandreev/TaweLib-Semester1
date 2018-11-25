import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowItemsPageController Class which controls the UserBorrowItemsPage.fxml
 * @author Ming
 *
 */
public class UserBorrowItemsPageController {

    @FXML
    private BorderPane borrowItemsPane;

    @FXML
    private ListView<?> borrowItemsListborrowItemsList;

    @FXML
    private Button confirmButton;
    
    public void initialize() {
		confirmButton.setOnAction(e -> { handleConfirmButtonAction(); });

	}
    
    private void handleConfirmButtonAction() {
	// TODO Auto-generated method stub
	
    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowItemsPane.getScene().getWindow();
	    stage.close();
	}
}
