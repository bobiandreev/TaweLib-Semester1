import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PaymentHistoryPageController {

    @FXML
    private ListView<?> paymentHistoryList;

    @FXML
    private BorderPane paymentHistoryPane;

    @FXML
    void clickOnBack(ActionEvent event) {
    	closeWindow();
    }

    @FXML
    private void closeWindow() { // A method which close the window
		Stage stage = (Stage) paymentHistoryPane.getScene().getWindow();
	    stage.close();
	}
}
