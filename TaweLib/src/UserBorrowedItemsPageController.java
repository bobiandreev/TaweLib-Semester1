import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowedItemsPageController which controls the UserBorrowedItemsPage.fxml
 * @author Ming
 *
 */
public class UserBorrowedItemsPageController {

    @FXML
    private BorderPane borrowedItemsPane;

    @FXML
    private ListView<?> borrowedItemsList;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowedItemsPane.getScene().getWindow();
	    stage.close();
	}
}
