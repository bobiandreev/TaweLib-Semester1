import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Class that creates a copy object for a resource
 * 
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */
public class Copy {

	private Resource resource;
	private int copyId;
	private boolean isBorrowed = false;
	private boolean isRequested = false;
	private boolean isReserved = false;
	private Date dateRequested;
	private Date dateBorrowed;
	private Date dateRequestReturn;
	private Date dateReturned;
	private User requestedBy;
	private User borrowedBy;
	private User reservedFor;
	public final int loanDuration = 14;
	public final int loanDurationLaptop = 1;
	public final int loanDurationDVD = 2;
	public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date dueDate = null;
	private static Date dateNow;
	private ArrayList<String> copyHistory = new ArrayList<>();

	/**
	 * Constructor for Copy object
	 * 
	 * @param resource This shows a copy of which resource is this object
	 * @param copyId   Sets an ID for the specific copy
	 */
	public Copy(Resource resource, int copyId) {
		this.resource = resource;
		this.copyId = copyId;
	}

	/**
	 * Makes a copy borrowed, by making isBorrowed true.
	 */
	public void borrow() {
		isBorrowed = true;
	}

	/**
	 * Getter method for current Copy's ID.
	 * 
	 * @return the ID of Copy.
	 */
	public int getCopyId() {
		return copyId;
	}

	/**
	 * Setter method for current Copy's ID.
	 * 
	 * @param copyId The new ID.
	 */
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	/**
	 * Getter method of isBorrowed variable.
	 * 
	 * @return true if the Copy is borrowed, otherwise false.
	 */
	public boolean getIsBorrowed() {
		return isBorrowed;
	}

	/**
	 * Getter method of the type of the copy.
	 * 
	 * @return the type of the copy.
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * Getter method of isRequested variable.
	 * 
	 * @return true if the Copy is requested, otherwise false.
	 */
	public boolean getIsRequested() {
		return isRequested;
	}

	/**
	 * Sets the copy as requested.
	 */
	public void request() {
		isRequested = true;
	}

	/**
	 * Removes the copy from requested.
	 */
	public void removeRequest() {
		isRequested = false;
	}

	/**
	 * Sets isBorrowed to false since the copy is returned.
	 */
	public void returnCopy() {
		isBorrowed = false;
	}

	/**
	 * Getter method of the date a User requested this copy.
	 * 
	 * @return the date a copy is being requested.
	 */
	public Date getDateRequested() {
		return dateRequested;
	}

	/**
	 * Setter method of the date a User requested this copy.
	 * 
	 * @param dateRequested The date this copy is requested.
	 */
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	/**
	 * Getter method of the date a User borrowed this copy.
	 * 
	 * @return
	 */
	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	/**
	 * Setter method of the date a User borrowed this copy.
	 * 
	 * @param dateBorrowed The date this copy is borrowed.
	 */
	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	/**
	 * Getter method of the current date.
	 * 
	 * @return the current date and time.
	 */
	public static Date getDateNow() {
		return dateNow = new Date();
	}

	/**
	 * Getter method of the date a User requested to return this copy.
	 * 
	 * @return the date this copy a User has requested to return this copy.
	 */
	public Date getDateRequestReturn() {
		return dateRequestReturn;
	}

	/**
	 * Setter method of the date a User has requested to return this copy.
	 * 
	 * @param dateRequestReturn The date a User has requested to return this copy.
	 */
	public void setDateRequestReturn(Date dateRequestReturn) {
		this.dateRequestReturn = dateRequestReturn;
	}

	/**
	 * Getter of the date this copy was returned.
	 * 
	 * @return the date this copy was returned.
	 */
	public Date getDateReturned() {
		return dateReturned;
	}

	/**
	 * Setter of the date this copy is returned.
	 * 
	 * @param dateReturned The date it is returned.
	 */
	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	/**
	 * Getter method of the User that requested this copy.
	 * 
	 * @return the User requesting this copy.
	 */
	public User getRequestedBy() {
		return requestedBy;
	}

	/**
	 * Setter method of the User that requested this copy.
	 * 
	 * @param requestedBy The User requesting this copy.
	 */
	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	/**
	 * Getter method of the User currently possessing this copy.
	 * 
	 * @return the User currently possessing this copy.
	 */
	public User getBorrowedBy() {
		return borrowedBy;
	}

	/**
	 * Setter method of the User that just got this copy.
	 * 
	 * @param borrowedBy The User that just got this copy.
	 */
	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}

	/**
	 * Getter of the User currently requesting the unavailable copy.
	 * 
	 * @return the User currently requesting this unavailable copy.
	 */
	public User getReservedFor() {
		return reservedFor;
	}

	/**
	 * Setter of the User that wants to request the unavailable copy.
	 * 
	 * @param reservedFor The User that wants to request the unavailable copy.
	 */
	public void setReservedFor(User reservedFor) {
		this.reservedFor = reservedFor;
	}

	/**
	 * Getter of the due date of a copy.
	 * 
	 * @return the date this copy must be returned.
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Setter of the due date of a copy.
	 * 
	 * @return the date this copy must be returned as a String.
	 */
	public String getDueDateString() {
		return sdf.format(dueDate);
	}

	/**
	 * Setter of the due date.
	 */
	public void setDueDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(dateBorrowed);
		c.add(Calendar.DAY_OF_MONTH, loanDuration);
		dueDate = c.getTime();
		System.out.println("Due date: " + sdf.format(dueDate));
	}

	/**
	 * Getter method of getCopyHistory.
	 * 
	 * @return the borrowing history of a copy as an Array of strings.
	 */
	public ArrayList<String> getCopyHistory() {
		return copyHistory;
	}

	/**
	 * Setter method of the borrowing history of a copy.
	 */
	public void setCopyHistory() {
		copyHistory.add("Borrowed by " + getBorrowedBy().getUsername() + " on " + getDateBorrowed()
				+ " and returned by " + getDateReturned());
	}

	/**
	 * Method which allows the user to request a copy which then needs to be
	 * approved by a librarian. Sets isRequested variable to true and sets the
	 * dateRequested to the date now. Also stores which user currently has the copy.
	 */
	public void requestCopy(User user) {
		this.requestedBy = user;
		this.request();
		this.setDateRequested(dateNow);
	}

	/**
	 * Method that goes through all copies to check if there is a free one for a
	 * user to request.
	 * 
	 * @param item The resource for which the user checks if there is a free copy.
	 * @return Null if there are no free copies and the Copy object which is free if
	 *         there is one.
	 */
	public static Copy checkCopy(Resource item) {
		int i = 0;
		while (i < item.getCopies().size() && item.getCopies().get(i).getIsBorrowed()
				|| item.getCopies().get(i).getIsRequested() || item.getCopies().get(i).getIsReserved()) {
			i++;
			if (i == item.getCopies().size()) {
				// adds user to queue of users waiting for this resource
				return null;
			}
		}
		return item.getCopies().get(i);
	}

	/**
	 * Getter method of isReserved variable.
	 * @return true if the copy is reserved for someone else, otherwise false.
	 */
	public boolean getIsReserved() {
		return isReserved;
	}

	/**
	 * Sets the copy as reserved.
	 */
	public void reserve() {
		isReserved = true;
	}

	/**
	 * Makes the copy available for reservation again.
	 */
	public void removeReservation() {
		isReserved = false;
	}
	
	
	
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	@Override
	public String toString() {
		return "Copy number " + this.getCopyId() + " of resource " + this.getResource().getTitle() + ".";
	}

	public String toString1() {
		if (this.getDueDate() == null) {
			return "Copy number " + this.getCopyId() + " of resource " + this.getResource().getTitle()
					+ ". No due date is set for this item";
		} else {
			return "Copy number " + this.getCopyId() + " of resource " + this.getResource().getTitle()
					+ ". This item is due to be returned on: " + sdf.format(this.getDueDate());
		}
	}
}
