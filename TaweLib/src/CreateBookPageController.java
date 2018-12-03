import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
    private TextField itemID; // dont need

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
    
    // need to add genre
    // need to add number of copies

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void clickOnConfirm(ActionEvent event) {
    	String title = this.title.getText();
    	String author = this.author.getText();
    	String publisher = this.publisher.getText();
    	int year = Integer.parseInt(this.year.getText());
    	Book newBook = new Book(title, year, null, 5, author, publisher);
    	SearchBrowse.addResource(newBook);
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createBookPane.getScene().getWindow();
	    stage.close();
	}
    
}