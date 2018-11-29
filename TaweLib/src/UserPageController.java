import javafx.scene.Scene;
import javafx.scene.control.Label;
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
	
	@FXML
	private Label showCurrentBalanceBox;	
    @FXML
    private BorderPane rootPane;
    
    @FXML
    private void clickOnCurrentBalance(ActionEvent event) { // Show the current balance of the user
    	showCurrentBalanceBox.setText(Integer.toString(0));
    }
    
    @FXML
    private void clickOnBorrowItems(ActionEvent event) { // Jump to the Borrow Items Page after the user click the button 
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserBorrowItemsPage.fxml"));
			
    		BorderPane borrowItems = (BorderPane) fxmlLoader.load();
			
    		Scene borrowItemsScene = new Scene(borrowItems, Main.USER_BORROWITEMSPAGE_WIDTH, Main.USER_BORROWITEMSPAGE_HEIGHT);
    		Stage userBorrowItemsStage = new Stage();
			
    		userBorrowItemsStage.setScene(borrowItemsScene);
    		userBorrowItemsStage.setTitle(Main.USER_BORROWITEMSPAGE_TITLE);
    		userBorrowItemsStage.initModality(Modality.APPLICATION_MODAL);
    		userBorrowItemsStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}  	
    } 

    @FXML
    private void clickOnRequestItems(ActionEvent event) { // Jump to the Request Items Page after the user click the button 
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserRequestItemsPage.fxml"));
			
    		BorderPane returnItems = (BorderPane) fxmlLoader.load();
			
    		Scene returnItemsScene = new Scene(returnItems, Main.USER_REQUESTITEMSPAGE_WIDTH, Main.USER_REQUESTITEMSPAGE_HEIGHT);
    		Stage userReturnItemsStage = new Stage();
			
    		userReturnItemsStage.setScene(returnItemsScene);
    		userReturnItemsStage.setTitle(Main.USER_REQUESTITEMSPAGE_TITLE);
    		userReturnItemsStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		userReturnItemsStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    @FXML
    private void clickOnReservedItems(ActionEvent event) { // Jump to the Reserved Items Page after the user click the button 
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserReservedItemsPage.fxml"));
			
    		BorderPane reservedItems = (BorderPane) fxmlLoader.load();
			
    		Scene reservedItemsScene = new Scene(reservedItems, Main.USER_RESERVEDITEMSPAGE_WIDTH, Main.USER_RESERVEDITEMSPAGE_HEIGHT);
    		Stage userReservedItemsStage = new Stage();
			
    		userReservedItemsStage.setScene(reservedItemsScene);
    		userReservedItemsStage.setTitle(Main.USER_RESERVEDITEMSPAGE_TITLE);
    		userReservedItemsStage.initModality(Modality.APPLICATION_MODAL);
    		userReservedItemsStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    @FXML
    private void clickOnTransactionHistory(ActionEvent event) { // Jump to the Transaction History Page after the user click the button 
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserTransactionHistoryPage.fxml"));
			
    		BorderPane transactionHistory = (BorderPane) fxmlLoader.load();
			
    		Scene transactionHistoryScene = new Scene(transactionHistory, Main.USER_TRANSACTIONHISTORYPAGE_WIDTH, Main.USER_TRANSACTIONHISTORYPAGE_HEIGHT);
    		Stage userTransactionHistoryStage = new Stage();
			
    		userTransactionHistoryStage.setScene(transactionHistoryScene);
    		userTransactionHistoryStage.setTitle(Main.USER_TRANSACTIONHISTORYPAGE_TITLE);
    		userTransactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
    		userTransactionHistoryStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    } 
    
    @FXML
    private void clickOnLogOut(ActionEvent event) { 
    	closeWindow();
    }
    
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) rootPane.getScene().getWindow();
	    stage.close();
	}
}