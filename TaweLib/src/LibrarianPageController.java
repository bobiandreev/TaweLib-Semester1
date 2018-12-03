import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The LibrarianPage Class which controls the LibrarianPage.fxml
 * @author Ming
 *
 */
	public class LibrarianPageController {

    @FXML private BorderPane librarianPane;
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnCreateNewResources(ActionEvent event) {
    	// We need to use a try-catch block as the loading of the FXML file can fail.
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseCreateTypePage.fxml"));
    		// Run the loader
    		BorderPane chooseCreateType = (BorderPane) fxmlLoader.load();
			// Create a scene based on the loaded FXML scene graph
    		Scene chooseCreateTypeScene = new Scene(chooseCreateType, Main.CHOOSECREATETYPEPAGE_WIDTH, Main.CHOOSECREATETYPEPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage chooseCreateTypeStage = new Stage();		
    		chooseCreateTypeStage.setScene(chooseCreateTypeScene);
    		chooseCreateTypeStage.setTitle(Main.CHOOSECREATETYPEPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		chooseCreateTypeStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		chooseCreateTypeStage.showAndWait();
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
    @FXML private void clickOnBrowseAndSearch(ActionEvent event) {
    	// We need to use a try-catch block as the loading of the FXML file can fail.
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
    @FXML private void clickOnLoanCopy(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoanCopyPage.fxml"));
    		// Run the loader
    		BorderPane loanCopy = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene loanCopyScene = new Scene(loanCopy, Main.LOANCOPYPAGE_WIDTH, Main.LOANCOPYPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage loanCopyStage = new Stage();		
    		loanCopyStage.setScene(loanCopyScene);
    		loanCopyStage.setTitle(Main.LOANCOPYPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		loanCopyStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		loanCopyStage.showAndWait();
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
    @FXML private void clickOnRecieveReturn(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecieveReturnPage.fxml"));
    		// Run the loader
    		BorderPane recieveReturn = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene recieveReturnScene = new Scene(recieveReturn, Main.RECIEVERETURNPAGE_WIDTH, Main.RECIEVERETURNPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage recieveReturnStage = new Stage();			
    		recieveReturnStage.setScene(recieveReturnScene);
    		recieveReturnStage.setTitle(Main.RECIEVERETURNPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		recieveReturnStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		recieveReturnStage.showAndWait();
    	} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    
    /**
   	 * Actions will be made when the user click on the button
   	 * @param event
   	 */
    @FXML private void clickOnCreateNewUser(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateNewUserPage.fxml"));
    		// Run the loader
    		BorderPane createNewUser = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene createNewUserScene = new Scene(createNewUser, Main.CREATENEWUSERPAGE_WIDTH, Main.CREATENEWUSERPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage createNewUserStage = new Stage();			
    		createNewUserStage.setScene(createNewUserScene);
    		createNewUserStage.setTitle(Main.CREATENEWUSERPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		createNewUserStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		createNewUserStage.showAndWait();
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
    @FXML private void clickOnDrawAvatar(ActionEvent event) {

    }

    @FXML private void clickOnViewResources(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewResourcesPage.fxml"));
    		// Run the loader
    		BorderPane viewResourcesPage = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene viewResourcesPageScene = new Scene(viewResourcesPage, Main.VIEWRESOURCESPAGE_WIDTH, Main.VIEWRESOURCESPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage viewResourcesPageStage = new Stage();	
    		viewResourcesPageStage.setScene(viewResourcesPageScene);
    		viewResourcesPageStage.setTitle(Main.VIEWRESOURCESPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		viewResourcesPageStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
    		viewResourcesPageStage.showAndWait();
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
    @FXML private void clickOnFinePayment(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrarianFinePaymentPage.fxml"));
    		// Run the loader
    		BorderPane librarianFinePayment = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene librarianFinePaymentScene = new Scene(librarianFinePayment, Main.LIBRARIAN_FINEPAYMENTPAGE_WIDTH, Main.LIBRARIAN_FINEPAYMENTPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage librarianFinePaymentStage = new Stage();			
    		librarianFinePaymentStage.setScene(librarianFinePaymentScene);
    		librarianFinePaymentStage.setTitle(Main.LIBRARIAN_FINEPAYMENTPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		librarianFinePaymentStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		librarianFinePaymentStage.showAndWait();
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
    @FXML private void clickOnTransactionHistory(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TransactionHistoryPage.fxml"));
    		// Run the loader
    		BorderPane transactionHistory = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene transactionHistoryScene = new Scene(transactionHistory, Main.TRANSACTIONHISTORYPAGE_WIDTH, Main.TRANSACTIONHISTORYPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage transactionHistoryStage = new Stage();
    		transactionHistoryStage.setScene(transactionHistoryScene);
    		transactionHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		transactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
      		// Show the edit scene and wait for it to be closed
    		transactionHistoryStage.showAndWait();
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
    @FXML private void clickOnBorrowingRequest(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BorrowRequestPage.fxml"));
    		// Run the loader
    		BorderPane userBorrowing = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene userBorrowingScene = new Scene(userBorrowing, Main.BORROWREQUESTPAGE_WIDTH, Main.BORROWREQUESTPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userBorrowingStage = new Stage();	
    		userBorrowingStage.setScene(userBorrowingScene);
    		userBorrowingStage.setTitle(Main.BORROWREQUESTPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userBorrowingStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userBorrowingStage.showAndWait();
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
    @FXML private void clickOnReturningRequest(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReturnRequestPage.fxml"));
    		// Run the loader
    		BorderPane userReturning = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene userReturningScene = new Scene(userReturning, Main.RETURNREQUESTPAGE_WIDTH, Main.RETURNREQUESTPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage userReturningStage = new Stage();		
    		userReturningStage.setScene(userReturningScene);
    		userReturningStage.setTitle(Main.RETURNREQUESTPAGE_TITLE);
    		// Make the stage a modal window.
    		// This means that it must be closed before you can interact with any other window from this application.
    		userReturningStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		userReturningStage.showAndWait();
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
    @FXML private void clickOnViewOverdueResources(ActionEvent event) {
    	try {
    		// Create a FXML loader for loading the Edit Country FXML file.
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewOverdueResourcesPage.fxml"));
    		// Run the loader
    		BorderPane overdueResources = (BorderPane) fxmlLoader.load();
    		// Create a scene based on the loaded FXML scene graph
    		Scene overdueResourcesScene = new Scene(overdueResources, Main.OVERDUERESOURCESPAGE_WIDTH, Main.OVERDUERESOURCESPAGE_HEIGHT);
    		// Create a new stage (i.e., window) based on the edit scene
    		Stage overdueResourcesStage = new Stage();
    		overdueResourcesStage.setScene(overdueResourcesScene);
    		overdueResourcesStage.setTitle(Main.OVERDUERESOURCESPAGE_TITLE);
    		overdueResourcesStage.initModality(Modality.APPLICATION_MODAL);
    		// Show the edit scene and wait for it to be closed
    		overdueResourcesStage.showAndWait();
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
		Stage stage = (Stage) librarianPane.getScene().getWindow();
	    stage.close();
	}
}

