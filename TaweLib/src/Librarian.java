import javafx.scene.image.Image;

public class Librarian extends User{

	private String employmentDate;
	private int staffNumber;
	
	public Librarian(String username, String name, int mobileNumber, String address, Image profilePic, String employmentDate, int staffNumber) {
		super(username, name, mobileNumber, address, profilePic);
		this.employmentDate = employmentDate;
		this.staffNumber = staffNumber;
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

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

}
