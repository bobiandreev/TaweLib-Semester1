import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Librarian extends User {

	private String employmentDate;
	private static int staffNumber = 0;
	public static ArrayList<User> usersList = new ArrayList<>();
	private static ArrayList<Librarian> librarianList = new ArrayList<>();
	private Scanner in = new Scanner(System.in);

	public Librarian(String username, String name, int mobileNumber, int houseNumber, String streetName,
			String postcode, Image profilePic, String employmentDate) {
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

	public int getStaffNumber() {
		return staffNumber;
	}

	public void addUser() {
		// this will be done with read lines
		Scanner in = new Scanner(System.in);
		String username = in.nextLine();
		String name = in.nextLine();
		int phoneNumber = in.nextInt();
		int houseNumber = in.nextInt();
		String streetName = in.nextLine();
		String postcode = in.nextLine();
		Image profilePic = null; // allow the librarian to choose an image
		in.close();
		usersList.add(new User(username, name, phoneNumber, houseNumber, streetName, postcode, profilePic));
	}

	public void addBook() {
		String title = in.next();
		int year = in.nextInt();
		Image thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String author = in.next();
		String publisher = in.next();
		SearchBrowse.addResource(new Book(title, year, thumbnailImage, numOfCopies, author, publisher));
	}

	public void addDVD() {
		String title = in.next();
		int year = in.nextInt();
		Image thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String director = in.next();
		int runtime = in.nextInt();
		SearchBrowse.addResource(new DVD(title, year, thumbnailImage, numOfCopies, director, runtime));
	}

	public void addLaptopComputer() {
		String title = in.next();
		int year = in.nextInt();
		Image thumbnailImage = null;
		int numOfCopies = in.nextInt();
		String manufacturer = in.next();
		String model = in.next();
		String OS = in.next();
		SearchBrowse.addResource(new LaptopComputer(title, year, thumbnailImage, numOfCopies, manufacturer, model, OS));
	}

	/**
	 * example method
	 */
	public void approveBorrow() {
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
					boolean flag = in.nextBoolean();

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

	/**
	 * example method
	 */
	public void approveReturn() {
		for (User user : usersList) {
			System.out.println(user.getName() + " has requested to return:");
			for (int i = 0; i < user.getReturnRequests().size(); i++) {
				System.out.println(user.getReturnRequests().get(i));
			}
			System.out.println();
			while (!user.getReturnRequests().isEmpty()) {
				Copy currentCopy = user.getReturnRequests().get(0);
				System.out.println("Do you approve: " + currentCopy + ("?	true/false"));
				boolean flag = in.nextBoolean();

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

	private void checkOverdue(User user, Copy copy) {
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
