import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The ChooseEditTypePageController Class which controls the
 * ChooseEditTypePage.fxml
 * 
 * @author Ming
 * @version 1.0
 *
 */
public class ChooseEditTypePageController {

    @FXML
    private BorderPane chooseEditTypePane;

    /**
     * Method to close the window by clicking the back button.
     * 
     * @param event Mouse click on back button.
     */
    @FXML
    private void clickOnBack(ActionEvent event) {
	closeWindow();
    }

    /**
     * Method that shows the attributes of book needed or not for the item's
     * creation.
     * 
     * @param event Mouse click on Book button.
     */
    @FXML
    private void clickOnBook(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditBookPage.fxml"));

	    BorderPane editBook = (BorderPane) fxmlLoader.load();

	    Scene editBookScene = new Scene(editBook, Main.EDITBOOKPAGE_WIDTH,
		    Main.EDITBOOKPAGE_HEIGHT);
	    Stage editBookStage = new Stage();

	    editBookStage.setScene(editBookScene);
	    editBookStage.setTitle(Main.EDITBOOKPAGE_TITLE);
	    editBookStage.initModality(Modality.APPLICATION_MODAL);
	    editBookStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method that shows the attributes of dvd needed or not for the item's
     * creation.
     * 
     * @param event Mouse click on DVD button.
     */
    @FXML
    private void clickOnDVD(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditDVDPage.fxml"));

	    BorderPane editDVD = (BorderPane) fxmlLoader.load();

	    Scene editDVDScene = new Scene(editDVD, Main.EDITDVDPAGE_WIDTH,
		    Main.EDITDVDPAGE_HEIGHT);
	    Stage editDVDStage = new Stage();

	    editDVDStage.setScene(editDVDScene);
	    editDVDStage.setTitle(Main.EDITDVDPAGE_TITLE);
	    editDVDStage.initModality(Modality.APPLICATION_MODAL);
	    editDVDStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method that shows the attributes of laptopcomputer needed for the item's
     * creation.
     * 
     * @param event Mouse click on DVD button.
     */
    @FXML
    private void clickOnLaptop(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditLaptopPage.fxml"));

	    BorderPane editDVD = (BorderPane) fxmlLoader.load();

	    Scene editLaptopScene = new Scene(editDVD,
		    Main.EDITLAPTOPPAGE_WIDTH, Main.EDITLAPTOPPAGE_HEIGHT);
	    Stage editLaptopStage = new Stage();

	    editLaptopStage.setScene(editLaptopScene);
	    editLaptopStage.setTitle(Main.EDITLAPTOPPAGE_TITLE);
	    editLaptopStage.initModality(Modality.APPLICATION_MODAL);
	    editLaptopStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to close the window.
     */
    @FXML
    private void closeWindow() { // A method which close the window
	Stage stage = (Stage) chooseEditTypePane.getScene().getWindow();
	stage.close();
    }
}