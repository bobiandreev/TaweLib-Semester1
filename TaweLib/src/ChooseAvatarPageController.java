import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The ChooseAvatarPageController Class which controls the ChooseAvatarPage.fxml
 * 
 * @author Ming
 *
 */
public class ChooseAvatarPageController {

	@FXML
	private BorderPane chooseAvatarPane;

	private Alert alert = new Alert(AlertType.INFORMATION);

	public void showAlert() {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed! " + "Changes will have effect next time you log in!");
		alert.showAndWait();
	}

	private User curUser;

	@FXML
	public void initialize() {
		curUser = LoginController.getLoggedUser();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	public void clickOnDrawAvatar(ActionEvent event) {

	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnOK1(ActionEvent event) {
		Image image = new Image("Avatar1.png");
		curUser.setProfilePic(image);
		showAlert();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnOK2(ActionEvent event) {
		Image image = new Image("Avatar2.png");
		curUser.setProfilePic(image);
		showAlert();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnOK3(ActionEvent event) {
		Image image = new Image("Avatar3.png");
		curUser.setProfilePic(image);
		showAlert();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnOK5(ActionEvent event) {
		Image image = new Image("Avatar5.png");
		curUser.setProfilePic(image);
		showAlert();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnOk4(ActionEvent event) {
		Image image = new Image("Avatar4.png");
		curUser.setProfilePic(image);
		showAlert();
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
	private void closeWindow() {
		Stage stage = (Stage) chooseAvatarPane.getScene().getWindow();
		stage.close();
	}

}