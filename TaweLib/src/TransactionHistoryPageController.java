import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TransactionHistoryPageController {

    @FXML
    private BorderPane transacationHistoryPane;

    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    void clickOnFineHistory(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FineHistoryPage.fxml"));

			BorderPane fineHistory = (BorderPane) fxmlLoader.load();

			Scene fineHistoryScene = new Scene(fineHistory, Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage fineHistoryStage = new Stage();

			fineHistoryStage.setScene(fineHistoryScene);
			fineHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			fineHistoryStage.initModality(Modality.APPLICATION_MODAL);
			fineHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }

    @FXML
    void clickOnPaymentHistory(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PaymentHistoryPage.fxml"));

			BorderPane paymentHistory = (BorderPane) fxmlLoader.load();

			Scene paymentHistoryScene = new Scene(paymentHistory, Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage paymentHistoryStage = new Stage();

			paymentHistoryStage.setScene(paymentHistoryScene);
			paymentHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			paymentHistoryStage.initModality(Modality.APPLICATION_MODAL);
			paymentHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
    }
    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) transacationHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
