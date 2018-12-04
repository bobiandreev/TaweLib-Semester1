import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class Librarian extends User {

	private String employmentDate;
	private static int staffNumber = 0;
	private static ArrayList<User> usersList = new ArrayList<>();
	private static ArrayList<Librarian> librarianList = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);

	public Librarian(String username, String name, int mobileNumber, int houseNumber, String streetName,
			String postcode, BufferedImage profilePic, String employmentDate) {
		super(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic);
		this.employmentDate = employmentDate;
		staffNumber++;
	}

	public String getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}

	public static ArrayList<Librarian> getLibrarianList() {
		return librarianList;
	}

	public int getStaffNumber() {
		return staffNumber;
	}

	public void addUser() {
		// this will be done with read lines
		boolean flag = false;
		String username = "";
		do {
			Scanner in = new Scanner(System.in);
			username = in.nextLine();
			flag = checkUserName(username);
		} while (flag);
		String name = in.nextLine();
		int mobileNumber = in.nextInt();
		int houseNumber = in.nextInt();
		String streetName = in.nextLine();
		String postcode = in.nextLine();
		BufferedImage profilePic = null; // allow the librarian to choose an image
		in.close();
		usersList.add(new User(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic));
	}

	private boolean checkUserName(String username) {
		for (int i = 0; i < usersList.size(); i++) {
			if (username.equals(usersList.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}

	public void addLibrarian() {
		boolean flag = false;
		String username = "";
		do {
			Scanner in = new Scanner(System.in);
			username = in.nextLine();
			flag = checkLibrarianName(username);
		} while (flag);
		String name = in.nextLine();
		int mobileNumber = in.nextInt();
		int houseNumber = in.nextInt();
		String streetName = in.nextLine();
		String postcode = in.nextLine();
		BufferedImage profilePic = null; // allow the librarian to choose an image
		in.close();
		librarianList.add(
				new Librarian(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic, postcode));
	}

	private boolean checkLibrarianName(String username) {
		for (int i = 0; i < librarianList.size(); i++) {
			if (username.equals(librarianList.get(i).getUsername())) {
				return true;
			}
		}
		return false;
	}

	public void addBook() {
		String title = in.next();
		int year = in.nextInt();
		BufferedImage thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String author = in.next();
		String publisher = in.next();
		SearchBrowse.addResource(new Book(title, year, thumbnailImage, numOfCopies, author, publisher));
	}

	public void addDVD() {
		String title = in.next();
		int year = in.nextInt();
		BufferedImage thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String director = in.next();
		int runtime = in.nextInt();
		SearchBrowse.addResource(new DVD(title, year, thumbnailImage, numOfCopies, director, runtime));
	}

	public static ArrayList<User> getUsersList() {
		return usersList;
	}

	public void addLaptopComputer() {
		String title = in.next();
		int year = in.nextInt();
		BufferedImage thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String manufacturer = in.next();
		String model = in.next();
		String OS = in.next();
		SearchBrowse.addResource(new LaptopComputer(title, year, thumbnailImage, numOfCopies, manufacturer, model, OS));
	}

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
				if (resource.getTitle().equals(title)) {
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
					curCopy.setBorrowedBy(curUser); // sets the borrower of the copy to user
					curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
					curCopy.removeRequest(); // sets the boolean request in copy to false
					//Alert alert = new Alert(AlertType.CONFIRMATION);
					//alert.setHeaderText("Great");
					//alert.setContentText(
					//		curUser.getName().toString() + " has been given " + curResource.getTitle().toString());
					//alert.showAndWait();
					System.out.println("a");
				} else {
					curResource.getWaitingList().add(curUser);
					SearchBrowse.reserved(curResource);
					curResource.getWaitingList().remove(curUser);
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Error!");
				alert.setContentText("One of the inputs is wrong! Please re enter!");
				alert.showAndWait();
			}

		} else {
			System.out.println(curUser.getUsername() + "cannot borrow " + "anything until he repays his fine.");
		}

	}

	public static void receiveReturn(String username, String title) {
		User curUser = null;
		for (User user : usersList) {
			if (user.getUsername().equals(username)) {
				curUser = user;
			}
		}

		Copy curCopy = null;
		for (Copy copy : curUser.getBorrowedItems()) {
			if (copy.getResource().getTitle().equals(title)) {
				curCopy = copy;
			}
		}
		if (curCopy != null) {
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setCopyHistory();
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Great");
			alert.setContentText(
					curUser.getName().toString() + " has been returned " + curCopy.getResource().getTitle().toString());
			alert.showAndWait();
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
				curCopy.borrow(); // sets the boolean borrow in copy to true
				curCopy.setRequestedBy(null);
				curCopy.setBorrowedBy(curUser); // sets the borrower of the copy to curUser
				curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
				curCopy.removeRequest(); // sets the boolean request in copy to false
				curUser.getRequestedItems().remove(0); // removes the copy from requested items list in curUser
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
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setCopyHistory();
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
			curUser.getReturnRequests().remove(0); // removes copy from returnRequests list in curUser
			curUser.getBorrowedItems().remove(0); // removes copy from borrowedItems list in curUser
		} else { // not approved
			curCopy.setDateRequestReturn(null);
			curUser.getReturnRequests().remove(0);
		}

	}

}
