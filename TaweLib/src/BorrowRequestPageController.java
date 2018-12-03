import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorrowRequestPageController {
	private ArrayList<Copy> borrowRequestCopies = new ArrayList<>();

	@FXML
	private BorderPane borrowRequestPane;

	@FXML
	private ListView<String> borrowRequestList;

	// private ArrayList<String> borrowRequests = new ArrayList<>();
	// private ArrayList<> borrowRequests = new ArrayList<>();

	public void initialize() {
		for (User user : Librarian.getUsersList()) {
			for (Copy copy : user.getRequestedItems()) {
				String message = (user.getUsername().toString() + 
						" has requested to borrow " + copy.getResource().getTitle().toString());
				borrowRequestCopies.add(copy);
				borrowRequestList.getItems().add(message);
			}
		}
	}

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
		Librarian.approveBorrow(yes,currentCopy);
		borrowRequestList.getItems().remove(selectedIndex);
		borrowRequestCopies.remove(selectedIndex);
	}

	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

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

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowRequestPane.getScene().getWindow();
		stage.close();
	}
}