import java.util.ArrayList;

import javafx.scene.image.Image;

public class User {

	private String username;
	private String name;
	private int mobileNumber;
	private int houseNumber;
	private String streetName;
	private String postcode;
	private Image profilePic;
	private ArrayList<Copy> requestedItems = new ArrayList<>();
	private ArrayList<Copy> borrowedItems = new ArrayList<>();
	private ArrayList<Copy> returnRequests = new ArrayList<>();
	private ArrayList<Copy> itemsToReturn = new ArrayList<>();

	public User(String username, String name, int mobileNumber, int houseNumber, String address, String postcode,
			Image profilePic) {
		this.username = username;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.houseNumber = houseNumber;
		this.streetName = address;
		this.postcode = postcode;
		this.profilePic = profilePic;
	}

	public Image getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Image profilePic) {
		this.profilePic = profilePic;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreetAddress() {
		return streetName;
	}

	public void setAddress(String streetName) {
		this.streetName = streetName;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public ArrayList<Copy> getReturnRequests() {
		return returnRequests;
	}
	
	public String getFineHistory() {
		String history = "";
		int index = 0;
		while (index != itemsToReturn.size()) {
			Copy curCopy = itemsToReturn.get(index);
			String dueDate = curCopy.sdf.format(curCopy.getDueDate());
			String currentDate = curCopy.sdf.format(Copy.getDateNow());
			Fine fine = new Fine (curCopy.getResource(), dueDate, currentDate);
			history += curCopy.getDueDate() + ", amount due: " + 
					fine.getCurrentFine() + ", copy: " + curCopy.getCopyId() +
					" of " + curCopy.getResource().getTitle() + 
					". Days overdue: " + fine.getDaysOverdue();
			index++;
		}
		return history;
	}

	public ArrayList<Copy> getRequestedItems() {
		return requestedItems;
	}

	public ArrayList<Copy> getBorrowedItems() {
		return borrowedItems;
	}

	public int getHouseNumber() {
		return houseNumber;
	}
	
	public int getBalance() {
		int totalFine = 0;
		int index = 0;
		while (index != itemsToReturn.size()) {
			Copy curCopy = itemsToReturn.get(index);
			String dueDate = curCopy.sdf.format(curCopy.getDueDate());
			String currentDate = curCopy.sdf.format(Copy.getDateNow());
			Fine fine = new Fine (curCopy.getResource(), dueDate, currentDate);
			totalFine += fine.getCurrentFine();
			index++;
		}
		return totalFine;
	}

	public void requestItem(Resource item) {
		Copy freeCopy = Copy.checkCopy(item); // checks if there is a free copy
		if (freeCopy == null) { // if there isnt a free copy user gets added to the waiting list for that
								// resource
			item.addToWaitList(this);
			System.out.println("Unfortunately all the copies are borrowed at the moment. \n"
					+ "You have been added to the waiting list and will "
					+ "receive a notification when a copy is available.");
		} else { // if there is a free copy it gets added to the users requested items list and
					// its variables are set to requested
			freeCopy.requestCopy(this);
			requestedItems.add(freeCopy);
		}
	}
	
	public void displayBorrowedItems(){
		for(int i = 0; i < borrowedItems.size(); i++) {
			System.out.println(borrowedItems.get(i).toString1());
		}
	}

	public void requestReturn(Copy copy) { /* user chooses which copy to return here with the gui */
		returnRequests.add(copy); // adds copy to be returned to the return requests list
		copy.setDateRequestReturn(Copy.getDateNow()); // sets the date when the return was requested
	}

}
