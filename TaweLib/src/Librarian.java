import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class creates an object for librarian which is a type of user
 * 
 * @author Kyriacos and Boris
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

	/**
	 * Constructor method for a librarian.
	 * 
	 * @param username
	 *            Librarians username
	 * @param name
	 *            Librarians full name
	 * @param mobileNumber
	 *            Librarians mobile number
	 * @param houseNumber
	 *            Librarians house number
	 * @param streetName
	 *            Librarians streets name
	 * @param postcode
	 *            Librarians postcode
	 * @param profilePic
	 *            Librarians profile picture
	 * @param employmentDate
	 *            Librarians employment start date
	 */
	public Librarian(String username, String name, String mobileNumber,
			String houseNumber, String streetName, String postcode,
			String profilePic, String employmentDate) {
		super(username, name, mobileNumber, houseNumber, streetName, postcode,
				profilePic);
		this.employmentDate = employmentDate;
		staffNumber++;
		currentStaffNumber = staffNumber;
		librarianList.add(this);
	}

	/**
	 * Getter method for the librarian emplyment date
	 * 
	 * @return Returns when the librarian was employed
	 */
	public String getEmploymentDate() {
		return employmentDate;
	}

	/**
	 * Setter method for the librarians employment date
	 * 
	 * @param employmentDate
	 *            This sets the date of employment
	 */
	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	/**
	 * Getter method for the list of all librarians
	 * 
	 * @return List of all librarians
	 */
	public static ArrayList<Librarian> getLibrarianList() {
		return librarianList;
	}

	/**
	 * Getter method for the staff number of the librarian.
	 * 
	 * @return Returns the staff number of the librarian
	 */
	public int getStaffNumber() {
		return staffNumber;
	}

	/**
	 * This method adds a user to the users list
	 * 
	 * @param user
	 *            a User object
	 */
	public static void addUser(User user) {
		// this will be done with read lines
		usersList.add(user);
	}

	/**
	 * This method checks if the username is already taken
	 * 
	 * @param username
	 *            String username of the user
	 * @return True if the username is taken false if it isnt
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
	 * This method checks if the librarian username is taken
	 * 
	 * @param username
	 *            string username of the librarian
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
	 * Getter method for the user list
	 * 
	 * @return returns list of users
	 */
	public static ArrayList<User> getUsersList() {
		return usersList;
	}

	/**
	 * This method allows librarians to loan copies to users. First it checks if
	 * the username and the name of item have been entered properly and exist in
	 * the database. Then it checks if the user has any outstanding fines. If
	 * there are any the user is not allowed to borrow anything. An additional
	 * check is carried out if the resource requested has a free copy which can
	 * be borrowed. If there is it automatically gets given to the user.
	 * 
	 * @param username
	 *            username of the user requesting to borrow
	 * @param title
	 *            title of the resource that has been requested
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
					curUser.getBorrowedItems().add(curCopy); // adds to borrowed
																// items list in
																// user
					curCopy.borrow(); // sets the boolean borrow in copy to true
					curCopy.setRequestedBy(null);
					curCopy.setDateRequested(null);
					curCopy.setReservedFor(null);
					curCopy.setReserved(false);
					curCopy.setBorrowedBy(curUser); // sets the borrower of the
													// copy to user
					curCopy.setDateBorrowed(Copy.getDateNow()); // sets date
																// when copy is
																// taken
					curCopy.removeRequest(); // sets the boolean request in copy
												// to false
					curCopy.setBorrowHistory();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText("Great");
					alert.setContentText(
							curUser.getName().toString() + " has been given "
									+ curResource.getTitle().toString());
					alert.showAndWait();
					// System.out.println("a");
				} else {
					curResource.getWaitingList().add(curUser);
					SearchBrowse.reserved(curResource);
					curResource.getWaitingList().remove(curUser);
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setHeaderText("No free copies at the moment!");
					alert1.setContentText(
							"There were no free copies at the moment. You have been added"
									+ "to the waiting list and a copy has been reserved for you. You will receive a message"
									+ " when a copy is free.");
					alert1.showAndWait();
				}
			} else {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setHeaderText("Error!");
				alert2.setContentText(
						"One of the inputs is wrong! Please re enter!");
				alert2.showAndWait();
			}

		} else {
			Alert alert3 = new Alert(AlertType.ERROR);
			alert3.setHeaderText("Error!");
			alert3.setContentText(curUser.getUsername() + " cannot borrow "
					+ "anything until he repays his fine.");
			alert3.showAndWait();

		}

	}

	/**
	 * This method allows the librarian to mark a copy as received then the user
	 * returns it. Checks are carried out if such user and resource exist in the
	 * database and if the user currently has borrowed this copy. If everything
	 * is correct the item is marked as returned.
	 * 
	 * @param username
	 *            username of the user requesting to return
	 * @param title
	 *            title of the item they wishes to return
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
			curCopy.removeRequest();
			curUser.getReturnRequests().remove(curCopy); // removes copy from
															// returnRequests
															// list in curUser
			curUser.getBorrowedItems().remove(curCopy);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Great");
			alert.setContentText(
					curUser.getName().toString() + " has been returned "
							+ curCopy.getResource().getTitle().toString());
			alert.showAndWait();
			if (curCopy.getIsReserved()) {
				curCopy.getReservedFor().copyNowAvailable(curCopy);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error!");
			alert.setContentText(
					"One of the inputs is wrong! Please re enter!");
			alert.showAndWait();
		}
	}

	/**
	 * This method approves or does not approve a selected user borrow request
	 * from the gui based on the button clicked in the gui.
	 * 
	 * @param flag
	 *            A boolean which decides if the request should be approved or
	 *            not. It is set by clicking one of the buttons in the gui.
	 * @param curCopy
	 *            The item that the user has requested to borrow.
	 */
	public static void approveBorrow(boolean flag, Copy curCopy) {
		User curUser = curCopy.getRequestedBy();
		if (curUser.getBalance() == 0) {
			if (flag /* approved */) {
				curUser.getBorrowedItems().add(curCopy); // adds to borrowed
															// items list in
															// curUser
				curCopy.borrow(); // sets the boolean borrow in copy to
									// truecurCopy.setRequestedBy(null);
				curCopy.setDateRequested(null);
				curCopy.setReservedFor(null);
				curCopy.setReserved(false);
				curCopy.setRequestedBy(null);
				curCopy.setBorrowedBy(curUser); // sets the borrower of the copy
												// to curUser
				curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when
															// copy is taken
				curCopy.removeRequest(); // sets the boolean request in copy to
											// false
				curUser.getRequestedItems().remove(0); // removes the copy from
														// requested items list
														// in curUser
				curCopy.setBorrowHistory();
			} else /* not approved */ {
				curCopy.removeRequest();
				curUser.getRequestedItems().remove(0);
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Cannot Borrow");
			alert.setContentText(curUser.getUsername() + "cannot borrow "
					+ "anything until he repays his fine.");
			alert.showAndWait();
		}

	}

	/**
	 * This method allows the librarian to approve or not approve a return
	 * request for a user based on a button clicked in the gui.
	 * 
	 * @param flag
	 *            Boolean which decides if the the request if approved or not.
	 *            Set by clicking on of the buttons in the gui.
	 * @param curCopy
	 *            Copy that the user wishes to return.
	 */
	public static void approveReturn(boolean flag, Copy curCopy) {
		User curUser = curCopy.getBorrowedBy();

		if (flag /* approved */) {
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setReturnHistory();
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.removeRequest();
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
			curUser.getReturnRequests().remove(curCopy); // removes copy from
															// returnRequests
															// list in curUser
			curUser.getBorrowedItems().remove(curCopy); // removes copy from
														// borrowedItems list in
														// curUser
			if (curCopy.getIsReserved()) {
				curCopy.getReservedFor().copyNowAvailable(curCopy);
			}
		} else { // not approved
			curCopy.setDateRequestReturn(null);
			curUser.getReturnRequests().remove(0);
		}

	}

}
