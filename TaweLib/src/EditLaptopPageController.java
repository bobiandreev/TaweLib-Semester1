import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The EditLaptopPageController Class which controls the EditLaptopPage.fxml
 * @author Ming
 *
 */
public class EditLaptopPageController {

	@FXML
    private Button newImage;

    @FXML
    private BorderPane editLaptopPane;

    @FXML
    private TextField year;

    @FXML
    private TextField numOfCopies;

    @FXML
    private TextField model;

    @FXML
    private TextField title;

    @FXML
    private ImageView thumbnailImage;

    @FXML
    private TextField operatingSystem;

    @FXML
    private TextField manufacturer;

    private String path;
    private LaptopComputer laptopToEdit;
    
    @FXML
	private void initialize() {
		laptopToEdit = (LaptopComputer) BrowseAndSearchPageController.getResourceToEdit();
		path = laptopToEdit.getThumbnailImage();
		this.title.setText(laptopToEdit.getTitle());
		this.year.setText(laptopToEdit.getYear());
		this.manufacturer.setText(laptopToEdit.getManufacturer());
		this.model.setText(laptopToEdit.getModel());
		this.operatingSystem.setText(laptopToEdit.getOS());
		this.numOfCopies.setText(Integer.toString(laptopToEdit.getNumOfCopies()));
		this.thumbnailImage.setImage(new Image(laptopToEdit.getThumbnailImage()));
	}
    
    @FXML
    void clickOnNewImage(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	File selectedFile = fc.showOpenDialog(null);
    	path = selectedFile.toURI().toString();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	String title = this.title.getText();
		String year = this.year.getText();
		String manufacturer = this.manufacturer.getText();
		String model = this.model.getText();
		String OS = this.operatingSystem.getText();
		try {
			int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
			if (numberOfCopies > laptopToEdit.getNumOfCopies()) {
				laptopToEdit.addCopies(numberOfCopies);
			}
			else {
				laptopToEdit.removeCopies(laptopToEdit.getNumOfCopies() - numberOfCopies);
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Please enter a valid number!");
			alert.setContentText("No valid enter has been entered!");
			alert.showAndWait();
		}
		String image = this.path;
		laptopToEdit.setTitle(title);
		laptopToEdit.setYear(year);
		laptopToEdit.setManufacturer(manufacturer);
		laptopToEdit.setModel(model);
		// laptopToEdit.setNumOfCopies();
		laptopToEdit.setOS(OS);
		laptopToEdit.setThumbnailImage(image);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText("This book has been added to the catalogue successfully!");
    }
    
    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editLaptopPane.getScene().getWindow();
	    stage.close();
	}
}
