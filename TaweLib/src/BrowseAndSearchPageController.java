import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The BrowseAndSearchPageController Class which controls the BrowseAndSearchPage.fxml
 * @author Ming
 *
 */
public class BrowseAndSearchPageController {

    @FXML
    private BorderPane browseAndSearchPane;

    @FXML
    private TextField searchItem;
    
    @FXML
    private CheckBox bookCheckBox;

    @FXML
    private CheckBox DVDCheckBox;

    @FXML
    private CheckBox laptopCheckBox;

    @FXML
    private ListView<String> browseAndSearchList;
    
    Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private void clickOnSearch(ActionEvent event) {

    }
    
	public void initialize() {
		// Setup the me
		bookCheckBox.setOnAction(e -> {
			handleBookCheckBoxAction();
		});
		
		DVDCheckBox.setOnAction(e -> {
			handleDVDCheckBoxAction();
		});
		
		laptopCheckBox.setOnAction(e -> {
			handleLaptopCheckBoxAction();
		});

	}
	
    private void handleBookCheckBoxAction() {

    }
    
    private void handleDVDCheckBoxAction() {

    	
   	}
    
    private void handleLaptopCheckBoxAction() {

    	
   	}
    
    @FXML
    private void clickOnCheckForCopies(ActionEvent event) {
    	//if numberOfCopies > 0 
    	//alert.setHeaderText("Copies Available");
		//alert.setContentText("There are /*+ numberOfCopies +*/ available.");
		//alert.showAndWait();
		//if numberOfCopies = 0 
		//alert.setHeaderText("Copies Unavailable");
		//alert.setContentText("There are no copy available.");
		//alert.showAndWait();
    }

    @FXML
    private void clickOnBack(ActionEvent event) {
    	closeWindow();
    }
        
    private void closeWindow() { // A method which close the window
 		Stage stage = (Stage) browseAndSearchPane.getScene().getWindow();
 	    stage.close();
 	}
}
