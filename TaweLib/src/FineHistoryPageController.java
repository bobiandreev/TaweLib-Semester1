import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FineHistoryPageController {

    @FXML
    private ListView<String> fineHistoryList;

    @FXML
    private BorderPane fineHistoryPane;

    private User curUser;
    
    @FXML
    private void initialize() {
    	curUser = LoginController.getLoggedUser();
    	Collections.reverse(curUser.getFineHistory());
    	for (String string: curUser.getFineHistory()) {
    		fineHistoryList.getItems().add(string);
    	}
    }
    
    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) fineHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
