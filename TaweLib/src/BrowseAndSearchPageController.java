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

    @FXML private BorderPane browseAndSearchPane;

    @FXML private TextField searchItem;
    
    @FXML private CheckBox bookCheckBox;

    @FXML private CheckBox DVDCheckBox;

    @FXML private CheckBox laptopCheckBox;

    @FXML private ListView<String> browseAndSearchList;
    
    Alert alert = new Alert(AlertType.INFORMATION);
    
    /**
	 * Actions will be made when the user click on the button
	 * @param event
	 */
    @FXML private void clickOnSearch(ActionEvent event) {
    	
    }
    
    /**
	 * Initialize the controller.
	 * The following happen in this order:
	 * 1) First an instance of the controller is created (the constructor is called),
	 * 2) Next the @FXML variables are bound to the GUI components.
	 * 3) Finally, this initialize method is called.
	 */
	public void initialize() {
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
	
	/**
	 * Handle the Book Check Box.
	 * Searching filter of resources.
	 */
    private void handleBookCheckBoxAction() {

    }
    
	/**
	 * Handle the DVD Check Box.
	 * Searching filter of resources.
	 */
    private void handleDVDCheckBoxAction() {

    	
   	}
    
	/**
	 * Handle the Laptop Check Box.
	 * Searching filter of resources.
	 */
    private void handleLaptopCheckBoxAction() {

    	
   	}
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnCheckForCopies(ActionEvent event) {
    	//if numberOfCopies > 0 
    	//alert.setHeaderText("Copies Available");
		//alert.setContentText("There are /*+ numberOfCopies +*/ available.");
		//alert.showAndWait();
		//if numberOfCopies = 0 
		//alert.setHeaderText("Copies Unavailable");
		//alert.setContentText("There are no copy available.");
		//alert.showAndWait();
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
    @FXML private void closeWindow() {
 		Stage stage = (Stage) browseAndSearchPane.getScene().getWindow();
 	    stage.close();
 	}
}
