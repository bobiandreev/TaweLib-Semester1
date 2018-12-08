import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1> Choose/Create Type and Page (GUI). </h1>
 * The ChooseCreateTypePageController Class which controls the ChooseCreateTypePage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-05
 *
 */
public class ChooseCreateTypePageController {

    @FXML
    private BorderPane chooseCreateTypePane;

    /**
     * Appropriate actions will be carried out when button is clicked. The creation of a 
     * new book resource will occur.
     * 
     * @param event
     */
    @FXML
    private void clickOnBook(ActionEvent event) {
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
    
    /**
     * Appropriate actions will be carried out when button is clicked. The creation of a
     * new DVD resource will occur.
     * 
     * @param event
     */
    @FXML
    private void clickOnDVD(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateDVDPage.fxml"));
			
    		BorderPane createDVD = (BorderPane) fxmlLoader.load();
			
    		Scene createDVDScene = new Scene(createDVD, Main.CREATEDVDPAGE_WIDTH, Main.CREATEDVDPAGE_HEIGHT);
    		Stage createDVDStage = new Stage();
			
    		createDVDStage.setScene(createDVDScene);
    		createDVDStage.setTitle(Main.CREATEDVDPAGE_TITLE);
    		createDVDStage.initModality(Modality.APPLICATION_MODAL);
    		createDVDStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }

    /**
     * Appropriate actions will be carried out when button is clicked. The creation of a
     * new Laptop resource will occur.
     * 
     * @param event
     */
    @FXML
    private void clickOnLaptop(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateLaptopPage.fxml"));
			
    		BorderPane createLaptop = (BorderPane) fxmlLoader.load();
			
    		Scene createLaptopScene = new Scene(createLaptop, Main.CREATELAPTOPPAGE_WIDTH, Main.CREATELAPTOPPAGE_HEIGHT);
    		Stage createLaptopStage = new Stage();
			
    		createLaptopStage.setScene(createLaptopScene);
    		createLaptopStage.setTitle(Main.CREATELAPTOPPAGE_TITLE);
    		createLaptopStage.initModality(Modality.APPLICATION_MODAL);
    		createLaptopStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    /**
	 * Actions will be made when the user clicks on the button.
	 * Returns to previous window by closing the current/most recent one.
	 * 
	 * @param event
	 */
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    /**
     * This method closes the window.
     */
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) chooseCreateTypePane.getScene().getWindow();
	    stage.close();
	}
    
}
