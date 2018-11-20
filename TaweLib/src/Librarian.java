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

	public Librarian(String username, String name, int mobileNumber, String address, Image profilePic,
			String employmentDate) {
		super(username, name, mobileNumber, address, profilePic);
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
}
