import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Librarian extends User {

	private String employmentDate;
	private static int staffNumber = 0;
	private static ArrayList<User> usersList = new ArrayList<>();
	private static ArrayList<Librarian> librarianList = new ArrayList<>();
	private Scanner in = new Scanner(System.in);

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
		librarianList.add(new Librarian(username, name, mobileNumber, houseNumber, streetName, postcode, profilePic, postcode));
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

	/**
	 * example method
	 */
	public static void approveBorrow(boolean flag) {
		for (User user : usersList) {
			if (user.getBalance() == 0) {
				System.out.println(user.getName() + " has requested to borrow: ");

				for (int i = 0; i < user.getRequestedItems().size(); i++) {
					System.out.println(user.getRequestedItems().get(i));
				}
				System.out.println();
				while (!user.getRequestedItems().isEmpty()) {
					Copy currentCopy = user.getRequestedItems().get(0);
					System.out.println("Do you approve: " + currentCopy + "?:	true/false");

					if (flag /* approved */) {
						user.getBorrowedItems().add(currentCopy); // adds to borrowed items list in user
						currentCopy.borrow(); // sets the boolean borrow in copy to true
						currentCopy.setRequestedBy(null);
						currentCopy.setBorrowedBy(user); // sets the borrower of the copy to user
						currentCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
						currentCopy.removeRequest(); // sets the boolean request in copy to false
						user.getRequestedItems().remove(0); // removes the copy from requested items list in user
					} else /* not approved */ {
						currentCopy.removeRequest();
						user.getRequestedItems().remove(0);
					}
				}
			} else {
				System.out.println(user.getUsername() + "cannot borrow " + "anything until he repays his fine.");
			}

		}
	}

	public void loanACopy(String username, String title) {
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
			Copy curCopy = Copy.checkCopy(curResource);
			if (curResource != null) {
				if (curCopy != null) {
					curUser.getBorrowedItems().add(curCopy); // adds to borrowed items list in user
					curCopy.borrow(); // sets the boolean borrow in copy to true
					curCopy.setRequestedBy(null);
					curCopy.setBorrowedBy(curUser); // sets the borrower of the copy to user
					curCopy.setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
					curCopy.removeRequest(); // sets the boolean request in copy to false
				} else {
					curResource.getWaitingList().add(curUser);
					SearchBrowse.reserved(curResource);
				}
			} else {
				System.out.println("One of the inputs is wrong. Please re enter.");
				username = in.next();
				title = in.next();
				loanACopy(username, title);
			}

		} else {
			System.out.println(curUser.getUsername() + "cannot borrow " + "anything until he repays his fine.");
		}

	}

	public void receiveReturn(String username, String title) {
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
			checkOverdue(curUser, curCopy);
			curCopy.returnCopy(); // sets boolean isBorrowed in copy to false
			curCopy.setDateReturned(Copy.getDateNow());
			curCopy.setCopyHistory();
			curCopy.setDateRequestReturn(null);
			curCopy.setDateBorrowed(null);
			curCopy.setBorrowedBy(null);
		} else {
			System.out.println("One of the inputs is wrong. Please re enter.");
			username = in.next();
			title = in.next();
			receiveReturn(username, title);
		}
	}

	/**
	 * example method
	 */
	public static void approveReturn(boolean flag) {
		for (User user : usersList) {
			System.out.println(user.getName() + " has requested to return:");
			for (int i = 0; i < user.getReturnRequests().size(); i++) {
				System.out.println(user.getReturnRequests().get(i));
			}
			System.out.println();
			while (!user.getReturnRequests().isEmpty()) {
				Copy currentCopy = user.getReturnRequests().get(0);
				System.out.println("Do you approve: " + currentCopy + ("?	true/false"));
				
				if (flag /* approved */) {
					checkOverdue(user, currentCopy);
					currentCopy.returnCopy(); // sets boolean isBorrowed in copy to false
					currentCopy.setDateReturned(Copy.getDateNow());
					currentCopy.setCopyHistory();
					currentCopy.setDateRequestReturn(null);
					currentCopy.setDateBorrowed(null);
					currentCopy.setBorrowedBy(null);
					user.getReturnRequests().remove(0); // removes copy from returnRequests list in user
					user.getBorrowedItems().remove(0); // removes copy from borrowedItems list in user
				} else { // not approved
					currentCopy.setDateRequestReturn(null);
					user.getReturnRequests().remove(0);
				}
			}
		}
	}

	private static void checkOverdue(User user, Copy copy) {
		if (copy.getDueDate() != null) {
			String dueDate = copy.sdf.format(copy.getDueDate()); // need to change this and the next line
			String currentDate = copy.sdf.format(Copy.getDateNow());
			if (!dueDate.equals(currentDate)) {
				Fine fine = new Fine(copy.getResource(), dueDate, currentDate);
				System.out.println(user.getUsername() + "has to pay " + fine.getCurrentFine() + " for overdue item.");
			}
		}
	}
}
