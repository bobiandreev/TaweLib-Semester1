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

    @FXML private BorderPane viewResourcesPane;

    @FXML private ListView<String> viewResourcesList;

    /**
   	 * Initialize the controller.
   	 * The following happen in this order:
   	 * 1) First an instance of the controller is created (the constructor is called),
   	 * 2) Next the @FXML variables are bound to the GUI components.
   	 * 3) Finally, this initialize method is called.
   	 */
    public void initialize() {

	}
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */ 
    @FXML private void clickOnEdit(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseEditTypePage.fxml"));
    		// Run the loader
    		BorderPane chooseEditType = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene chooseEditTypeScene = new Scene(chooseEditType, Main.CHOOSEEDITTYPEPAGE_WIDTH, Main.CHOOSEEDITTYPEPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage chooseEditTypeStage = new Stage();			
    		chooseEditTypeStage.setScene(chooseEditTypeScene);
    		chooseEditTypeStage.setTitle(Main.CHOOSEEDITTYPEPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		chooseEditTypeStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		chooseEditTypeStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */ 
    @FXML private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    /**
   	 * Close the window.
   	 */
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) viewResourcesPane.getScene().getWindow();
	    stage.close();
	}
    
}
