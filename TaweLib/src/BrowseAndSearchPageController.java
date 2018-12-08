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
 * The BrowseAndSearchPageController Class which controls the
 * BrowseAndSearchPage.fxml
 * 
 * @author Ming
 * @version 1.0
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

    /**
     * Getter method for the resource that we want to change.
     * 
     * @return The resource changes are going to be made.
     */
    public static Resource getResourceToEdit() {
	return resourceToEdit;
    }

    /**
     * Method that shows what the edit button has to do.
     * 
     * @param event The mouse click on the button.
     */
    @FXML
    void clickOnEdit(ActionEvent event) {
	curUser = LoginController.getLoggedUser();
	if (curUser instanceof Librarian) {
	    int selectedIndex = browseAndSearchList.getSelectionModel()
		    .getSelectedIndex();

	    if (selectedIndex < 0) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Please select an item first.");
		alert.showAndWait();
		return;
	    }

	    Resource selectedResource = currentList.get(selectedIndex);
	    resourceToEdit = selectedResource;
	    if (selectedResource instanceof Book) {
		book();
	    }
	    if (selectedResource instanceof DVD) {
		DVD();
	    }
	    if (selectedResource instanceof LaptopComputer) {
		laptop();
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
     * Treats the resource as a book showing the proper attributes.
     */
    @FXML
    private void book() {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditBookPage.fxml"));

	    BorderPane editBook = (BorderPane) fxmlLoader.load();

	    Scene editBookScene = new Scene(editBook, Main.EDITBOOKPAGE_WIDTH,
		    Main.EDITBOOKPAGE_HEIGHT);
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
     * Treats the resource as a DVD showing the proper attributes.
     */
    @FXML
    private void DVD() {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditDVDPage.fxml"));

	    BorderPane editDVD = (BorderPane) fxmlLoader.load();

	    Scene editDVDScene = new Scene(editDVD, Main.EDITDVDPAGE_WIDTH,
		    Main.EDITDVDPAGE_HEIGHT);
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
     * Treats the resource as a laptopcomputer showing the proper attributes.
     */
    @FXML
    private void laptop() {
	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("EditLaptopPage.fxml"));

	    BorderPane editDVD = (BorderPane) fxmlLoader.load();

	    Scene editLaptopScene = new Scene(editDVD,
		    Main.EDITLAPTOPPAGE_WIDTH, Main.EDITLAPTOPPAGE_HEIGHT);
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
     * Method that show a resource information.
     * 
     * @param event The mouse click on the button.
     */
    @FXML
    void clickOnInfo(ActionEvent event) {
	int selectedIndex = browseAndSearchList.getSelectionModel()
		.getSelectedIndex();

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
	Image image = new Image(selectedResource.getThumbnailImage(), 200, 135,
		true, true);
	ImageView imageView = new ImageView(image);
	alert.setGraphic(imageView);
	alert.setHeaderText(null);
	alert.setContentText(selectedResource.toString());
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
	    } else if (bookCheckBox.isSelected()
		    && laptopCheckBox.isSelected()) {
		clearLists();
		addBookToList();
		addLaptopToList();
	    } else if (DVDCheckBox.isSelected()
		    && laptopCheckBox.isSelected()) {
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
		for (Resource resource : SearchBrowse.search(keyword,
			tempList)) {
		    currentList.add(resource);
		    browseAndSearchList.getItems().add(resource.getID() + " "
			    + resource.getTitle() + " " + resource.getYear());
		}
	    }

	}

    }

    /**
     * Initialize the controller. The following happen in this order: 1) First
     * an instance of the controller is created (the constructor is called), 2)
     * Next the @FXML variables are bound to the GUI components. 3) Finally,
     * this initialize method is called.
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
	int selectedIndex = browseAndSearchList.getSelectionModel()
		.getSelectedIndex();

	if (selectedIndex < 0) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Error");
	    alert.setHeaderText(null);
	    alert.setContentText("Please select a book first.");
	    alert.showAndWait();
	    return;
	}

	selectedResource = currentList.get(selectedIndex);
	String borrowed = "";
	String stringCopies = "";
	for (Copy copy : selectedResource.getCopies()) {
	    if (copy.getIsBorrowed()) {
		borrowed = "Borrowed.";
	    } else {
		borrowed = "Available.";
	    }
	    stringCopies += "Copy: " + copy.getCopyId() + "\t\tStatus: "
		    + borrowed + "\n";
	}

	try {
	    FXMLLoader fxmlLoader = new FXMLLoader(
		    getClass().getResource("DisplayCopiesPage.fxml"));

	    BorderPane copiesAvailable = (BorderPane) fxmlLoader.load();

	    Scene copiesAvailableScene = new Scene(copiesAvailable,
		    Main.BROWSEANDSEARCHPAGE_WIDTH,
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

    /**
     * Method to clear the current and showing lists.
     */
    private void clearLists() {
	currentList.clear();
	browseAndSearchList.getItems().clear();
    }

    /**
     * Method to add all the resources to the lists.
     */
    private void addAllResourcesToList() {
	// currentList = resourceList;
	for (Resource resource : resourceList) {
	    currentList.add(resource);
	    browseAndSearchList.getItems().add(resource.getID() + " "
		    + resource.getTitle() + " " + resource.getYear());
	}
    }

    /**
     * Method to add all the books to the lists.
     */
    private void addBookToList() {
	for (Resource resource : bookList) {
	    currentList.add(resource);
	    browseAndSearchList.getItems().add(resource.getID() + " "
		    + resource.getTitle() + " " + resource.getYear());
	}
    }

    /**
     * Method to add all the DVDs to the lists.
     */
    private void addDVDToList() {
	for (Resource resource : dvdList) {
	    currentList.add(resource);
	    browseAndSearchList.getItems().add(resource.getID() + " "
		    + resource.getTitle() + " " + resource.getYear());
	}
    }

    /**
     * Method to add all the Laptopcomputers to the lists.
     */
    private void addLaptopToList() {
	for (Resource resource : laptopList) {
	    currentList.add(resource);
	    browseAndSearchList.getItems().add(resource.getID() + " "
		    + resource.getTitle() + " " + resource.getYear());
	}
    }
}
