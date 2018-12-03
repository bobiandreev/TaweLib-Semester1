import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The EditResourcesPageController Class which controls the EditResourcesPage.fxml
 * @author Ming
 *
 */
public class EditResourcesPageController {

    @FXML
    private Text editResourcesPane;

    @FXML
    private TextField changeQuantity;
    
    @FXML
    private void clickOnConfirm(ActionEvent event) {

    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editResourcesPane.getScene().getWindow();
	    stage.close();
	}
    
}
