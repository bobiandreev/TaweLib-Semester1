import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The ReturnRequestPageController which controls the ReturnRequestPage.fxml
 * 
 * @author Ming
 *
 */
public class ReturnRequestPageController {
	private ArrayList<Copy> returnRequestCopies = new ArrayList<>();

	@FXML
	private BorderPane returnRequestPane;

	@FXML
	private ListView<String> returnRequestList;

	/**
	 * Initialize the controller. The following happen in this order: 1) First an
	 * instance of the controller is created (the constructor is called), 2) Next
	 * the @FXML variables are bound to the GUI components. 3) Finally, this
	 * initialize method is called.
	 */
	public void initialize() {
		for (User user : Librarian.getUsersList()) {
			for (Copy copy : user.getReturnRequests()) {
				String message = (user.getUsername().toString() + " has requested to return "
						+ copy.getResource().getTitle().toString());
				returnRequestCopies.add(copy);
				returnRequestList.getItems().add(message);
			}
		}
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnApprove(ActionEvent event) {
		int selectedIndex = returnRequestList.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText("Approved!");
		alert.showAndWait();

		Copy currentCopy = returnRequestCopies.get(selectedIndex);

		boolean yes = true;
		Librarian.approveReturn(yes, currentCopy);
		returnRequestList.getItems().remove(selectedIndex);
		returnRequestCopies.remove(selectedIndex);

	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnNotApprove(ActionEvent event) {
		int selectedIndex = returnRequestList.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText("Not Approved!");
		alert.showAndWait();

		Copy currentCopy = returnRequestCopies.get(selectedIndex);

		boolean no = false;
		Librarian.approveReturn(no, currentCopy);
		returnRequestList.getItems().remove(selectedIndex);
		returnRequestCopies.remove(selectedIndex);
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Close the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) returnRequestPane.getScene().getWindow();
		stage.close();
	}
}
