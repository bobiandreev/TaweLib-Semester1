import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * The LoginController Class which controls the HomePage.fxml 
 * @author Ming
 *
 */
public class LoginController {

	@FXML public BorderPane homePagePane;

	@FXML private TextField userID; // Username of Users

<<<<<<< HEAD
	@FXML
	private TextField librarianID; // Username of Librarian
	private static User loggedUser;
=======
	@FXML private TextField librarianID; // Username of Librarian

>>>>>>> branch 'master' of https://gitlab.com/ONixon/group-41.git
	Alert alert = new Alert(AlertType.ERROR);

<<<<<<< HEAD
	
	
	
	public static User getLoggedUser() {
		return loggedUser;
	}

	@FXML
	private void clickOnLoginAsUser(ActionEvent event) {
=======
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
	@FXML private void clickOnLoginAsUser(ActionEvent event) {
>>>>>>> branch 'master' of https://gitlab.com/ONixon/group-41.git
		String x = userID.getText();
		if (x.isEmpty()) { // The case if the user left userID field blank
			alert.setHeaderText(null);
			alert.setContentText("Please fill in UserID!");
			alert.showAndWait();
		} else { // The case when the user fill in their userID correctly
			for (int i = 0; i < Librarian.getUsersList().size(); i++) {
				if (x.equals(Librarian.getUsersList().get(i).getUsername().toString())) {
					loggedUser = Librarian.getUsersList().get(i);
					try {
						// Create a FXML loader for loading the Edit Country FXML file.
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPage.fxml"));
						// Run the loader
						BorderPane userPage = (BorderPane) fxmlLoader.load();
						// Create a scene based on the loaded FXML scene graph
						Scene userScene = new Scene(userPage, Main.USER_PAGE_WIDTH, Main.USER_PAGE_HEIGHT);
						// Create a new stage (i.e., window) based on the edit scene
						Stage userStage = new Stage();
						userStage.setScene(userScene);
						userStage.setTitle(Main.USER_PAGE_TITLE);
						// Make the stage a modal window.
						// This means that it must be closed before you can interact with any other window from this application.
						userStage.initModality(Modality.APPLICATION_MODAL);
						// Show the edit scene and wait for it to be closed
						userStage.showAndWait();
					} catch (IOException e) {
						e.printStackTrace();
						// Quit the program (with an error code)
						System.exit(-1);
					}
				} else {
					alert.setHeaderText("No such user!");
					alert.setContentText("Wrong username or no such user exists!");
					alert.showAndWait();
				}
			}
		}
	}
	
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
	@FXML private void clickOnLoginAsLibrarian(ActionEvent event) {
		String m = librarianID.getText();
		if (m.isEmpty()) { // The case if the librarian left LibrarianID field blank
			alert.setHeaderText(null);
			alert.setContentText("Please fill in LibrarianID!");
			alert.showAndWait();
		} else { // The case when the librarian fill in their LibrarianID correctly
			for (int i = 0; i < Librarian.getLibrarianList().size(); i++) {
				if (m.equals(Librarian.getLibrarianList().get(i).getUsername().toString())) {
					try {
						// Create a FXML loader for loading the Edit Country FXML file.
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrarianPage.fxml"));
						// Run the loader
						BorderPane librarianPage = (BorderPane) fxmlLoader.load();
						// Create a scene based on the loaded FXML scene graph
						Scene librarianScene = new Scene(librarianPage, Main.LIBRARIAN_PAGE_WIDTH,Main.LIBRARIAN_PAGE_HEIGHT);
						// Create a new stage (i.e., window) based on the edit scene
						Stage librarianStage = new Stage();
						librarianStage.setScene(librarianScene);
						librarianStage.setTitle(Main.LIBRARIAN_PAGE_TITLE);
						// Make the stage a modal window.
						// This means that it must be closed before you can interact with any other window from this application.
						librarianStage.initModality(Modality.APPLICATION_MODAL);
						// Show the edit scene and wait for it to be closed
						librarianStage.showAndWait();
					} catch (IOException e) {
						e.printStackTrace();
						// Quit the program (with an error code)
						System.exit(-1);
					}
				} else {
					alert.setHeaderText("No such librarian!");
					alert.setContentText("Wrong username or no such librarian exists!");
					alert.showAndWait();
				}
			}
		}
	}
}