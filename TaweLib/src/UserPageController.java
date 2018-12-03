 import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * The UserPageController Class which controls the UserPage.fxml
 * @author Ming
 *
 */
public class UserPageController {
	
	@FXML private Label showCurrentBalanceBox;	
	
    @FXML private BorderPane userPagePane;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */  
    @FXML private void clickOnBrowseAndSearch(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BrowseAndSearchPage.fxml"));
    		// Run the loader
    		BorderPane browseAndSearch = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene browseAndSearchScene = new Scene(browseAndSearch, Main.BROWSEANDSEARCHPAGE_WIDTH, Main.BROWSEANDSEARCHPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage browseAndSearchStage = new Stage();			
    		browseAndSearchStage.setScene(browseAndSearchScene);
    		browseAndSearchStage.setTitle(Main.BROWSEANDSEARCHPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		browseAndSearchStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		browseAndSearchStage.showAndWait();
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
    @FXML private void clickOnNotification(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MessagePage.fxml"));
    	// Run the loader
		BorderPane message = (BorderPane) fxmlLoader.load();
		// Create a scene based on the loaded FXML scene graph
		Scene messageScene = new Scene(message, Main.MESSAGEPAGE_WIDTH, Main.MESSAGEPAGE_HEIGHT);
		// Create a new stage (i.e., window) based on the edit scene
		Stage messageStage = new Stage();		
		messageStage.setScene(messageScene);
		messageStage.setTitle(Main.MESSAGEPAGE_TITLE);
		// Make the stage a modal window.
		// This means that it must be closed before you can interact with any other window from this application.
		messageStage.initModality(Modality.APPLICATION_MODAL);
		// Show the edit scene and wait for it to be closed
		messageStage.showAndWait();
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
    @FXML private void clickOnFinePayment(ActionEvent event) { // Show the current balance of the user
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserFinePaymentPage.fxml"));
    		// Run the loader
    		BorderPane userFinePayment = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene userFinePaymentScene = new Scene(userFinePayment, Main.USER_FINEPAYMENTPAGE_WIDTH, Main.USER_FINEPAYMENTPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userFinePaymentStage = new Stage();			
    		userFinePaymentStage.setScene(userFinePaymentScene);
    		userFinePaymentStage.setTitle(Main.USER_FINEPAYMENTPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userFinePaymentStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userFinePaymentStage.showAndWait();
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
    @FXML private void clickOnBorrowedItems(ActionEvent event) { // Jump to the BorrowedItems Page after the user click the button 
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserBorrowedItemsPage.fxml"));
    		// Run the loader
    		BorderPane borrowedItems = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene borrowedItemsScene = new Scene(borrowedItems, Main.USER_BORROWEDITEMSPAGE_WIDTH, Main.USER_BORROWEDITEMSPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userBorrowedItemsStage = new Stage();		
    		userBorrowedItemsStage.setScene(borrowedItemsScene);
    		userBorrowedItemsStage.setTitle(Main.USER_BORROWEDITEMSPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userBorrowedItemsStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userBorrowedItemsStage.showAndWait();
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
    @FXML private void clickOnRequestedItems(ActionEvent event) { // Jump to the Requested Items Page after the user click the button 
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserRequestedItemsPage.fxml"));
    		// Run the loader
    		BorderPane requestedItems = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene requestedItemsScene = new Scene(requestedItems, Main.USER_REQUESTEDITEMSPAGE_WIDTH, Main.USER_REQUESTEDITEMSPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userRequestedItemsStage = new Stage();		
    		userRequestedItemsStage.setScene(requestedItemsScene);
    		userRequestedItemsStage.setTitle(Main.USER_REQUESTEDITEMSPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userRequestedItemsStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		userRequestedItemsStage.showAndWait();
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
    @FXML private void clickOnReservedItems(ActionEvent event) { // Jump to the Reserved Items Page after the user click the button 
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserReservedItemsPage.fxml"));
    		// Run the loader
    		BorderPane reservedItems = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene reservedItemsScene = new Scene(reservedItems, Main.USER_RESERVEDITEMSPAGE_WIDTH, Main.USER_RESERVEDITEMSPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userReservedItemsStage = new Stage();		
    		userReservedItemsStage.setScene(reservedItemsScene);
    		userReservedItemsStage.setTitle(Main.USER_RESERVEDITEMSPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userReservedItemsStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userReservedItemsStage.showAndWait();
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
    @FXML private void clickOnTransactionHistory(ActionEvent event) { // Jump to the Transaction History Page after the user click the button 
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TransactionHistoryPage.fxml"));
    		// Run the loader
    		BorderPane transactionHistory = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene transactionHistoryScene = new Scene(transactionHistory, Main.TRANSACTIONHISTORYPAGE_WIDTH, Main.TRANSACTIONHISTORYPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userTransactionHistoryStage = new Stage();		
    		userTransactionHistoryStage.setScene(transactionHistoryScene);
    		userTransactionHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userTransactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userTransactionHistoryStage.showAndWait();
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
    @FXML private void clickOnChooseAvatar(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseAvatarPage.fxml"));
    		// Run the loader
    		BorderPane chooseAvatar = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene chooseAvatarScene = new Scene(chooseAvatar, Main.CHOOSEAVATARPAGE_WIDTH, Main.CHOOSEAVATARPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage chooseAvatarStage = new Stage();			
    		chooseAvatarStage.setScene(chooseAvatarScene);
    		chooseAvatarStage.setTitle(Main.CHOOSEAVATARPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		chooseAvatarStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		chooseAvatarStage.showAndWait();
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
    @FXML private void clickOnLogOut(ActionEvent event) { 
    	closeWindow();
    }
    
    /**
   	 * Close the window.
   	 */
    @FXML private void closeWindow() { // A method which close the window
		Stage stage = (Stage) userPagePane.getScene().getWindow();
	    stage.close();
	}
}