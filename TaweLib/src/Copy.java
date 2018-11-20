/**
 * Class that creates a copy object for a resource
 * 
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */
public class Copy {

	private int resourceId;
	private int copyId;
	private boolean isBorrowed = false;

	public Copy(int resourceId, int copyId) {
		this.resourceId = resourceId;
		this.copyId = copyId;
	}

	public void borrow() {
		isBorrowed = true;
	}
	
	public void returned () {
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

	@Override
	public String toString() {
		return "Copy [resourceId=" + resourceId + ", copyId=" + copyId + ", isBorrowed=" + isBorrowed + "]";
	}

}
