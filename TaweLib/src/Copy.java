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
	
	public static Copy borrowCopy(Resource item) {
		/*
		 * for (Copy copy: copies) { if (!copy.isBorrowed()) { copy.borrow();
		 * System.out.println("User 1 borrowed: Copy " + copy.getCopyId()); break; } }
		 * System.out.println("No copies are free right now!");
		 */
		int i = 1;
		while (i <= item.getCopies().size() && item.getCopies().get(i).isBorrowed()) {
			i++;
		}
		item.getCopies().get(i).borrow();
		//System.out.println("User 1 borrowed: Copy " + item.getCopies().get(i).getCopyId());
		return item.getCopies().get(i);
	}
	

	//public void returnCopy(int copyID) {
		//copies.get(copyID).returned();
	// }
	@Override
	public String toString() {
		return "Copy [resourceId=" + resourceId + ", copyId=" + copyId + ", isBorrowed=" + isBorrowed + "]";
	}

}
