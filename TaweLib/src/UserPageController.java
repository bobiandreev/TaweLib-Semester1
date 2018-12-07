import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The UserPageController Class which controls the UserPage.fxml
 * 
 * @author Ming
 *
 */
public class UserPageController {

	@FXML
	private Label showCurrentBalanceBox;

	@FXML
	private BorderPane userPagePane;

	@FXML
    private ImageView profilePicture = new ImageView();
	
	@FXML
	private Label welcomeMessage = new Label();

	private static User curUser;
	
	@FXML
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		welcomeMessage.setText("Welcome to Tawe Lib, " + curUser.getUsername());
		Image image = new Image(curUser.getProfilePic());
		curUser.checkFineHistory();
		profilePicture.setImage(image);
		showCurrentBalanceBox.setText("Current Balance: " + Double.toString(curUser.getBalance()));
	}

	@FXML
	private void clickOnBrowseAndSearch(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BrowseAndSearchPage.fxml"));

			BorderPane browseAndSearch = (BorderPane) fxmlLoader.load();

			Scene browseAndSearchScene = new Scene(browseAndSearch, Main.BROWSEANDSEARCHPAGE_WIDTH,
					Main.BROWSEANDSEARCHPAGE_HEIGHT);
			Stage browseAndSearchStage = new Stage();

			browseAndSearchStage.setScene(browseAndSearchScene);
			browseAndSearchStage.setTitle(Main.BROWSEANDSEARCHPAGE_TITLE);
			browseAndSearchStage.initModality(Modality.APPLICATION_MODAL);
			browseAndSearchStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnNotification(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MessagePage.fxml"));

			BorderPane message = (BorderPane) fxmlLoader.load();

			Scene messageScene = new Scene(message, Main.MESSAGEPAGE_WIDTH, Main.MESSAGEPAGE_HEIGHT);
			Stage messageStage = new Stage();

			messageStage.setScene(messageScene);
			messageStage.setTitle(Main.MESSAGEPAGE_TITLE);
			messageStage.initModality(Modality.APPLICATION_MODAL);
			messageStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);

		}
	}

	@FXML
	private void clickOnFinePayment(ActionEvent event) { // Show the current balance of the user
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserFinePaymentPage.fxml"));

			BorderPane userFinePayment = (BorderPane) fxmlLoader.load();

			Scene userFinePaymentScene = new Scene(userFinePayment, Main.USER_FINEPAYMENTPAGE_WIDTH,
					Main.USER_FINEPAYMENTPAGE_HEIGHT);
			Stage userFinePaymentStage = new Stage();

			userFinePaymentStage.setScene(userFinePaymentScene);
			userFinePaymentStage.setTitle(Main.USER_FINEPAYMENTPAGE_TITLE);
			userFinePaymentStage.initModality(Modality.APPLICATION_MODAL);
			userFinePaymentStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnBorrowedItems(ActionEvent event) { // Jump to the BorrowedItems Page after the user click the
															// button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserBorrowedItemsPage.fxml"));

			BorderPane borrowedItems = (BorderPane) fxmlLoader.load();

			Scene borrowedItemsScene = new Scene(borrowedItems, Main.USER_BORROWEDITEMSPAGE_WIDTH,
					Main.USER_BORROWEDITEMSPAGE_HEIGHT);
			Stage userBorrowedItemsStage = new Stage();

			userBorrowedItemsStage.setScene(borrowedItemsScene);
			userBorrowedItemsStage.setTitle(Main.USER_BORROWEDITEMSPAGE_TITLE);
			userBorrowedItemsStage.initModality(Modality.APPLICATION_MODAL);
			userBorrowedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnRequestedItems(ActionEvent event) { // Jump to the Requested Items Page after the user click the
															// button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserRequestedItemsPage.fxml"));

			BorderPane requestedItems = (BorderPane) fxmlLoader.load();

			Scene requestedItemsScene = new Scene(requestedItems, Main.USER_REQUESTEDITEMSPAGE_WIDTH,
					Main.USER_REQUESTEDITEMSPAGE_HEIGHT);
			Stage userRequestedItemsStage = new Stage();

			userRequestedItemsStage.setScene(requestedItemsScene);
			userRequestedItemsStage.setTitle(Main.USER_REQUESTEDITEMSPAGE_TITLE);
			userRequestedItemsStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
			userRequestedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnReservedItems(ActionEvent event) { // Jump to the Reserved Items Page after the user click the
															// button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserReservedItemsPage.fxml"));

			BorderPane reservedItems = (BorderPane) fxmlLoader.load();

			Scene reservedItemsScene = new Scene(reservedItems, Main.USER_RESERVEDITEMSPAGE_WIDTH,
					Main.USER_RESERVEDITEMSPAGE_HEIGHT);
			Stage userReservedItemsStage = new Stage();

			userReservedItemsStage.setScene(reservedItemsScene);
			userReservedItemsStage.setTitle(Main.USER_RESERVEDITEMSPAGE_TITLE);
			userReservedItemsStage.initModality(Modality.APPLICATION_MODAL);
			userReservedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnTransactionHistory(ActionEvent event) { // Jump to the Transaction History Page after the user
																// click the button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TransactionHistoryPage.fxml"));

			BorderPane transactionHistory = (BorderPane) fxmlLoader.load();

			Scene transactionHistoryScene = new Scene(transactionHistory, Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage userTransactionHistoryStage = new Stage();

			userTransactionHistoryStage.setScene(transactionHistoryScene);
			userTransactionHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			userTransactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
			userTransactionHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnChooseAvatar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseAvatarPage.fxml"));

			BorderPane chooseAvatar = (BorderPane) fxmlLoader.load();

			Scene chooseAvatarScene = new Scene(chooseAvatar, Main.CHOOSEAVATARPAGE_WIDTH,
					Main.CHOOSEAVATARPAGE_HEIGHT);
			Stage chooseAvatarStage = new Stage();

			chooseAvatarStage.setScene(chooseAvatarScene);
			chooseAvatarStage.setTitle(Main.CHOOSEAVATARPAGE_TITLE);
			chooseAvatarStage.initModality(Modality.APPLICATION_MODAL);
			chooseAvatarStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnProfile(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserProfilePage.fxml"));

			BorderPane profileInfo = (BorderPane) fxmlLoader.load();

			Scene profileInfoScene = new Scene(profileInfo, Main.CHOOSEAVATARPAGE_WIDTH, Main.CHOOSEAVATARPAGE_HEIGHT);
			Stage profileInfoStage = new Stage();

			profileInfoStage.setScene(profileInfoScene);
			profileInfoStage.setTitle(Main.CHOOSEPROFILEPAGE_TITLE);
			profileInfoStage.initModality(Modality.APPLICATION_MODAL);
			profileInfoStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	private void clickOnLogOut(ActionEvent event) {
		closeWindow();
		Database.saveData();
	}

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) userPagePane.getScene().getWindow();
		stage.close();
	}
	
}