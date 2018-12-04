
/**
 * A class that creates a new Resource object.
 * @Author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class Resource {

	/**
	 * @param id
	 *            Static id which is updated every time a new resource is created.
	 */
	private static int id = 0;
	private int curResourceID = 0;
	private String title;
	private int year;
	private BufferedImage thumbnailImage;
	private int numOfCopies;

	private ArrayList<Copy> copies = new ArrayList<>();
	private ArrayList<User> waitingList = new ArrayList<>();

	/**
	 * Constructor of the object
	 * 
	 * @param title
	 *            Title of the resource
	 * @param year
	 *            Year of resource release
	 * @param image
	 *            Cover image for the resource
	 * @param numOfCopies
	 *            How many copies exist of the resource in the library
	 */
	public Resource(String title, int year, BufferedImage image, int numOfCopies) {
		id++;
		this.curResourceID = id;
		this.title = title;
		this.year = year;
		this.thumbnailImage = image;
		this.numOfCopies = numOfCopies;
		generateCopies();
	}

	/**
	 * Getter method for the id
	 * 
	 * @return resource id
	 */
	public int getid() {
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
	public int getYear() {
		return year;
	}

	/**
	 * Getter method for the cover image of a resource
	 * 
	 * @return The thumbnail image of the resource
	 */
	public BufferedImage getThumbnailImage() {
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
			copies.add(new Copy(this, i+1));
		}
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

	public ArrayList<User> getWaitingList() {
		return waitingList;
	}
}