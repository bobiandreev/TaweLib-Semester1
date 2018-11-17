public class User {
	
	protected String userName; // create a userName 
	protected String name; // the name of the user
	protected int mobileNumber; // create a mobile number
	protected String address; // address of the user
	// profile image

	public User(String userName, String name, int mobileNumber, String address) {
		this.userName = userName;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//setProfileImage (setter)
	
}
