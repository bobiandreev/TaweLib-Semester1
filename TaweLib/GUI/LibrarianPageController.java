import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The LibrarianPage Class which controls the LibrarianPage.fxml
 * @author Ming
 *
 */
public class LibrarianPageController {

    @FXML
    private BorderPane librarianPane;

    @FXML
    private void clickOnRecordOfUsers(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecordsOfUsersPage.fxml"));
			
    		BorderPane recordsOfUsers = (BorderPane) fxmlLoader.load();
			
    		Scene recordsOfUsersScene = new Scene(recordsOfUsers, Main.RECORDSOFUSERSPAGE_WIDTH, Main.RECORDSOFUSERSPAGE_HEIGHT);
    		Stage recordsOfUsersSceneStage = new Stage();
			
    		recordsOfUsersSceneStage .setScene(recordsOfUsersScene);
    		recordsOfUsersSceneStage .setTitle(Main.RECORDSOFUSERSPAGE_TITLE);
    		recordsOfUsersSceneStage .initModality(Modality.APPLICATION_MODAL);
    		recordsOfUsersSceneStage .showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }

    @FXML
    void clickOnLogOut(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) librarianPane.getScene().getWindow();
	    stage.close();
	}

}
