import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class User implements Serializable {

	private String username;
	private String name;
	private String mobileNumber;
	private String houseNumber;
	private String streetName;
	private String postcode;
	private String profilePic;
	private double currentFine;
	private ArrayList<Copy> requestedItems = new ArrayList<>();
	private ArrayList<Copy> borrowedItems = new ArrayList<>();
	private ArrayList<Copy> returnRequests = new ArrayList<>();
	private ArrayList<Copy> reservedFor = new ArrayList<>();
	private ArrayList<Copy> itemsToReturn = new ArrayList<>();
	private ArrayList<Date> paymentDates = new ArrayList<>();
	private ArrayList<Double> paymentAmounts = new ArrayList<>();
	private ArrayList<String> messages = new ArrayList<>();
	private ArrayList<String> paymentHistory = new ArrayList<>();
	private ArrayList<String> fineHistory = new ArrayList<>();
	private Scanner in;

	public User(String username, String name, String mobileNumber, String houseNumber, String address, String postcode,
			String image) {
		this.username = username;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.houseNumber = houseNumber;
		this.streetName = address;
		this.postcode = postcode;
		this.profilePic = image;
		Collections.reverse(messages);
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setPaymentAmounts(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNextDouble()) {
			double payment = in.nextDouble();
			paymentAmounts.add(payment);
		}
	}

	public void setPaymentDates(String array) throws ParseException {
		String dateS = "";
		in.useDelimiter(",");
		while (in.hasNext()) {
			dateS = in.next();
		}
		Date date = Copy.dateParser(dateS);
		paymentDates.add(date);
	}

	public void setItemToReturn(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNext()) {
			String rTitle = in.next();
			int cID = in.nextInt();
			itemsToReturn.add(SearchBrowse.findCopy(rTitle, cID));
		}
	}

	public ArrayList<Copy> getItemsToReturn() {
		return itemsToReturn;
	}

	public void setReservedFor(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNext()) {
			String rTitle = in.next();
			int cID = in.nextInt();
			reservedFor.add(SearchBrowse.findCopy(rTitle, cID));
		}
	}

	public ArrayList<Copy> getReservedFor() {
		return reservedFor;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreetAddress() {
		return streetName;
	}

	public void setAddress(String streetName) {
		this.streetName = streetName;
	}

	public void setHouseNumber(String houseNumber) {
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

	public void setReturnRequests(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNext()) {
			String rTitle = in.next();
			int cID = in.nextInt();
			returnRequests.add(SearchBrowse.findCopy(rTitle, cID));
		}
	}

	public ArrayList<Copy> getReturnRequests() {
		return returnRequests;
	}

	public void checkFineHistory() {
		String history = "";
		for (Copy copy : borrowedItems) {
			if (copy.getDueDate() != null) {
				Copy curCopy = copy;
				String dueDate = curCopy.S_D_F.format(curCopy.getDueDate());
				String currentDate = curCopy.S_D_F.format(Copy.getDateNow());
				Fine fine = new Fine(curCopy.getResource(), dueDate, currentDate);
				history += curCopy.getDueDate() + ", amount due: " + fine.getCurrentFine() + ", copy: "
						+ curCopy.getCopyId() + " of " + curCopy.getResource().getTitle() + ". Days overdue: "
						+ fine.getDaysOverdue() + "\n";
				fineHistory.add(history);
			}
		}
	}

	public ArrayList<String> getFineHistory() {
		return fineHistory;
	}

	public void setPaymentHistory(Date paymentDate, double amount) {
		paymentDates.add(paymentDate);
		paymentAmounts.add(amount);
	}

	public ArrayList<String> getPaymentHistory() {
		String history = "";
		for (int index = 0; index < paymentDates.size(); index++) {
			history = paymentAmounts.get(index) + " was paid on " + paymentDates.get(index) + ".\n";
			paymentHistory.add(history);
		}
		return paymentHistory;
	}

	public void setRequestedItems(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNext()) {
			String rTitle = in.next();
			int cID = in.nextInt();
			requestedItems.add(SearchBrowse.findCopy(rTitle, cID));
		}
	}

	public ArrayList<Copy> getRequestedItems() {
		return requestedItems;
	}

	public void setBorrowedItems(String array) {
		in = new Scanner(array);
		in.useDelimiter(",");
		while (in.hasNext()) {
			String rTitle = in.next();
			int cID = in.nextInt();
			borrowedItems.add(SearchBrowse.findCopy(rTitle, cID));
		}
	}

	public ArrayList<Copy> getBorrowedItems() {
		return borrowedItems;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public double getBalance() {
		double totalFine = 0;
		int index = 0;
		while (index != itemsToReturn.size()) {
			Copy curCopy = itemsToReturn.get(index);
			String dueDate = curCopy.S_D_F.format(curCopy.getDueDate());
			String currentDate = curCopy.S_D_F.format(Copy.getDateNow());
			Fine fine = new Fine(curCopy.getResource(), dueDate, currentDate);
			totalFine += fine.getCurrentFine();
			index++;
		}
		currentFine = totalFine;
		return currentFine;
	}

	public void payFine(double payment) {
		currentFine = currentFine - payment;
	}

	public void requestItem(Resource item) {
		Copy freeCopy = Copy.checkCopy(item); // checks if there is a free copy
		if (freeCopy == null) { // if there isnt a free copy user gets added to
								// the waiting list for that
								// resource
			item.addToWaitList(this);
			noCopyAvailable();
			SearchBrowse.reserved(item);
		} else { // if there is a free copy it gets added to the users requested
					// items list and
					// its variables are set to requested
			freeCopy.requestCopy(this);
			freeCopy.setDateRequested(Copy.getDateNow());
			requestedItems.add(freeCopy);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Success!");
			alert.setContentText("You have requested a copy! If no copies are available now "
					+ "one will be reserved for you.\nYou will reveive a message when you can get "
					+ "your reserved copy!");
			alert.showAndWait();
		}
	}

	public void displayBorrowedItems() {
		for (int i = 0; i < borrowedItems.size(); i++) {
			System.out.println(borrowedItems.get(i).toString1());
		}
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void displayMessages() {
		for (int i = 0; i < messages.size(); i++) {
			// System.out.println(messages.get(i));
		}
	}

	public void requestReturn(
			Copy copy) { /*
							 * user chooses which copy to return here with the gui
							 */
		returnRequests.add(copy); // adds copy to be returned to the return
									// requests list
		copy.setDateRequestReturn(Copy.getDateNow()); // sets the date when the
														// return was requested
	}

	public void DueDateMessage(Copy copy) {
		if (copy.getResource() instanceof Book || copy.getResource() instanceof DVD) {
			String messageBook = ("The item you have borrowed: " + copy.getResource().getTitle()
					+ " has been requested by someone else and you have to return it by " + copy.getDueDateString()
					+ " \nor a fine of 2 pounds per day up to a maximum of 25 pounds will start incurring. \n");
			messages.add(messageBook);
		}
		if (copy.getResource() instanceof LaptopComputer) {
			String messageLaptop = ("The item you have borrowed: " + copy.getResource().getTitle()
					+ " has been requested by someone else and you have to return it by " + copy.getDueDateString()
					+ "\nor a fine of 10 pounds per day up to a maximum of 100 pounds will start incurring. \n");
			messages.add(messageLaptop);
		}

	}

	public void noCopyAvailable() {
		String message = ("Unfortunately all the copies are already borrowed, requseted or reserved at the moment. \n"
				+ "You have been added to the waiting list and will "
				+ "receive a notification when a copy is available. \n");
		messages.add(message);
	}

	public void copyNowAvailable(Copy copy) {
		String message = ("The item you have requested: " + copy.getResource().getTitle()
				+ "is now available for you to borrow. \n");
		messages.add(message);
	}

	public void reservedForYou() {
		String message = ("The copy you have requested has been reserved for you. You will receive a message when"
				+ "\nyour copy is available for pick up. \n");
		messages.add(message);
	}
}
