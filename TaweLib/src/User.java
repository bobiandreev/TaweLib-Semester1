import java.util.ArrayList;

import javafx.scene.image.Image;

public class User {

	private String username; 
	private String name; 
	private int mobileNumber; 
	private String address; 
	private Image profilePic;
	private ArrayList<Copy> requestedItems = new ArrayList<>();
	private ArrayList<Copy> borrowedItems = new ArrayList<>();
	
	public User(String username, String name, int mobileNumber, String address, Image profilePic) {
		this.username = username;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.profilePic = profilePic;
	}

	public Image getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Image profilePic) {
		this.profilePic = profilePic;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUserame(String username) {
		this.username = username;
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
	
	public void requestItem(Resource item) {
		requestedItems.add(Copy.borrowCopy(item));
	}
}
