
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class the controls the copy history page.
 * 
 * @author Owner Kyriacos Mosphilis and Boris Andreev.
 * @version 1.0
 */
public class CopyHistoryPageController {

    @FXML
    private ListView<String> copyHistoryList;

    @FXML
    private BorderPane copyHistoryPane;

    private Copy selectedCopy;

    @FXML
    private void initialize() {
	selectedCopy = DisplayCopiesPageController.getSelectedCopy();
	for (int i = 0; i < selectedCopy.getCopyHistory().size(); i++) {
	    String copyHistory = selectedCopy.getCopyHistory().get(i);
	    copyHistoryList.getItems().add(copyHistory);
	}
    }

    @FXML
    void clickOnBack(ActionEvent event) {
	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
	Stage stage = (Stage) copyHistoryPane.getScene().getWindow();
	stage.close();
    }
}
