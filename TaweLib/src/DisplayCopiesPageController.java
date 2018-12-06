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

	private User curUser;
	private Resource resource;

	@FXML
	private void initialize() {
		resource = BrowseAndSearchPageController.getSelectedResource();
		String stringCopies = "";
		String borrowed = "";
		for (Copy copy : resource.getCopies()) {
			if (copy.getIsBorrowed()) {
				borrowed = "Borrowed.";
			} else {
				borrowed = "Available.";
			}
			stringCopies = "Copy: " + copy.getCopyId() + "\t\tStatus: " + borrowed + "\n";
			copyList.getItems().add(stringCopies);
		}
	}

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
		closeWindow();
	}

	@FXML
	void clickOnRequestACopy(ActionEvent event) {
		curUser = LoginController.getLoggedUser();
		curUser.requestItem(resource);
	}

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) copyPane.getScene().getWindow();
		stage.close();
	}
}
