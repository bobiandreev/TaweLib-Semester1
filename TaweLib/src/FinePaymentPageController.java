import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinePaymentPageController {

	@FXML
	private BorderPane finePaymentPane;

	@FXML
	private Label showCurrentBalanceBox;

	@FXML
	private TextField username;

	@FXML
	private TextField payAmount;

	private User curUser;

	@FXML
	private void clickOnShowCurrentBalance(ActionEvent event) throws IOException {
		String username = this.username.getText();
		if (username.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("No input!");
			alert.setContentText("Please input a username.");
			alert.showAndWait();
		} else { // The case when the librarian fill in their LibrarianID correctly
			ArrayList<User> usersList = new ArrayList<>();
			usersList.addAll(Librarian.getUsersList());
			int index = 0;
			do {
				if (username.equals(usersList.get(index).getUsername())) {
					curUser = usersList.get(index);
				}
				index++;
			} while (index != usersList.size() && username.equals(curUser.getUsername()));
			if (username.equals(curUser.getUsername())) {
				String balance = String.valueOf(curUser.getBalance());
				showCurrentBalanceBox.setText(balance);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("No such user!");
				alert.setContentText("Wrong username or no such user exists!");
				alert.showAndWait();
			}
		}
	}

	@FXML
	private void clickOnConfirm(ActionEvent event) {
		Double amount = 0.0;
		try {
			amount = Double.parseDouble(this.payAmount.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Not a valid number");
			alert.setContentText("Please enter a valid number!");
			alert.showAndWait();
		}

		if (amount != 0.0) {
			curUser.payFine(amount);
			curUser.setPaymentHistory(Copy.getDateNow(), amount);
			Alert alert1 = new Alert(AlertType.CONFIRMATION);
			alert1.setHeaderText("Success");
			alert1.setContentText("Fine payment successful!");
			alert1.showAndWait();
		}
	}

	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) finePaymentPane.getScene().getWindow();
		stage.close();
	}
}