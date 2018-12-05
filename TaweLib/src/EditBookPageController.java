import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The EditBookPageController Class which controls the EditBookPage.fxml
 * 
 * @author Ming
 *
 */
public class EditBookPageController {

	@FXML
    private BorderPane editBookPane;
	
	@FXML
	private TextField title;

	@FXML
	private TextField year;

	@FXML
	private Button thumbnailImage;

	@FXML
	private TextField author;

	@FXML
	private TextField publisher;

	@FXML
	private TextField numberOfCopies;

	@FXML
	private TextField genre;

	@FXML
	private TextField language;

	@FXML
	private TextField ISBN;

	private Book bookToEdit;

	@FXML
	private void initialize() {
		bookToEdit = (Book) BrowseAndSearchPageController.getResourceToEdit();
		this.title.setText(bookToEdit.getTitle());
		this.year.setText(bookToEdit.getYear());
		this.author.setText(bookToEdit.getAuthor());
		this.publisher.setText(bookToEdit.getPublisher());
		this.numberOfCopies.setText(Integer.toString(bookToEdit.getNumOfCopies()));
		this.title.setText(bookToEdit.getTitle());
		if (bookToEdit.getGenre() != null) {
			this.genre.setText(bookToEdit.getGenre());
		}
		if (bookToEdit.getISBN() != null) {
			this.ISBN.setText(bookToEdit.getISBN());
		}
		if (bookToEdit.getLanguage() != null) {
			this.language.setText(bookToEdit.getLanguage());
		}
	}

	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String author = this.author.getText();
		String publisher = this.publisher.getText();
		int numberOfCopies = Integer.parseInt(this.numberOfCopies.getText());
		String genre = this.genre.getText();
		String language = this.language.getText();
		String ISBN = this.ISBN.getText();
		String image = this.image;
		Book newBook = new Book(title, year, image, numberOfCopies, author, publisher);
		newBook.setGenre(genre);
		newBook.setISBN(ISBN);
		newBook.setLanguage(language);
		SearchBrowse.getResources().add(newBook);
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
		Stage stage = (Stage) editBookPane.getScene().getWindow();
		stage.close();
	}
}
