import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Kyriacos Mosphilis and Boris Andreev
 * @version 1.0
 *
 */
public class FineHistoryPageController {

    @FXML
    private ListView<String> fineHistoryList;

    @FXML
    private BorderPane fineHistoryPane;

    private User curUser;

    /**
     * Initialize the controller. The following happen in this order: 1) First
     * an instance of the controller is created (the constructor is called), 2)
     * Next the @FXML variables are bound to the GUI components. 3) Finally,
     * this initialize method is called.
     */
    @FXML
    private void initialize() {
	curUser = LoginController.getLoggedUser();
	Collections.reverse(curUser.getFineHistory());
	for (String string : curUser.getFineHistory()) {
	    fineHistoryList.getItems().add(string);
	}
    }

    /**
     * Method to close the window.
     * 
     * @param event Mouse click on Back button.
     */
    @FXML
    void clickOnBack(ActionEvent event) {
	closeWindow();
    }

    /**
     * Method to close the window.
     */
    @FXML
    private void closeWindow() { // A method which close the window
	Stage stage = (Stage) fineHistoryPane.getScene().getWindow();
	stage.close();
    }
}
