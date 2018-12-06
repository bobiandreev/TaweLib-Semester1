import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayCopiesPageController {

	@FXML
	private ListView<String> copyList;

	@FXML
	private BorderPane copyPane;

	@FXML
	void clickOnCheckCopyHistory(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DisplayCopiesPage.fxml"));

			BorderPane copyHistory = (BorderPane) fxmlLoader.load();

			Scene copyHistoryScene = new Scene(copyHistory, Main.BROWSEANDSEARCHPAGE_WIDTH,
					Main.BROWSEANDSEARCHPAGE_HEIGHT);
			Stage copyHistoryStage = new Stage();

			copyHistoryStage.setScene(copyHistoryScene);
			copyHistoryStage.setTitle("Copy History Page");
			copyHistoryStage.initModality(Modality.APPLICATION_MODAL);
			copyHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@FXML
	void clickOnBack(ActionEvent event) {

	}

}
