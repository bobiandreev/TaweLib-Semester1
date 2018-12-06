
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CopyHistoryPageController {

    @FXML
    private ListView<String> copyHistoryList;

    @FXML
    private BorderPane copyHistoryPane;

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
