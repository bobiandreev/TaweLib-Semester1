import java.util.ArrayList;

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
	
}
