import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateDVDPageController Class which controls the CreateDVDPage.fxml
 * @author Ming
 *
 */
public class CreateDVDPageController {

    @FXML private BorderPane createDVDPane;

    @FXML private TextField title;

    @FXML private TextField year;

    @FXML private TextField thumbnailImage;

    @FXML private TextField director;

    @FXML private TextField runtime;

    @FXML private TextField language;

    @FXML private TextField availavleSubtitles;
    
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
		Stage stage = (Stage) createDVDPane.getScene().getWindow();
	    stage.close();
	}
}