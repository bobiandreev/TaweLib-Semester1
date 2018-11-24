
/**
 * This class is for handling user fines.
 * 
 * @author Kyriacos Mosphilis
 *
 */
public class Fine {
	
	private final int BOOK_DVD_FINE = 2;
	private final int LAPTOP_FINE = 10;
	private final int MAX_BOOK_DVD_FINE = 25;
	private final int MAX_LAPTOP_FINE = 100;
	private int currentFine;
	
	/**
	 * Constructor that create the current fine.
	 * 
	 * @param resource The resource that has been overdue.
	 * @param daysDelayed Days overdue.
	 */
	public Fine(Resource resource, int daysDelayed) {
		calculateFine(resource, daysDelayed);
	}
	
	/**
	 * Method to calculate the fine.
	 * 
	 * @param resource The resource that has been overdue.
	 * @param daysDelayed Days overdue.
	 */
	private void calculateFine(Resource resource, int daysDelayed) {
		if ((resource instanceof Book) || (resource instanceof DVD)) {
			do {
				if (currentFine == 24) {
					currentFine += 1;
				} else {
					currentFine += BOOK_DVD_FINE;
				}
				daysDelayed--;
			} while ((daysDelayed != 0) && (currentFine != MAX_BOOK_DVD_FINE));
		} else {
			do {
				currentFine += LAPTOP_FINE;
				daysDelayed--;
			} while ((daysDelayed != 0) && (currentFine != MAX_LAPTOP_FINE));
		}
	}
	
	/**
	 * Getter method that returns the current fine.
	 * 
	 * @return The fine to be paid.
	 */
	public int getCurrentFine() {
		return currentFine;
	}
}
