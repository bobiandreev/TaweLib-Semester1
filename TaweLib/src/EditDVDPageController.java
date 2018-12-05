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
 * The EditDVDPageController Class which controls the EditDVDPage.fxml
 * 
 * @author Ming
 *
 */
public class EditDVDPageController {

	@FXML
	private Button newImage;

	@FXML
	private BorderPane editDVDPane;

	@FXML
	private TextField year;

	@FXML
	private TextField numOfCopies;

	@FXML
	private TextField director;

	@FXML
	private TextField runtime;

	@FXML
	private TextField language;

	@FXML
	private TextField title;

	@FXML
	private ImageView thumbnailImage;

	@FXML
	private TextField availavleSubtitles;

	private DVD dvdToEdit;
	private String path;

	@FXML
	private void initialize() {
		dvdToEdit = (DVD) BrowseAndSearchPageController.getResourceToEdit();
		this.title.setText(dvdToEdit.getTitle());
		this.year.setText(dvdToEdit.getYear());
		this.runtime.setText(dvdToEdit.getRuntime());
		this.director.setText(dvdToEdit.getDirector());
		this.numOfCopies.setText(Integer.toString(dvdToEdit.getNumOfCopies()));
		this.title.setText(dvdToEdit.getTitle());
		if (dvdToEdit.getLanguage() != null) {
			this.language.setText(dvdToEdit.getLanguage());
		}
		else {
			this.language.setText("");
		}
		if (dvdToEdit.getSubtitles() != null) {
			this.availavleSubtitles.setText(dvdToEdit.getSubtitles());
		}
		else {
			this.language.setText("");
		}
		this.thumbnailImage.setImage(new Image(dvdToEdit.getThumbnailImage()));
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
		String runtime = this.runtime.getText();
		String director = this.director.getText();
		int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
		String language = this.language.getText();
		String image = this.path;
		dvdToEdit.setTitle(title);
		dvdToEdit.setYear(year);
		dvdToEdit.setDirector(director);
		dvdToEdit.setRuntime(runtime);
		// dvdToEdit.setNumOfCopies();
		dvdToEdit.setLanguage(language);
		dvdToEdit.setThumbnailImage(image);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText("This book has been added to the catalogue successfully!");
		alert.showAndWait();
	}

	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editDVDPane.getScene().getWindow();
		stage.close();
	}
}
