import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateLaptopPageController Class which controls the CreateLaptopPage.fxml
 * @author Ming
 *
 */
public class CreateLaptopPageController {

    @FXML
    private BorderPane createLaptopPane;

    @FXML
    private TextField itemID;

    @FXML
    private TextField title;

    @FXML
    private TextField year;

    @FXML
    private TextField thumbnailImage;

    @FXML
    private TextField manufacturer;

    @FXML
    private TextField model;

    @FXML
    private TextField operatingSystem;

    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createLaptopPane.getScene().getWindow();
	    stage.close();
	}
}