import javafx.scene.image.Image;

public class Librarian extends User{

	private String employmentDate;
	private static int staffNumber = 0;
	
	public Librarian(String username, String name, int mobileNumber, String address, Image profilePic, String employmentDate) {
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
