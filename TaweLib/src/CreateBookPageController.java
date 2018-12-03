import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The CreateBookPageController Class which controls the CreateBookPage.fxml
 * @author Ming
 *
 */
public class CreateBookPageController {

    @FXML
    private BorderPane createBookPane;

    @FXML
    private TextField itemID;

    @FXML
    private TextField title;

    @FXML
    private TextField year;

    @FXML
    private TextField thumbnailImage;

    @FXML
    private TextField author;

    @FXML
    private TextField publisher;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateBookPage.fxml"));
			
    		BorderPane createBook = (BorderPane) fxmlLoader.load();
			
    		Scene createBookScene = new Scene(createBook, Main.CREATEBOOKPAGE_WIDTH, Main.CREATEBOOKPAGE_HEIGHT);
    		Stage createBookStage = new Stage();
			
    		createBookStage.setScene(createBookScene);
    		createBookStage.setTitle(Main.CREATEBOOKPAGE_TITLE);
    		createBookStage.initModality(Modality.APPLICATION_MODAL);
    		createBookStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createBookPane.getScene().getWindow();
	    stage.close();
	}
    
}