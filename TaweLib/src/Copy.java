import java.text.SimpleDateFormat;
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
	private Date dateRequested;
	private Date dateBorrowed;
	private Date dateRequestReturn;
	private Date dateReturned;
	private User requestedBy;
	private static Date dateNow = new Date();

	/**
	 * Constructor for Copy object
	 * 
	 * @param resource
	 *            This shows a copy of which resource is this object
	 * @param copyId
	 *            Sets an ID for the specific copy
	 */
	public Copy(Resource resource, int copyId) {
		this.resource = resource;
		this.copyId = copyId;
	}

	public void borrow() {
		isBorrowed = true;
	}

	public void returned() {
		isBorrowed = false;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public Resource getResource() {
		return resource;
	}

	public boolean isRequested() {
		return isRequested;
	}

	public void request() {
		isRequested = true;
	}

	public void removeRequest() {
		isRequested = false;
	}

	public void isReturned() {
		isBorrowed = false;
	}

	public static void returnCopy(Copy copy) {
		copy.isReturned();
	}

	public Date getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public static Date getDateNow() {
		return dateNow;
	}

	public Date getDateRequestReturn() {
		return dateRequestReturn;
	}

	public void setDateRequestReturn(Date dateRequestReturn) {
		this.dateRequestReturn = dateRequestReturn;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	/**
	 * Method which allows the user to request a copy which then needs to be
	 * approved by a librarian. Sets isRequested variable to true and sets the
	 * dateRequested to the date now.
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
	 * @param item
	 *            The resource for which the user checks if there is a free copy.
	 * @return Null if there are no free copies and the Copy object which is free if
	 *         there is one.
	 */
	public static Copy checkCopy(Resource item) {
		int i = 0;
		while (i < item.getCopies().size() && item.getCopies().get(i).isBorrowed()
				|| item.getCopies().get(i).isRequested()) {
			i++;
			if (i == item.getCopies().size()) {
				// adds user to queue of users waiting for this resource
				return null;
			}
		}
		return item.getCopies().get(i);
	}

	@Override
	public String toString() {
		return "Copy [resource=" + resource + ", copyId=" + copyId + ", isBorrowed=" + isBorrowed + "]";
	}

}
