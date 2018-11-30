import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The ViewResourcesPageController Class which controls the ViewResourcesPage.fxml
 * @author Ming
 *
 */
public class ViewResourcesPageController {

    @FXML
    private BorderPane viewResourcesPane;

    @FXML
    private ListView<?> viewResourcesList;

    @FXML
    private void clickOnEdit(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseEditTypePage.fxml"));
			
    		BorderPane chooseEditType = (BorderPane) fxmlLoader.load();
			
    		Scene chooseEditTypeScene = new Scene(chooseEditType, Main.CHOOSEEDITTYPEPAGE_WIDTH, Main.CHOOSEEDITTYPEPAGE_HEIGHT);
    		Stage chooseEditTypeStage = new Stage();
			
    		chooseEditTypeStage.setScene(chooseEditTypeScene);
    		chooseEditTypeStage.setTitle(Main.CHOOSEEDITTYPEPAGE_TITLE);
    		chooseEditTypeStage.initModality(Modality.APPLICATION_MODAL);
    		chooseEditTypeStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) viewResourcesPane.getScene().getWindow();
	    stage.close();
	}
    
}
