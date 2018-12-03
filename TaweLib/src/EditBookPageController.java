import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The EditBookPageController Class which controls the EditBookPage.fxml
 * @author Ming
 *
 */
public class EditBookPageController {

    @FXML private BorderPane editBookPane;

    @FXML private TextField quantity;

    @FXML private TextField genre;

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
    @FXML private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    /**
   	 * Close the window.
   	 */
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editBookPane.getScene().getWindow();
	    stage.close();
	}
}
