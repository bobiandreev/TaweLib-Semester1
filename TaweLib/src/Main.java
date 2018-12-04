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
	private static final int HOMEPAGE_HEIGHT = 500;
	private static final String HOMEPAGE_TITLE = "Home Page";
	
	// Constants for the User Page window
	public static final int USER_PAGE_WIDTH = 800;
	public static final int USER_PAGE_HEIGHT = 600;
	public static final String USER_PAGE_TITLE = "User Page";
	
	// Constants for the Borrowed Items Page window
	public static final int USER_BORROWEDITEMSPAGE_WIDTH = 600;
	public static final int USER_BORROWEDITEMSPAGE_HEIGHT = 400;
	public static final String USER_BORROWEDITEMSPAGE_TITLE = "Borrowed Items Page";
	
	// Constants for the Requested Items Page window
	public static final int USER_REQUESTEDITEMSPAGE_WIDTH = 600;
	public static final int USER_REQUESTEDITEMSPAGE_HEIGHT = 400;
	public static final String USER_REQUESTEDITEMSPAGE_TITLE = "Requested Items Page";
	
	// Constants for the Reserved Items Page window
	public static final int USER_RESERVEDITEMSPAGE_WIDTH = 600;
	public static final int USER_RESERVEDITEMSPAGE_HEIGHT = 400;
	public static final String USER_RESERVEDITEMSPAGE_TITLE = "Reserved Items Page";
	
	// Constants for the Transaction History Page window
	public static final int TRANSACTIONHISTORYPAGE_WIDTH = 600;
	public static final int TRANSACTIONHISTORYPAGE_HEIGHT = 400;
	public static final String TRANSACTIONHISTORYPAGE_TITLE = "Transaction History Page";
	
	// Constants for the Librarian Page window
	public static final int LIBRARIAN_PAGE_WIDTH = 800;
	public static final int LIBRARIAN_PAGE_HEIGHT = 600;
	public static final String LIBRARIAN_PAGE_TITLE = "Librarian Page";
	
	// Constants for the Borrow Request window
	public static final int BORROWREQUESTPAGE_WIDTH = 600;
	public static final int BORROWREQUESTPAGE_HEIGHT = 400;
	public static final String BORROWREQUESTPAGE_TITLE = "Borrowing Request Page";
		
	// Constants for the Return Request Items window
	public static final int RETURNREQUESTPAGE_WIDTH = 600;
	public static final int RETURNREQUESTPAGE_HEIGHT = 400;
	public static final String RETURNREQUESTPAGE_TITLE = "Returning Request Page";
	
	// Constants for the Overdue Resources window
	public static final int OVERDUERESOURCESPAGE_WIDTH = 600;
	public static final int OVERDUERESOURCESPAGE_HEIGHT = 400;
	public static final String OVERDUERESOURCESPAGE_TITLE = "View Overdue Resources Page";
	
	// Constants for the Create New User Page window
	public static final int CREATENEWUSERPAGE_WIDTH = 600;
	public static final int CREATENEWUSERPAGE_HEIGHT = 400;
	public static final String CREATENEWUSERPAGE_TITLE = "Create New User Page";
	
	// Constants for the View Resources Page window
	public static final int VIEWRESOURCESPAGE_WIDTH = 600;
	public static final int VIEWRESOURCESPAGE_HEIGHT = 400;
	public static final String VIEWRESOURCESPAGE_TITLE = "View Resources Page";
	

	// Constants for the User Fine Payment Page window
	public static final int USER_FINEPAYMENTPAGE_WIDTH = 600;
	public static final int USER_FINEPAYMENTPAGE_HEIGHT = 350;
	public static final String USER_FINEPAYMENTPAGE_TITLE = "User Fine Payment Page";
	
	// Constants for the Librarian Fine Payment Page window
	public static final int LIBRARIAN_FINEPAYMENTPAGE_WIDTH = 600;
	public static final int LIBRARIAN_FINEPAYMENTPAGE_HEIGHT = 400;
	public static final String LIBRARIAN_FINEPAYMENTPAGE_TITLE = "Librarian Fine Payment Page";

	// Constants for the Browse And Search Page window
	public static final int BROWSEANDSEARCHPAGE_WIDTH = 600;
	public static final int BROWSEANDSEARCHPAGE_HEIGHT = 400;
	public static final String BROWSEANDSEARCHPAGE_TITLE = "Browse And Search Page";
	
	// Constants for the Choose Create Type Page window
	public static final int CHOOSECREATETYPEPAGE_WIDTH = 600;
	public static final int CHOOSECREATETYPEPAGE_HEIGHT = 400;
	public static final String CHOOSECREATETYPEPAGE_TITLE = "Choose Create Type Page";
	
	// Constants for the Create Book Page window
	public static final int CREATEBOOKPAGE_WIDTH = 600;
	public static final int CREATEBOOKPAGE_HEIGHT = 550;
	public static final String CREATEBOOKPAGE_TITLE = "Create Book Page";
	
	// Constants for the Create DVD Page window
	public static final int CREATEDVDPAGE_WIDTH = 600;
	public static final int CREATEDVDPAGE_HEIGHT = 500;
	public static final String CREATEDVDPAGE_TITLE = "Create DVD Page";
	
	// Constants for the Create Laptop Page window
	public static final int CREATELAPTOPPAGE_WIDTH = 600;
	public static final int CREATELAPTOPPAGE_HEIGHT = 400;
	public static final String CREATELAPTOPPAGE_TITLE = "Create Laptop Page";
	
	// Constants for the Choose Edit Type Page window
	public static final int CHOOSEEDITTYPEPAGE_WIDTH = 600;
	public static final int CHOOSEEDITTYPEPAGE_HEIGHT = 400;
	public static final String CHOOSEEDITTYPEPAGE_TITLE = "Choose Edit Type Page";
	
	// Constants for the Edit Book Page window
	public static final int EDITBOOKPAGE_WIDTH = 600;
	public static final int EDITBOOKPAGE_HEIGHT = 300;
	public static final String EDITBOOKPAGE_TITLE = "Edit Book Page";
	
	// Constants for the Edit Book Page window
	public static final int EDITDVDPAGE_WIDTH = 600;
	public static final int EDITDVDPAGE_HEIGHT = 300;
	public static final String EDITDVDPAGE_TITLE = "Edit Book Page";
	
	// Constants for the Edit Laptop Page window
	public static final int EDITLAPTOPPAGE_WIDTH = 600;
	public static final int EDITLAPTOPPAGE_HEIGHT = 250;
	public static final String EDITLAPTOPPAGE_TITLE = "Edit Laptop Page";
	
	// Constants for the Loan Copy Page window
	public static final int LOANCOPYPAGE_WIDTH = 600;
	public static final int LOANCOPYPAGE_HEIGHT = 300;
	public static final String LOANCOPYPAGE_TITLE = "Loan Copy Page";
	
	// Constants for the Recieve Return Page window
	public static final int RECIEVERETURNPAGE_WIDTH = 600;
	public static final int RECIEVERETURNPAGE_HEIGHT = 300;
	public static final String RECIEVERETURNPAGE_TITLE = "Recieve Return Page";
	
	// Constants for the Message Page window
	public static final int MESSAGEPAGE_WIDTH = 700;
	public static final int MESSAGEPAGE_HEIGHT = 400;
	public static final String MESSAGEPAGE_TITLE = "Message Page";
	
	// Constants for the Choose Avatar Page window
	public static final int CHOOSEAVATARPAGE_WIDTH = 600;
	public static final int CHOOSEAVATARPAGE_HEIGHT = 350;
	public static final String CHOOSEAVATARPAGE_TITLE = "Message Page";
				
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
		Resource resource1 = new Resource("TLOTR", 2001, null, 3);
		User user1 = new User("user1", "user 1", 05454645, 56, "Bay Campus", "SA1 8PP", null);
		User user2 = new User("user2", "user 1", 05454645, 56, "Bay Campus", "SA1 8PP", null);
		Librarian lib1 = new Librarian("lib1", "lib 1", 54656597, 65, "Singleton Campus", "SA1 4FS", null, "24/07");
		Librarian.getUsersList().add(user1);
		Librarian.getUsersList().add(user2);
		Librarian.getLibrarianList().add(lib1);
		//user1.requestItem(resource1);
		//user1.requestReturn(resource1.getCopies().get(0));
		SearchBrowse.getResources().add(resource1);		
		Librarian.loanACopy("user2", "TLOTR");
		Librarian.loanACopy("user1", "TLOTR");
		Librarian.loanACopy("user1", "TLOTR");
		//Librarian.loanACopy("user1", "TLOTR");
		//Librarian.loanACopy("user1", "TLOTR");
		launch(args);
	}
}
