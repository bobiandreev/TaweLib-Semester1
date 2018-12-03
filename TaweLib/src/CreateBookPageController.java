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
    private TextField numberOfCopies;
    
    @FXML
    private TextField genre;
    
    @FXML
    private TextField language;
    
    @FXML
    private TextField ISBN;

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	String title = this.title.getText();
    	int year = Integer.parseInt(this.year.getText());
    	String author = this.author.getText();
    	String publisher = this.publisher.getText();
    	int numberOfCopies = Integer.parseInt(this.numberOfCopies.getText());
    	String genre = this.genre.getText();
    	String language = this.language.getText();
    	String ISBN = this.ISBN.getText();
    	Book newBook = new Book (title, year, null, numberOfCopies, author, publisher);
    	newBook.setGenre(genre);
    	newBook.setISBN(ISBN);
    	newBook.setLanguage(language);
    	System.out.println(newBook.toString());
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createBookPane.getScene().getWindow();
	    stage.close();
	}
    
}