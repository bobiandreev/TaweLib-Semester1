public class Librarian extends User{

	private String employmentDate;
	private int staffNumber;
	
	public Librarian(String userName, String name, int mobileNumber, String address, String employmentDate, int staffNumber) {
		super(userName, name, mobileNumber, address);
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
