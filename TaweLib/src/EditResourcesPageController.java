import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * <h1>Make changes in regards to the resources available.</h1> The
 * EditResourcesPageController Class which controls the EditResourcesPage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-03
 */
public class EditResourcesPageController {

	@FXML
	private Text editResourcesPane;

	@FXML
	private TextField changeQuantity;

	/**
	 * Actions will be made when the user clicks on the button. Confirms the
	 * changes made to the resource(s).
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {

	}

	/**
	 * Actions will be made when the user clicks on the button. Returns to
	 * previous window by closing the current/most recent one.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editResourcesPane.getScene().getWindow();
		stage.close();
	}

}
