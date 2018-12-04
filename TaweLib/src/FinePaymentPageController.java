import java.io.IOException;

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
			for (int i = 0; i < Librarian.getUsersList().size(); i++) {
					if (username.equals(Librarian.getUsersList().get(i).getUsername())) {
						curUser = Librarian.getUsersList().get(i);
						String balance = String.valueOf(curUser.getBalance());
						showCurrentBalanceBox.setText(balance);
					} else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("No such user!");
						alert.setContentText("Wrong username or no such librarian exists!");
						alert.showAndWait();
				} 
				}
			}
		}
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		double amount = Double.parseDouble(this.payAmount.getText());
		curUser.payFine(amount);
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