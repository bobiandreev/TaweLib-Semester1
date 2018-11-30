import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateBookPageController Class which controls the CreateBookPage.fxml
 * @author Ming
 *
 */
public class CreateBookPageController {

    @FXML
    private BorderPane createBookPane;

    @FXML
    private TextField itemID;

    @FXML
    private TextField title;

    @FXML
    private TextField year;

    @FXML
    private TextField thumbnailImage;

    @FXML
    private TextField author;

    @FXML
    private TextField publisher;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createBookPane.getScene().getWindow();
	    stage.close();
	}
    
}