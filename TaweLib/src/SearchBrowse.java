
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * A class that stores all the resources that will be used for searching and
 * browsing.
 * 
 * @author Kyriacos Mosphilis
 * @version 1.0
 */
public class SearchBrowse {

	private static ArrayList<Resource> resourceList = new ArrayList<>();

	/**
	 * Method that is used for adding new resources.
	 * 
	 * @param r
	 *            The resource that we want to add into the list.
	 */
	public static void addResource(Resource r) {
		resourceList.add(r);
	}

	/**
	 * Getter method that returns the whole list.
	 * 
	 * @return The list of resources.
	 */
	public static ArrayList<Resource> getResources() {
		return resourceList;
	}

	/**
	 * Method to filter books from the other resources.
	 * 
	 * @return A list containing all the books.
	 */
	public static ArrayList<Resource> getBooks() {
		ArrayList<Resource> bookList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof Book) {
				bookList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		return bookList;
	}

	/**
	 * Method to filter DVDs from the other resources.
	 * 
	 * @return A list containing all the DVDs.
	 */
	public static ArrayList<Resource> getDVDs() {
		ArrayList<Resource> dvdList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof DVD) {
				dvdList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		return dvdList;
	}

	/**
	 * Method to filter laptops from the other resources.
	 * 
	 * @return A list containing all the laptops.
	 */
	public static ArrayList<Resource> getLaptops() {
		ArrayList<Resource> laptopList = new ArrayList<>();
		int count = 0;
		do {
			if (resourceList.get(count) instanceof LaptopComputer) {
				laptopList.add(resourceList.get(count));
			}
			count++;
		} while (count != resourceList.size());
		return laptopList;
	}

	/**
	 * Method that is used for searching using a specific keyword.
	 * 
	 * @param keyword
	 *            Is used to search for corresponding resources.
	 * @return A list containing all the resources that have been filtered.
	 */
	public static ArrayList<Resource> search(String keyword, ArrayList<Resource> currentList) {
		ArrayList<Resource> list = new ArrayList<>();
		int count = 0;
		char[] keywordList = keyword.toLowerCase().toCharArray();
		do {
			Resource r = currentList.get(count);
			char[] titleList = r.getTitle().toLowerCase().toCharArray();
			if (r.getTitle() == keyword) {
				list.add(r);
			} else if (check(keywordList, titleList, 0)) {
				list.add(r);
			}

			count++;
		} while (count != currentList.size());

		return list;
	}

	/**
	 * Method to check if the keyword is included in the title. It should start from
	 * 0 as it indicates the first element of a list.
	 * 
	 * @param keyword
	 *            The searching keyword broken down in characters.
	 * @param title
	 *            The title of the current resource in characters.
	 * @param index
	 *            Used as the index of each element in the lists.
	 * @return True if the keyword is included in the title, otherwise false.
	 */
	private static boolean check(char[] keyword, char[] title, int index) {
		boolean flag = false;
		while (index != keyword.length) {
			if (keyword[index] == title[index]) {
				flag = true;
			} else {
				flag = false;
			}
			index++;
		}
		return flag;
	}
	
	public static Copy findCopy(String title, int copyID) {
		Resource r = null;
		Copy c = null;
		int index = 0;
		boolean flag = true;
		do {
			if (title == resourceList.get(index).getTitle()) {
				r = resourceList.get(index);
				flag = false;
			}
			index++;
		} while(flag);
		c = r.getCopies().get(copyID);
		return c;
	}

	// move this to a different class
	// alpha stage - not tested
	public static void reserved(Resource resource) {
		ArrayList<Date> datesBorrowed = new ArrayList<>();
		for (Copy copy : resource.getCopies()) {
			datesBorrowed.add(copy.getDateBorrowed());
		}
		// Date minDate = Collections.min(datesBorrowed);
		for (User user : resource.getWaitingList()) {
			Date minDate = Collections.min(datesBorrowed);
			// resource.getCopies().get(copyWithDate(resource));
			Copy reservedCopy = copyWithDate(resource, minDate);
			user.getReservedFor().add(reservedCopy);
			reservedCopy.setDateRequested(Copy.getDateNow());
			System.out.println(reservedCopy.getDateRequested());
			reservedCopy.setReserved(true);
			reservedCopy.setReservedFor(user);
			reservedCopy.setDueDate();
			reservedCopy.getBorrowedBy().DueDateMessage(reservedCopy);
			reservedCopy.getReservedFor().reservedForYou();
			// datesBorrowed.removeIf(n -> (n == minDate));
			datesBorrowed.remove(reservedCopy.getDateBorrowed());
		}
	}

	// move with reserved method
	public static Copy copyWithDate(Resource resource, Date date) {
		for (Copy copy : resource.getCopies()) {
			if (copy.getDateBorrowed().equals(date) && !copy.getIsReserved()) {
				return copy;
			}
		}
		return null;
	}
}
