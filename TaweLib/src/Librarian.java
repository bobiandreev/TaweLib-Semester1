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
	private ArrayList<User> users = new ArrayList<>();

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

	public User addUser() {
		// this will be done with read lines
		Scanner in = new Scanner(System.in);
		String username = in.nextLine();
		String name = in.nextLine();
		int phoneNumber = in.nextInt();
		int houseNumber = in.nextInt();
		String streetName = in.nextLine();
		String postcode = in.nextLine();
		Image profilePic = null; // allow the librarian to choose an image
		return new User(username, name, phoneNumber, houseNumber, streetName, postcode, profilePic);
	}

	public void approveBorrow() {
		for (User user : users) {
			System.out.println(user.getName() + " has requested to borrow: ");
			for (int i = 0; i < user.getRequestedItems().size(); i++) {
				System.out.println(user.getRequestedItems().get(i));

				if (true /* approved */) {
					user.getBorrowedItems().add(user.getRequestedItems().get(i));
					user.getRequestedItems().remove(i);
				} else /* not approved */ {
					user.getRequestedItems().remove(i);
				}
			}
		}
	}

	public void approveReturn() {
		for (User user : users) {
			System.out.println(user.getName() + " has requested to return:");
			for (int i = 0; i < user.getReturnRequests().size(); i++) {
				System.out.println(user.getReturnRequests().get(i));

				if (true /* approved */) {
					user.getReturnRequests().remove(i);
					user.getBorrowedItems().remove(i);
				} else { // not approved
					user.getReturnRequests().remove(i);
				}
			}
		}
	}
}
