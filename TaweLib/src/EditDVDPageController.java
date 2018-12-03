import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The EditDVDPageController Class which controls the EditDVDPage.fxml
 * @author Ming
 *
 */
public class EditDVDPageController {

    @FXML private BorderPane editDVDPane;

    @FXML private TextField quantity;

    @FXML private TextField subtitleLanguage;

    @FXML private TextField language;

    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnConfirm(ActionEvent event) {

    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    /**
   	 * Close the window.
   	 */
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editDVDPane.getScene().getWindow();
	    stage.close();
	}
}
