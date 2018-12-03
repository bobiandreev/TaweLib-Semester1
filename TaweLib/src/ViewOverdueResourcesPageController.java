import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The ViewOverdueResourcesPageController Class which controls the ViewOverdueResourcesPage.fxml
 * @author Ming
 *
 */
public class ViewOverdueResourcesPageController {

    @FXML
    private BorderPane overdueResourcesPane;

    @FXML
    private ListView<?> overdueResourcesList;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) overdueResourcesPane.getScene().getWindow();
	    stage.close();
	}
}
