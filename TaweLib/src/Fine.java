import java.util.Scanner;

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
	 * @param resource
	 *            The resource that has been overdue.
	 * @param daysDelayed
	 *            Days overdue.
	 */
	public Fine(Resource resource, String dueDate, String currentDate) {
		calculateFine(resource, findDays(dueDate, currentDate));
	}

	/**
	 * Method to calculate the fine.
	 * 
	 * @param resource
	 *            The resource that has been overdue.
	 * @param daysDelayed
	 *            Days overdue.
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
	
	private int findDays(String dueDate, String currentDate) {
			int days = 0;
			Scanner input1 = new Scanner(dueDate);
			Scanner input2 = new Scanner(currentDate);
			input1.useDelimiter("/");
			input2.useDelimiter("/");
			int dueDay = input1.nextInt();
			int dueMonth = input1.nextInt();
			int dueYear = input1.nextInt();
			int currentDay = input2.nextInt();
			int currentMonth = input2.nextInt();
			int currentYear = input2.nextInt();
			input1.close();
			input2.close();
			for (int i = dueYear; i < currentYear; i++) {
				if(i % 4 != 0) {
					days += 365;
				} else if (i % 100 != 0) {
					days += 366;
				} else if (i % 400 != 0) { 
					days += 365;
				} else {
					days += 366;
				}
			}
			if (dueMonth != currentMonth) {
				days += findMonthDays(dueMonth, dueYear) - dueDay;
				if (dueMonth != currentMonth - 1) {
					for (int j = dueMonth + 1; j < currentMonth; j++) {
						days += findMonthDays(j, dueYear);
					}
				}
				days += currentDay;
			} else {
				days = currentDay - dueDay;
			}
			System.out.println(days);
			
		return days;
	}
	
	private int findMonthDays(int month, int year) {
		int days;
		switch (month) {
			case 2: 
				if (year % 4 != 0) {
					days = 28;
				} else if (year % 100 != 0) {
					days = 29;
				} else if (year % 400 != 0) { 
					days = 28;
				} else {
					days = 29;
				}
				break;
			
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			default: days = 31; 
				
		}
		return days;
	}
	
}
