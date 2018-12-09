import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is responsible for the actions done within the Browse and Search
 * window.
 * 
 * @author Ming and Boris
 *
 */
public class BrowseAndSearchPageController {
	private ArrayList<Resource> resourceList;
	private ArrayList<Resource> bookList;
	private ArrayList<Resource> dvdList;
	private ArrayList<Resource> laptopList;
	private static ArrayList<Resource> currentList = new ArrayList<>();
	private static Resource selectedResource;

	public static Resource getSelectedResource() {
		return selectedResource;
	}

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

	private static Resource resourceToEdit;

	private User curUser;

	Alert alert = new Alert(AlertType.INFORMATION);

	public static Resource getResourceToEdit() {
		return resourceToEdit;
	}

	/**
	 * This method gets the selected by the user resource and opens the edit page
	 * for it.
	 * 
	 * @param event
	 *            Clicking the edit button
	 */
	@FXML
	void clickOnEdit(ActionEvent event) {
		curUser = LoginController.getLoggedUser();
		if (curUser instanceof Librarian) {
			int selectedIndex = browseAndSearchList.getSelectionModel().getSelectedIndex();

			if (selectedIndex < 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Please select an item first.");
				alert.showAndWait();
				return;
			}

			Resource selectedResource = currentList.get(selectedIndex);
			String resource = "";
			resourceToEdit = selectedResource;
			if (selectedResource instanceof Book) {
				Book();
			}
			if (selectedResource instanceof DVD) {
				DVD();
			}
			if (selectedResource instanceof LaptopComputer) {
				Laptop();
			}
		} else {
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Error");
			alert1.setHeaderText("Can not do this action!");
			alert1.setContentText("Only librarians can edit items!");
			alert1.showAndWait();

		}
	}

	/**
	 * This method opens the edit book window.
	 */
	@FXML
	private void Book() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditBookPage.fxml"));

			BorderPane editBook = (BorderPane) fxmlLoader.load();

			Scene editBookScene = new Scene(editBook, Main.EDITBOOKPAGE_WIDTH, Main.EDITBOOKPAGE_HEIGHT);
			Stage editBookStage = new Stage();

			editBookStage.setScene(editBookScene);
			editBookStage.setTitle(Main.EDITBOOKPAGE_TITLE);
			editBookStage.initModality(Modality.APPLICATION_MODAL);
			editBookStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the edit DVD window.
	 */
	@FXML
	private void DVD() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditDVDPage.fxml"));

			BorderPane editDVD = (BorderPane) fxmlLoader.load();

			Scene editDVDScene = new Scene(editDVD, Main.EDITDVDPAGE_WIDTH, Main.EDITDVDPAGE_HEIGHT);
			Stage editDVDStage = new Stage();

			editDVDStage.setScene(editDVDScene);
			editDVDStage.setTitle(Main.EDITDVDPAGE_TITLE);
			editDVDStage.initModality(Modality.APPLICATION_MODAL);
			editDVDStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the laptop edit window.
	 */
	@FXML
	private void Laptop() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditLaptopPage.fxml"));

			BorderPane editDVD = (BorderPane) fxmlLoader.load();

			Scene editLaptopScene = new Scene(editDVD, Main.EDITLAPTOPPAGE_WIDTH, Main.EDITLAPTOPPAGE_HEIGHT);
			Stage editLaptopStage = new Stage();

			editLaptopStage.setScene(editLaptopScene);
			editLaptopStage.setTitle(Main.EDITLAPTOPPAGE_TITLE);
			editLaptopStage.initModality(Modality.APPLICATION_MODAL);
			editLaptopStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens up an alert containing all of the information for a
	 * resource
	 * 
	 * @param event
	 *            Clicking on the info button
	 */
	@FXML
	void clickOnInfo(ActionEvent event) {
		int selectedIndex = browseAndSearchList.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select an item first.");
			alert.showAndWait();
			return;
		}
		Resource selectedResource = currentList.get(selectedIndex);
		alert.setTitle("Info");
		Image image = new Image(selectedResource.getThumbnailImage(), 200, 135, true, true);
		ImageView imageView = new ImageView(image);
		alert.setGraphic(imageView);
		alert.setHeaderText(null);
		alert.setContentText(selectedResource.toString());
		alert.showAndWait();
	}

	/**
	 * This method searches through the resource list for items with the same name
	 * as the string put in the search box. Results vary depending on which of the
	 * boxes for filtering are selected.
	 * 
	 * @param event
	 *            Clicking on the search button
	 */
	@FXML
	private void clickOnSearch(ActionEvent event) {
		if (searchItem.getText().isEmpty()) {
			if (bookCheckBox.isSelected() && DVDCheckBox.isSelected()) {
				clearLists();
				addBookToList();
				addDVDToList();
			} else if (bookCheckBox.isSelected() && laptopCheckBox.isSelected()) {
				clearLists();
				addBookToList();
				addLaptopToList();
			} else if (DVDCheckBox.isSelected() && laptopCheckBox.isSelected()) {
				clearLists();
				addDVDToList();
				addLaptopToList();
			} else if (bookCheckBox.isSelected()) {
				clearLists();
				addBookToList();
			} else if (DVDCheckBox.isSelected()) {
				clearLists();
				addDVDToList();
			} else if (laptopCheckBox.isSelected()) {
				clearLists();
				addLaptopToList();
			} else {
				clearLists();
				addAllResourcesToList();
			}
		} else {
			ArrayList<Resource> tempList = new ArrayList<>();
			tempList.addAll(currentList);
			browseAndSearchList.getItems().clear();
			String keyword = searchItem.getText();
			ArrayList<Resource> checkList = new ArrayList<>();
			checkList.addAll(SearchBrowse.search(keyword, tempList));
			if (!checkList.isEmpty()) {
				clearLists();
				for (Resource resource : SearchBrowse.search(keyword, tempList)) {
					currentList.add(resource);
					browseAndSearchList.getItems()
							.add(resource.getID() + " " + resource.getTitle() + " " + resource.getYear());
				}
			}

		}

	}

	/**
	 * This method is called whenever the browse and search window is opened. It
	 * checks which ones of the filter boxes are ticked and adds the necessary items
	 * to the list view to be displayed.
	 */
	public void initialize() {
		resourceList = SearchBrowse.getResources();
		addAllResourcesToList();
		bookList = SearchBrowse.getBooks();
		dvdList = SearchBrowse.getDVDs();
		laptopList = SearchBrowse.getLaptops();

		bookCheckBox.setOnAction(e -> {
			if (DVDCheckBox.isSelected()) {
				handleBookCheckBoxAction();
			} else if (laptopCheckBox.isSelected()) {
				handleBookCheckBoxAction();
			} else {
				clearLists();
				handleBookCheckBoxAction();
			}
		});

		DVDCheckBox.setOnAction(e -> {
			if (bookCheckBox.isSelected()) {
				handleDVDCheckBoxAction();
			} else if (laptopCheckBox.isSelected()) {
				handleDVDCheckBoxAction();
			} else {
				clearLists();
				handleDVDCheckBoxAction();
			}
		});

		laptopCheckBox.setOnAction(e -> {
			if (bookCheckBox.isSelected()) {
				handleLaptopCheckBoxAction();
			} else if (DVDCheckBox.isSelected()) {
				handleLaptopCheckBoxAction();
			} else {
				clearLists();
				handleLaptopCheckBoxAction();
			}
		});
	}

	/**
	 * This method used whenever one of the checkboxes is clicked. It then adds the
	 * necessary items to the list view.
	 */
	private void handleBookCheckBoxAction() {
		if (bookCheckBox.isSelected()) {
			addBookToList();
		} else {
			clearLists();
			if (DVDCheckBox.isSelected() && laptopCheckBox.isSelected()) {
				addDVDToList();
				addLaptopToList();
			} else if (DVDCheckBox.isSelected()) {
				addDVDToList();
			} else if (laptopCheckBox.isSelected()) {
				addLaptopToList();
			} else {
				addAllResourcesToList();
			}
		}

	}

	/**
	 * Handle the DVD Check Box. Searching filter of resources.
	 */
	private void handleDVDCheckBoxAction() {
		if (DVDCheckBox.isSelected()) {
			addDVDToList();
		} else {
			clearLists();
			if (bookCheckBox.isSelected() && laptopCheckBox.isSelected()) {
				addBookToList();
				addLaptopToList();
			} else if (bookCheckBox.isSelected()) {
				addBookToList();
			} else if (laptopCheckBox.isSelected()) {
				addLaptopToList();
			} else {
				addAllResourcesToList();
			}
		}

	}

	/**
	 * Handle the Laptop Check Box. Searching filter of resources.
	 */
	private void handleLaptopCheckBoxAction() {
		if (laptopCheckBox.isSelected()) {
			addLaptopToList();
		} else {
			clearLists();
			if (bookCheckBox.isSelected() && DVDCheckBox.isSelected()) {
				addBookToList();
				addDVDToList();
			} else if (bookCheckBox.isSelected()) {
				addBookToList();
			} else if (DVDCheckBox.isSelected()) {
				addDVDToList();
			} else {
				addAllResourcesToList();
			}
		}

	}

	/**
	 * This method opens a new window where all of the copies of a resource are
	 * displayed and a user can see if they are borrowed or not.
	 * 
	 * @param event
	 *            Clicking on the check for copies button
	 */
	@FXML
	private void clickOnCheckForCopies(ActionEvent event) {
		int selectedIndex = browseAndSearchList.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		selectedResource = currentList.get(selectedIndex);
		String stringCopies = "";
		String borrowed = "";
		for (Copy copy : selectedResource.getCopies()) {
			if (copy.getIsBorrowed()) {
				borrowed = "Borrowed.";
			} else {
				borrowed = "Available.";
			}
			stringCopies += "Copy: " + copy.getCopyId() + "\t\tStatus: " + borrowed + "\n";
		}

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DisplayCopiesPage.fxml"));

			BorderPane copiesAvailable = (BorderPane) fxmlLoader.load();

			Scene copiesAvailableScene = new Scene(copiesAvailable, Main.BROWSEANDSEARCHPAGE_WIDTH,
					Main.BROWSEANDSEARCHPAGE_HEIGHT);
			Stage copiesAvailableStage = new Stage();

			copiesAvailableStage.setScene(copiesAvailableScene);
			copiesAvailableStage.setTitle("Copy History Page");
			copiesAvailableStage.initModality(Modality.APPLICATION_MODAL);
			copiesAvailableStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/*
	 * alert.setTitle("Copies"); alert.setHeaderText(null);
	 * alert.setContentText(stringCopies); alert.showAndWait();
	 */

	/**
	 * Calls the close window method
	 * 
	 * @param event
	 *            Clicking on the back button
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Close the window.
	 */
	@FXML
	private void closeWindow() {
		Stage stage = (Stage) browseAndSearchPane.getScene().getWindow();
		stage.close();
	}

	/**
	 * Clears all the lists from filters
	 */
	private void clearLists() {
		currentList.clear();
		browseAndSearchList.getItems().clear();
	}

	/**
	 * Adds all resources to the list view
	 */
	private void addAllResourcesToList() {
		// currentList = resourceList;
		for (Resource resource : resourceList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getID() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	/**
	 * Adds books to the list view
	 */
	private void addBookToList() {
		for (Resource resource : bookList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getID() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	/**
	 * Adds dvds to the list view
	 */
	private void addDVDToList() {
		for (Resource resource : dvdList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getID() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	/**
	 * Adds laptops to the list view
	 */
	private void addLaptopToList() {
		for (Resource resource : laptopList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getID() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}
}
