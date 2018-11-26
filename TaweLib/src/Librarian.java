import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Librarian extends User {
	// TODO create 2 methods called approve borrow and approve return
	// Librarian should have the option to look through all of the requests of all
	// users
	// so there should be nested loops with a list of all users and the their list
	// of requests for the librarian
	// to approve

	private String employmentDate;
	private static int staffNumber = 0;
	public static ArrayList<User> usersList = new ArrayList<>();
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

	/**
	 * example method
	 */
	public void approveBorrow() {
		for (User user : usersList) {
			System.out.println(user.getName() + " has requested to borrow: ");

			for (int i = 0; i < user.getRequestedItems().size(); i++) {
				System.out.println(user.getRequestedItems().get(i));
			}
			System.out.println();
			while (!user.getRequestedItems().isEmpty()) {

				System.out.println("Do you approve: " + user.getRequestedItems().get(0) + "?:	true/false");

				boolean flag = in.nextBoolean();

				if (flag /* approved */) {
					user.getBorrowedItems().add(user.getRequestedItems().get(0)); // adds to borrowed items list in user
					user.getRequestedItems().get(0).borrow(); // sets the boolean borrow in copy to true
					user.getRequestedItems().get(0).setRequestedBy(null);
					user.getRequestedItems().get(0).setBorrowedBy(user); // sets the borrower of the copy to user 
					user.getRequestedItems().get(0).setDateBorrowed(Copy.getDateNow()); // sets date when copy is taken
					user.getRequestedItems().get(0).removeRequest(); // sets the boolean request in copy to false
					user.getRequestedItems().remove(0); // removes the copy from requested items list in user
				} else /* not approved */ {
					user.getRequestedItems().get(0).removeRequest();
					user.getRequestedItems().remove(0);
				}
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
				System.out.println("Do you approve: " + user.getReturnRequests().get(0) + ("?	true/false"));
				boolean flag = in.nextBoolean();


				if (flag /* approved */) {
					checkOverdue(user, user.getReturnRequests().get(0));
					user.getReturnRequests().get(0).isReturned(); // sets boolean isBorrowed in copy to false
					user.getReturnRequests().get(0).setDateReturned(Copy.getDateNow());
					user.getReturnRequests().get(0).setDateRequestReturn(null);
					user.getReturnRequests().get(0).setDateBorrowed(null);
					user.getReturnRequests().get(0).setBorrowedBy(null);
					user.getReturnRequests().remove(0); // removes copy from returnRequests list in user
					user.getBorrowedItems().remove(0); // removes copy from borrowedItems list in user
				} else { // not approved
					user.getReturnRequests().get(0).setDateRequestReturn(null);
					user.getReturnRequests().remove(0);
				}
			}
		}
	}
	
	private void checkOverdue(User user, Copy copy) {
		if (copy.getDueDate() != null) {
			if (copy.getDateRequestReturn() != Copy.getDateNow()) {
				String dueDate = copy.sdf.format(copy.getDueDate());
				String currentDate = copy.sdf.format(Copy.getDateNow());
				Fine fine = new Fine(copy.getResource(), dueDate, currentDate);
				System.out.println(user.getUsername() + "has to pay " + 
						fine.getCurrentFine() + "for overdue item.");
			}
		}
	}
}
