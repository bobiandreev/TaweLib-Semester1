import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1> Process borrow requests. </h1>
 * The BorrowRequestPageController Class which controls the
 * BorrowRequestPage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-04
 *
 */
public class BorrowRequestPageController {
	private ArrayList<Copy> borrowRequestCopies = new ArrayList<>();

	@FXML
	private BorderPane borrowRequestPane;

	@FXML
	private ListView<String> borrowRequestList;

	// private ArrayList<String> borrowRequests = new ArrayList<>();
	// private ArrayList<> borrowRequests = new ArrayList<>();

	/**
	 * Initialize the controller. The following happen in this order: 1) First an
	 * instance of the controller is created (the constructor is called), 2) Next
	 * the @FXML variables are bound to the GUI components. 3) Finally, this
	 * initialize method is called.
	 */
	public void initialize() {
		for (User user : Librarian.getUsersList()) {
			for (Copy copy : user.getRequestedItems()) {
				String message = (user.getUsername().toString() + " has requested to borrow "
						+ copy.getResource().getTitle().toString());
				borrowRequestCopies.add(copy);
				borrowRequestList.getItems().add(message);
			}
		}
	}

	/**
	 * Actions will be made when the user clicks on the button.
	 * Approves the borrow request. Displays appropriate alert boxes
	 * accordingly.
	 * 
	 * @param event - When the mouse clicks on the button.
	 */
	@FXML
	void clickOnApprove(ActionEvent event) {
		int selectedIndex = borrowRequestList.getSelectionModel().getSelectedIndex();

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

		Copy currentCopy = borrowRequestCopies.get(selectedIndex);

		boolean yes = true;
		Librarian.approveBorrow(yes, currentCopy);
		borrowRequestList.getItems().remove(selectedIndex);
		borrowRequestCopies.remove(selectedIndex);
	}

	/**
	 * Actions will be made when the user clicks on the button.
	 * Disapprove borrow requests. Displays appropriate alert boxes
	 * accordingly.
	 * 
	 * @param event - When the mouse clicks on the button.
	 */
	@FXML
	void clickOnNotApprove(ActionEvent event) {
		int selectedIndex = borrowRequestList.getSelectionModel().getSelectedIndex();

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

		Copy currentCopy = borrowRequestCopies.get(selectedIndex);

		boolean no = false;
		Librarian.approveBorrow(no, currentCopy);
		borrowRequestList.getItems().remove(selectedIndex);
		borrowRequestCopies.remove(selectedIndex);
	}

	/**
	 * Actions will be made when the user clicks on the button.
	 * Returns to previous window by closing the current/most recent one.
	 * 
	 * @param event - When the mouse clicks on the button.
	 */
	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Close the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowRequestPane.getScene().getWindow();
		stage.close();
	}
}