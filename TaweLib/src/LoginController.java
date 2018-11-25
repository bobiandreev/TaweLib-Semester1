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
	
	@FXML
    public BorderPane homePagePane;

	@FXML
	private TextField username1; // Username of Users
	
	@FXML
	private TextField username2; // Username of Librarian
	
	@FXML
	private TextField browseAndSearch;
	
	@FXML
	private TreeView<?> treeView; // Something to show on the Home Page
	
	Alert alert = new Alert(AlertType.ERROR);
	
	@FXML
	private void clickOnLoginAsUser(ActionEvent event) {
		String x = username1.getText();
		if (x.isEmpty() ) { // The case if the user left username field blank
			alert.setHeaderText(null);
			alert.setContentText("Please fill in Username!");
			alert.showAndWait();
		} else { // The case when the user fill in their username correctly
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserPage.fxml"));
				
				BorderPane userPage = (BorderPane) fxmlLoader.load();
				
				Scene userScene = new Scene(userPage, Main.USER_PAGE_WIDTH, Main.USER_PAGE_HEIGHT);
				Stage userStage = new Stage();
				
				userStage.setScene(userScene);
				userStage.setTitle(Main.USER_PAGE_TITLE);
				userStage.initModality(Modality.APPLICATION_MODAL);
				userStage.showAndWait();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
				}	
			}
	}
	
	@FXML
	private void clickOnLoginAsLibrarian(ActionEvent event) {
		String m = username2.getText();
		if (m.isEmpty()) { // The case if the librarian left username field blank
			alert.setHeaderText(null);
			alert.setContentText("Please fill in Username!");
			alert.showAndWait();
		} else { // The case when the librarian fill in their username correctly
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrarianPage.fxml"));
				
				BorderPane librarianPage = (BorderPane) fxmlLoader.load();
				
				Scene librarianScene = new Scene(librarianPage, Main.LIBRARIAN_PAGE_WIDTH, Main.LIBRARIAN_PAGE_HEIGHT);
				Stage librarianStage = new Stage();
				
				librarianStage.setScene(librarianScene);
				librarianStage.setTitle(Main.LIBRARIAN_PAGE_TITLE);
				librarianStage.initModality(Modality.APPLICATION_MODAL);
				librarianStage.showAndWait();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
				}
		}
	}
	
	@FXML
	public void clickOnBrowseAndSearch(ActionEvent event) {	
		String s = browseAndSearch.getText();
		System.out.println(s);
	}
	
}
