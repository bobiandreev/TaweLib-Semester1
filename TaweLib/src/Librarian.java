import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class creates an object for librarian which is a type of user
 * 
 * @author Kyriacos
 * @version 1.0.0
 *
 */
public class Librarian extends User {

	private String employmentDate;
	private static int staffNumber = 0;
	private int currentStaffNumber;
	public static ArrayList<User> usersList = new ArrayList<>();
	private static ArrayList<Librarian> librarianList = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);

	public Librarian(String username, String name, String mobileNumber, String houseNumber, String streetName,
			String postcode, String profilePic, String employmentDate) {
		super(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic);
		this.employmentDate = employmentDate;
		staffNumber++;
		currentStaffNumber = staffNumber;
		librarianList.add(this);
	}

	/**
	 * @return Returns when the librarian was employed
	 */
	public String getEmploymentDate() {
		return employmentDate;
	}

	/**
	 * @param employmentDate
	 *            This sets the date of employment
	 */
	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	/**
	 * @return List of all librarians
	 */
	public static ArrayList<Librarian> getLibrarianList() {
		return librarianList;
	}

	/**
	 * @return Returns the staff number of the librarian
	 */
	public int getStaffNumber() {
		return staffNumber;
	}

	/**
	 * @param user
	 *            adds a user variable to the list of users
	 */
	public static void addUser(User user) {
		// this will be done with read lines
		usersList.add(user);
	}

	/**
	 * @param username
	 *            checks if username is valid
	 * @return
	 */
	public static boolean checkUserName(String username) {
		for (int i = 0; i < usersList.size(); i++) {
			if (username.equals(usersList.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Class for creating a new librarian object
	 */
	public void addLibrarian() {
		boolean flag = false;
		String username = "";
		do {
			Scanner in = new Scanner(System.in);
			username = in.nextLine();
			flag = checkLibrarianName(username);
		} while (flag);
		String name = in.nextLine();
		String mobileNumber = in.nextLine();
		String houseNumber = in.nextLine();
		String streetName = in.nextLine();
		String postcode = in.nextLine();
		String profilePic = null; // allow the librarian to choose an image
		in.close();
		librarianList.add(
				new Librarian(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic, postcode));
	}

	/**
	 * @param username
	 *            for storing username
	 * @return returns boolean if username exists inside of the librarian list
	 */
	private boolean checkLibrarianName(String username) {
		for (int i = 0; i < librarianList.size(); i++) {
			if (username.equals(librarianList.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return returns list of users
	 */
	public static ArrayList<User> getUsersList() {
		return usersList;
	}

	/**
	 * @param username
	 *            for storing username
	 * @param title
	 *            title of the user
	 */
	public static void loanACopy(String username, String title) {
		User curUser = null;
		for (User user : usersList) {
			if (user.getUsername().equals(username)) {
				curUser = user;
			}
		}
		if (curUser.getBalance() == 0) {
			Resource curResource = null;
			for (Resource resource : SearchBrowse.getResources()) {
				if (resource.getTitle().equalsIgnoreCase(title)) {
					curResource = resource;
				}
			}
			if (curResource != null) {
				Copy curCopy = Copy.checkCopy(curResource);
				if (curCopy != null) {
					curUser.getBorrowedItems().add(curCopy); // adds to borrowed items list in user
					curCopy.borrow(); // sets the boolean borrow in copy to true
					curCopy.setRequestedBy(null);
					curCopy.setDateRequested(null);
					curCopy.setReservedFor(null);
					curCopy.setReserved(false);
					curCopy.setBorrowedBy(curUser); // sets the borrower of the copy to user
					curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
					curCopy.removeRequest(); // sets the boolean request in copy to false
					curCopy.setBorrowHistory();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText("Great");
					alert.setContentText(
							curUser.getName().toString() + " has been given " + curResource.getTitle().toString());
					alert.showAndWait();
					// System.out.println("a");
				} else {
					curResource.getWaitingList().add(curUser);
					SearchBrowse.reserved(curResource);
					curResource.getWaitingList().remove(curUser);
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setHeaderText("No free copies at the moment!");
					alert1.setContentText("There were no free copies at the moment. You have been added"
							+ "to the waiting list and a copy has been reserved for you. You will receive a message"
							+ " when a copy is free.");
					alert1.showAndWait();
				}
			} else {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setHeaderText("Error!");
				alert2.setContentText("One of the inputs is wrong! Please re enter!");
				alert2.showAndWait();
			}

		} else {
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setHeaderText("Error!");
			alert3.setContentText(curUser.getUsername() + " cannot borrow " + "anything until he repays his fine.");
			alert3.showAndWait();

		}

	}

	/**
	 * @param username
	 *            for storing the username of the user
	 * @param title
	 *            for storing the title of the user
	 */
	public static void receiveReturn(String username, String title) {
		User curUser = null;
		for (User user : usersList) {
			if (user.getUsername().equals(username)) {
				curUser = user;
			}
		}

		Copy curCopy = null;
		for (Copy copy : curUser.getBorrowedItems()) {
			if (copy.getResource().getTitle().equalsIgnoreCase(title)) {
				curCopy = copy;
			}
		}
		if (curCopy != null) {
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setReturnHistory();
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
			curUser.getReturnRequests().remove(curCopy); // removes copy from returnRequests list in curUser
			curUser.getBorrowedItems().remove(curCopy);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Great");
			alert.setContentText(
					curUser.getName().toString() + " has been returned " + curCopy.getResource().getTitle().toString());
			alert.showAndWait();
			if (curCopy.getIsReserved()) {
				curCopy.getReservedFor().copyNowAvailable(curCopy);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error!");
			alert.setContentText("One of the inputs is wrong! Please re enter!");
			alert.showAndWait();
		}
	}

	/**
	 * example method
	 */
	public static void approveBorrow(boolean flag, Copy curCopy) {
		User curUser = curCopy.getRequestedBy();
		if (curUser.getBalance() == 0) {
			if (flag /* approved */) {
				curUser.getBorrowedItems().add(curCopy); // adds to borrowed items list in curUser
				curCopy.borrow(); // sets the boolean borrow in copy to truecurCopy.setRequestedBy(null);
				curCopy.setDateRequested(null);
				curCopy.setReservedFor(null);
				curCopy.setReserved(false);
				curCopy.setRequestedBy(null);
				curCopy.setBorrowedBy(curUser); // sets the borrower of the copy to curUser
				curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
				curCopy.removeRequest(); // sets the boolean request in copy to false
				curUser.getRequestedItems().remove(0); // removes the copy from requested items list in curUser
				curCopy.setBorrowHistory();
			} else /* not approved */ {
				curCopy.removeRequest();
				curUser.getRequestedItems().remove(0);
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Cannot Borrow");
			alert.setContentText(curUser.getUsername() + "cannot borrow " + "anything until he repays his fine.");
			alert.showAndWait();
		}

	}

	/**
	 * example method
	 */
	public static void approveReturn(boolean flag, Copy curCopy) {
		User curUser = curCopy.getBorrowedBy();

		if (flag /* approved */) {
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setReturnHistory();
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
			curUser.getReturnRequests().remove(curCopy); // removes copy from returnRequests list in curUser
			curUser.getBorrowedItems().remove(curCopy); // removes copy from borrowedItems list in curUser
			if (curCopy.getIsReserved()) {
				curCopy.getReservedFor().copyNowAvailable(curCopy);
			}
		} else { // not approved
			curCopy.setDateRequestReturn(null);
			curUser.getReturnRequests().remove(0);
		}

	}

}
