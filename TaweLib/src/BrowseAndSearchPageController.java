import java.util.ArrayList;
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
 * The BrowseAndSearchPageController Class which controls the
 * BrowseAndSearchPage.fxml
 * 
 * @author Ming
 *
 */
public class BrowseAndSearchPageController {
	private ArrayList<Resource> resourceList;
	private ArrayList<Resource> bookList;
	private ArrayList<Resource> dvdList;
	private ArrayList<Resource> laptopList;
	private ArrayList<Resource> currentList = new ArrayList<>();

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

	Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    void clickOnEdit(ActionEvent event) {

    }
	
    @FXML
    void clickOnInfo(ActionEvent event) {
    	int selectedIndex = browseAndSearchList.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		Resource selectedResource = currentList.get(selectedIndex);
		String resource = "";
		
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText(resource);
		alert.showAndWait();
    }
    
	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
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
							.add(resource.getid() + " " + resource.getTitle() + " " + resource.getYear());
				}
			}
			
		}

	}

	/**
	 * Initialize the controller. The following happen in this order: 1) First an
	 * instance of the controller is created (the constructor is called), 2) Next
	 * the @FXML variables are bound to the GUI components. 3) Finally, this
	 * initialize method is called.
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
	 * Handle the Book Check Box. Searching filter of resources.
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
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
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

		Resource selectedResource = currentList.get(selectedIndex);
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
		alert.setTitle("Copies");
		alert.setHeaderText(null);
		alert.setContentText(stringCopies);
		alert.showAndWait();
	}

	/**
	 * Actions will be made when the user click on the button
	 * 
	 * @param event
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

	private void clearLists() {
		currentList.clear();
		browseAndSearchList.getItems().clear();
	}

	private void addAllResourcesToList() {
		// currentList = resourceList;
		for (Resource resource : resourceList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getid() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	private void addBookToList() {
		for (Resource resource : bookList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getid() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	private void addDVDToList() {
		for (Resource resource : dvdList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getid() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}

	private void addLaptopToList() {
		for (Resource resource : laptopList) {
			currentList.add(resource);
			browseAndSearchList.getItems().add(resource.getid() + " " + resource.getTitle() + " " + resource.getYear());
		}
	}
}
