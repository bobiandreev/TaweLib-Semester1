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
 * <h1>Login Controller for GUI.</h1> The LoginController Class which controls
 * the HomePage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-03
 *
 */
public class LoginController {

    @FXML
    public BorderPane homePagePane;

    @FXML
    private TextField userID; // Username of Users

    @FXML
    private TextField librarianID; // Username of Librarian
    private static User loggedUser;
    Alert alert = new Alert(AlertType.ERROR);

    /**
     * Getter method which gets the logged-in users.
     * 
     * @return loggedUser A logged-in user of the system.
     */
    public static User getLoggedUser() {
	return loggedUser;
    }

    /**
     * Actions will be carried out when button is clicked to log in as a User.
     * Actions carried out depends on whether UserID was appropriately entered.
     * Inappropriate or unexpected input will trigger messages to be displayed
     * in an alert box.
     * 
     * @param event - When the mouse clicks on the button.
     */
    @FXML
    private void clickOnLoginAsUser(ActionEvent event) {
	String x = userID.getText();
	if (x.isEmpty()) { // The case if the user left userID field blank
	    alert.setHeaderText(null);
	    alert.setContentText("Please fill in UserID!");
	    alert.showAndWait();
	} else { // The case when the user fill in their userID correctly
	    boolean exists = true;

	    for (int i = 0; i < Librarian.getUsersList().size(); i++) {
		if (x.equals(Librarian.getUsersList().get(i).getUsername()
			.toString())) {
		    loggedUser = Librarian.getUsersList().get(i);
		    exists = false;
		}
	    }
	    if (!exists) {
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(
			    getClass().getResource("UserPage.fxml"));

		    BorderPane userPage = (BorderPane) fxmlLoader.load();

		    Scene userScene = new Scene(userPage, Main.USER_PAGE_WIDTH,
			    Main.USER_PAGE_HEIGHT);
		    Stage userStage = new Stage();

		    userStage.setScene(userScene);
		    userStage.setTitle(Main.USER_PAGE_TITLE);
		    userStage.initModality(Modality.APPLICATION_MODAL);
		    userStage.showAndWait();
		} catch (IOException e) {
		    e.printStackTrace();
		    System.exit(-1);
		}
	    } else {
		alert.setHeaderText("No such user!");
		alert.setContentText("Wrong username or no such user exists!");
		alert.showAndWait();
	    }
	}
    }

    /**
     * Actions will be carried out when button is clicked to log in as a
     * Librarian. Actions carried out depends on whether librarianID was
     * appropriately entered. Inappropriate or unexpected input will trigger
     * messages to be displayed in an alert box.
     * 
     * @param event - When the mouse clicks on the button.
     */
    @FXML
    private void clickOnLoginAsLibrarian(ActionEvent event) {
	String m = librarianID.getText();
	if (m.isEmpty()) { // The case if the librarian left LibrarianID field
			   // blank
	    alert.setHeaderText(null);
	    alert.setContentText("Please fill in LibrarianID!");
	    alert.showAndWait();
	} else { // The case when the librarian fill in their LibrarianID
		 // correctly
	    boolean exists = true;
	    for (int i = 0; i < Librarian.getLibrarianList().size(); i++) {
		if (m.equals(
			Librarian.getLibrarianList().get(i).getUsername())) {
		    loggedUser = Librarian.getLibrarianList().get(i);
		    exists = false;
		}
	    }
	    if (!exists) {
		try {
		    FXMLLoader fxmlLoader = new FXMLLoader(
			    getClass().getResource("LibrarianPage.fxml"));

		    BorderPane librarianPage = (BorderPane) fxmlLoader.load();

		    Scene librarianScene = new Scene(librarianPage,
			    Main.LIBRARIAN_PAGE_WIDTH,
			    Main.LIBRARIAN_PAGE_HEIGHT);
		    Stage librarianStage = new Stage();

		    librarianStage.setScene(librarianScene);
		    librarianStage.setTitle(Main.LIBRARIAN_PAGE_TITLE);
		    librarianStage.initModality(Modality.APPLICATION_MODAL);
		    librarianStage.showAndWait();
		} catch (IOException e) {
		    e.printStackTrace();
		    System.exit(-1);
		}
	    } else {
		alert.setHeaderText("No such librarian!");
		alert.setContentText(
			"Wrong username or no such librarian exists!");
		alert.showAndWait();
	    }
	}
    }
}