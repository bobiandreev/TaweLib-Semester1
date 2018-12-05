
/**
 * A class that creates a new Resource object.
 * @Author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */

import java.sql.*;
import java.util.ArrayList;

public class Resource {

	/**
	 * @param id
	 *            Static id which is updated every time a new resource is created.
	 */
	private static int id = 0;
	private int curResourceID;
	private String title;
	private String year;
	private String thumbnailImage;
	private int numOfCopies;

	private ArrayList<Copy> copies = new ArrayList<>();
	private ArrayList<User> waitingList = new ArrayList<>();

	/**
	 * Reader Constructor for a resource.
	 * 
	 * @param resourceID 
	 * 			  The ID this resource had.
	 * @param title
	 *            Title of the resource.
	 * @param year
	 *            Year of resource release.
	 * @param imagePath
	 *            Path of the image.
	 * @param numOfCopies
	 *            How many copies exist of the resource in the library.
	 * @param copiesQuery 
	 * 			  The SQL query to re-generate the right copies.
	 */
	public Resource(int resourceID, String title, String year, String imagePath, int numOfCopies, ResultSet copiesQuery) {
		this.curResourceID = resourceID;
		this.title = title;
		this.year = year;
		this.numOfCopies = numOfCopies;
		id++;
		generateCopies(copiesQuery);
	}
	
	/**
	 * Constructor for a resource.
	 * 
	 * @param title
	 *            Title of the resource.
	 * @param year
	 *            Year of resource release.
	 * @param image
	 *            Cover image for the resource.
	 * @param numOfCopies
	 *            How many copies exist of the resource in the library.
	 */
	public Resource(String title, String year, String image, int numOfCopies) {
		id++;
		this.curResourceID = id;
		this.title = title;
		this.year = year;
		this.thumbnailImage = image;
		this.numOfCopies = numOfCopies;
		generateCopies();
	}

	/**
	 * Getter method for the ID.
	 * 
	 * @return resource ID.
	 */
	public int getID() {
		return curResourceID;
	}

	/**
	 * Getter method for the title of the resource
	 * 
	 * @return resource title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Getter method for the year of release
	 * 
	 * @return year of release of resource
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Getter method for the cover image of a resource
	 * 
	 * @return The thumbnail image of the resource
	 */
	public String getThumbnailImage() {
		return thumbnailImage;
	}

	/**
	 * Getter method for the number of copies existing for the resource
	 * 
	 * @return Number of copies of the resource
	 */
	public int getNumOfCopies() {
		return numOfCopies;
	}

	/**
	 * Method that generates the given number of copies for a given resource
	 */
	public void generateCopies() {
		for (int i = 0; i < numOfCopies; i++) {
			copies.add(new Copy(this, i + 1));
		}
	}

	public void generateCopies(ResultSet copiesQuery) {
		//TODO Implement the generation of copies for the database.
	}
	
	public ArrayList<Copy> getCopies() {
		return copies;
	}

	public void addToWaitList(User user) {
		waitingList.add(user);
	}

	public static int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public ArrayList<User> getWaitingList() {
		return waitingList;
	}
	
	public void addCopy() {
		boolean flag = true;
		int index = 0;
		int copyID = 0;
		do {
			if ((copies.get(index + 1).getCopyId() - 
					copies.get(index).getCopyId()) != 1) {
				copyID = index + 2;
				flag = false;
			}
			index++;
		} while (index != copies.size() - 1 && flag);
		if (!flag) {
			copies.add(new Copy(this, copyID));
		} else {
			copies.add(new Copy(this, index + 2));
		}
	}
	
	public void deleteCopy(int copyID) {
		Copy copy = null;
		boolean flag = true;
		int index = 0;
		do {
			if (copyID == copies.get(index).getCopyId()) {
				copy = copies.get(index);
				flag = false;
			}
			index++;
		} while(flag);
		copies.remove(copy);
		this.numOfCopies--;
	}
	
	@Override
	public String toString() {
		String string= "";
		return string;
	}
	
}