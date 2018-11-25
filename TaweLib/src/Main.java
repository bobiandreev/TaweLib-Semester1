import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The main class
 * @author Ming
 *
 */
public class Main extends Application {
	// Constants for the HomePage window
	private static final int HOMEPAGE_WIDTH = 800;
	private static final int HOMEPAGE_HEIGHT = 600;
	private static final String HOMEPAGE_TITLE = "Home Page";
	
	// Constants for the User Page window
	public static final int USER_PAGE_WIDTH = 800;
	public static final int USER_PAGE_HEIGHT = 600;
	public static final String USER_PAGE_TITLE = "User Page";
	
	// Constants for the Borrow Items Page window
	public static final int USER_BORROWITEMSPAGE_WIDTH = 600;
	public static final int USER_BORROWITEMSPAGE_HEIGHT = 400;
	public static final String USER_BORROWITEMSPAGE_TITLE = "Borrowing Items Page";
	
	// Constants for the Return Items Page window
	public static final int USER_REQUESTITEMSPAGE_WIDTH = 600;
	public static final int USER_REQUESTITEMSPAGE_HEIGHT = 400;
	public static final String USER_REQUESTITEMSPAGE_TITLE = "Request Items Page";
	
	// Constants for the Reserved Items Page window
	public static final int USER_RESERVEDITEMSPAGE_WIDTH = 600;
	public static final int USER_RESERVEDITEMSPAGE_HEIGHT = 400;
	public static final String USER_RESERVEDITEMSPAGE_TITLE = "Reserved Items Page";
	
	// Constants for the Transaction History Page window
	public static final int USER_TRANSACTIONHISTORYPAGE_WIDTH = 600;
	public static final int USER_TRANSACTIONHISTORYPAGE_HEIGHT = 400;
	public static final String USER_TRANSACTIONHISTORYPAGE_TITLE = "Transaction History Page";
	
	// Constants for the Librarian Page window
	public static final int LIBRARIAN_PAGE_WIDTH = 800;
	public static final int LIBRARIAN_PAGE_HEIGHT = 600;
	public static final String LIBRARIAN_PAGE_TITLE = "Librarian Page";
	
	// Constants for the Records of Users Page window
	public static final int RECORDSOFUSERSPAGE_WIDTH = 600;
	public static final int RECORDSOFUSERSPAGE_HEIGHT = 400;
	public static final String RECORDSOFUSERSPAGE_TITLE = "Records of Users Page";
		
	public void start(Stage primaryStage) {
		try {
			// Load the main scene.
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene scene = new Scene(root, HOMEPAGE_WIDTH, HOMEPAGE_HEIGHT);

			// Place the main scene on stage and show it.
			primaryStage.setScene(scene);
			primaryStage.setTitle(HOMEPAGE_TITLE);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
