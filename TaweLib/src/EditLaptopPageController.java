import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The EditLaptopPageController Class which controls the EditLaptopPage.fxml
 * @author Ming
 *
 */
public class EditLaptopPageController {

    @FXML
    private BorderPane editLaptopPane;

    @FXML
    private TextField quantity;

    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editLaptopPane.getScene().getWindow();
	    stage.close();
	}
}
