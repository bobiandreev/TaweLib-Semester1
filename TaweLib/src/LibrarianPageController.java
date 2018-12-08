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
 * 
 * @author Ming
 * @version 1.0
 *
 */
public class LibrarianPageController {

    @FXML
    private BorderPane librarianPane;

    /**
     * Method to Create a new resource.
     * 
     * @param event Mouse click on Create NewResources.
     */
    @FXML
    private void clickOnCreateNewResources(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("ChooseCreateTypePage.fxml"));

	    BorderPane chooseCreateType = (BorderPane) fxmlLoader.load();

	    Scene chooseCreateTypeScene = new Scene(chooseCreateType,
		    Main.CHOOSECREATETYPEPAGE_WIDTH,
		    Main.CHOOSECREATETYPEPAGE_HEIGHT);
	    Stage chooseCreateTypeStage = new Stage();

	    chooseCreateTypeStage.setScene(chooseCreateTypeScene);
	    chooseCreateTypeStage.setTitle(Main.CHOOSECREATETYPEPAGE_TITLE);
	    chooseCreateTypeStage.initModality(Modality.APPLICATION_MODAL);
	    chooseCreateTypeStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to open browse and Search.
     * 
     * @param event Mouse click on Browse and Search.
     */
    @FXML
    private void clickOnBrowseAndSearch(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("BrowseAndSearchPage.fxml"));

	    BorderPane browseAndSearch = (BorderPane) fxmlLoader.load();

	    Scene browseAndSearchScene = new Scene(browseAndSearch,
		    Main.BROWSEANDSEARCHPAGE_WIDTH,
		    Main.BROWSEANDSEARCHPAGE_HEIGHT);
	    Stage browseAndSearchStage = new Stage();

	    browseAndSearchStage.setScene(browseAndSearchScene);
	    browseAndSearchStage.setTitle(Main.BROWSEANDSEARCHPAGE_TITLE);
	    browseAndSearchStage.initModality(Modality.APPLICATION_MODAL);
	    browseAndSearchStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to loan a copy.
     * 
     * @param event Mouse click on Loan a Copy.
     */
    @FXML
    private void clickOnLoanCopy(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("LoanCopyPage.fxml"));

	    BorderPane loanCopy = (BorderPane) fxmlLoader.load();

	    Scene loanCopyScene = new Scene(loanCopy, Main.LOANCOPYPAGE_WIDTH,
		    Main.LOANCOPYPAGE_HEIGHT);
	    Stage loanCopyStage = new Stage();

	    loanCopyStage.setScene(loanCopyScene);
	    loanCopyStage.setTitle(Main.LOANCOPYPAGE_TITLE);
	    loanCopyStage.initModality(Modality.APPLICATION_MODAL);
	    loanCopyStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to Receive a Copy.
     * 
     * @param event Mouse click on Receive Return.
     */
    @FXML
    private void clickOnRecieveReturn(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("RecieveReturnPage.fxml"));

	    BorderPane recieveReturn = (BorderPane) fxmlLoader.load();

	    Scene recieveReturnScene = new Scene(recieveReturn,
		    Main.RECIEVERETURNPAGE_WIDTH,
		    Main.RECIEVERETURNPAGE_HEIGHT);
	    Stage recieveReturnStage = new Stage();

	    recieveReturnStage.setScene(recieveReturnScene);
	    recieveReturnStage.setTitle(Main.RECIEVERETURNPAGE_TITLE);
	    recieveReturnStage.initModality(Modality.APPLICATION_MODAL);
	    recieveReturnStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to Create a New User.
     * 
     * @param event Mouse click on Create New User.
     */
    @FXML
    private void clickOnCreateNewUser(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("CreateNewUserPage.fxml"));

	    BorderPane createNewUser = (BorderPane) fxmlLoader.load();

	    Scene createNewUserScene = new Scene(createNewUser,
		    Main.CREATENEWUSERPAGE_WIDTH,
		    Main.CREATENEWUSERPAGE_HEIGHT);
	    Stage createNewUserStage = new Stage();

	    createNewUserStage.setScene(createNewUserScene);
	    createNewUserStage.setTitle(Main.CREATENEWUSERPAGE_TITLE);
	    createNewUserStage.initModality(Modality.APPLICATION_MODAL);
	    createNewUserStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to draw an avatar.
     * 
     * @param event Mose click on Draw Avatar.
     */
    @FXML
    private void clickOnDrawAvatar(ActionEvent event) {

    }

    /**
     * Method to View all resources.
     * 
     * @param event Click on View Resources button.
     */
    @FXML
    private void clickOnViewResources(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("ViewResourcesPage.fxml"));

	    BorderPane viewResourcesPage = (BorderPane) fxmlLoader.load();

	    Scene viewResourcesPageScene = new Scene(viewResourcesPage,
		    Main.VIEWRESOURCESPAGE_WIDTH,
		    Main.VIEWRESOURCESPAGE_HEIGHT);
	    Stage viewResourcesPageStage = new Stage();

	    viewResourcesPageStage.setScene(viewResourcesPageScene);
	    viewResourcesPageStage.setTitle(Main.VIEWRESOURCESPAGE_TITLE);
	    viewResourcesPageStage.initModality(Modality.APPLICATION_MODAL);
	    viewResourcesPageStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to pay a fine.
     * 
     * @param event Mouse click on Fine Payment button.
     */
    @FXML
    private void clickOnFinePayment(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("FinePaymentPage.fxml"));

	    BorderPane FinePayment = (BorderPane) fxmlLoader.load();

	    Scene FinePaymentScene = new Scene(FinePayment,
		    Main.LIBRARIAN_FINEPAYMENTPAGE_WIDTH,
		    Main.LIBRARIAN_FINEPAYMENTPAGE_HEIGHT);
	    Stage FinePaymentStage = new Stage();

	    FinePaymentStage.setScene(FinePaymentScene);
	    FinePaymentStage.setTitle(Main.LIBRARIAN_FINEPAYMENTPAGE_TITLE);
	    FinePaymentStage.initModality(Modality.APPLICATION_MODAL);
	    FinePaymentStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to see the Transaction history.
     * 
     * @param event Mouse click on Transaction History button.
     */
    @FXML
    private void clickOnTransactionHistory(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("TransactionHistoryPage.fxml"));

	    BorderPane transactionHistory = (BorderPane) fxmlLoader.load();

	    Scene transactionHistoryScene = new Scene(transactionHistory,
		    Main.TRANSACTIONHISTORYPAGE_WIDTH,
		    Main.TRANSACTIONHISTORYPAGE_HEIGHT);
	    Stage transactionHistoryStage = new Stage();

	    transactionHistoryStage.setScene(transactionHistoryScene);
	    transactionHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
	    transactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
	    transactionHistoryStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to see who is requesting to borrow a Copy.
     * 
     * @param event Mouse click on Borrowing Request button.
     */
    @FXML
    private void clickOnBorrowingRequest(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("BorrowRequestPage.fxml"));

	    BorderPane userBorrowing = (BorderPane) fxmlLoader.load();

	    Scene userBorrowingScene = new Scene(userBorrowing,
		    Main.BORROWREQUESTPAGE_WIDTH,
		    Main.BORROWREQUESTPAGE_HEIGHT);
	    Stage userBorrowingStage = new Stage();

	    userBorrowingStage.setScene(userBorrowingScene);
	    userBorrowingStage.setTitle(Main.BORROWREQUESTPAGE_TITLE);
	    userBorrowingStage.initModality(Modality.APPLICATION_MODAL);
	    userBorrowingStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to see who is requesting to return a Copy.
     * 
     * @param event Mouse click on Returning Request button.
     */
    @FXML
    private void clickOnReturningRequest(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("ReturnRequestPage.fxml"));

	    BorderPane userReturning = (BorderPane) fxmlLoader.load();

	    Scene userReturningScene = new Scene(userReturning,
		    Main.RETURNREQUESTPAGE_WIDTH,
		    Main.RETURNREQUESTPAGE_HEIGHT);
	    Stage userReturningStage = new Stage();

	    userReturningStage.setScene(userReturningScene);
	    userReturningStage.setTitle(Main.RETURNREQUESTPAGE_TITLE);
	    userReturningStage.initModality(Modality.APPLICATION_MODAL);
	    userReturningStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method to view overdue resources.
     * 
     * @param event Mouse click on View Overdue Resources button.
     */
    @FXML
    private void clickOnViewOverdueResources(ActionEvent event) {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("ViewOverdueResourcesPage.fxml"));

	    BorderPane overdueResources = (BorderPane) fxmlLoader.load();

	    Scene overdueResourcesScene = new Scene(overdueResources,
		    Main.OVERDUERESOURCESPAGE_WIDTH,
		    Main.OVERDUERESOURCESPAGE_HEIGHT);
	    Stage overdueResourcesStage = new Stage();

	    overdueResourcesStage.setScene(overdueResourcesScene);
	    overdueResourcesStage.setTitle(Main.OVERDUERESOURCESPAGE_TITLE);
	    overdueResourcesStage.initModality(Modality.APPLICATION_MODAL);
	    overdueResourcesStage.showAndWait();
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
    }

    /**
     * Method for user to log out.
     * 
     * @param event Mouse click on Log Out button.
     */
    @FXML
    private void clickOnLogOut(ActionEvent event) {
	closeWindow();
	Database.saveData();
    }

    /**
     * Method to close the window.
     */
    @FXML
    private void closeWindow() { // A method which close the window
	Stage stage = (Stage) librarianPane.getScene().getWindow();
	stage.close();
    }
}
