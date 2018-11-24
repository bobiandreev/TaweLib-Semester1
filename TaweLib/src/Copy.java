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

	public static Copy requestCopy(Resource item) {
		int i = 0;
		while (i < item.getCopies().size() && item.getCopies().get(i).isBorrowed()
				|| item.getCopies().get(i).isRequested()) {
			i++;
			if (i == item.getCopies().size()) {
				// adds user to queue of users waiting for this resource
				return null;
			}
		}
		
		item.getCopies().get(i).request();
		return item.getCopies().get(i);
	}

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
