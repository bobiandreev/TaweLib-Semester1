
/**
 * A class that creates a new Resource object.
 * @Author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Resource {

	/**
	 * @param id
	 *            Static id which is updated every time a new resource is created.
	 */
	private static int id = 0;

	protected String title;
	protected int year;
	protected Image thumbnailImage;
	protected int numOfCopies;
	public ArrayList<Copy> copies = new ArrayList<>();

	/**
	 * Constructor of the object
	 * 
	 * @param title
	 *            Title of the resource
	 * @param year
	 *            Year of resource release
	 * @param thumbnailImage
	 *            Cover image for the resource
	 * @param numOfCopies
	 *            How many copies exist of the resource in the library
	 */
	public Resource(String title, int year, Image thumbnailImage, int numOfCopies) {
		id++;
		this.title = title;
		this.year = year;
		this.thumbnailImage = thumbnailImage;
		this.numOfCopies = numOfCopies;
		generateCopies();
	}

	/**
	 * Getter method for the id
	 * 
	 * @return resource id
	 */
	public int getid() {
		return id;
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
	public Image getThumbnailImage() {
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
		for (int i = 1; i <= numOfCopies; i++) {
			copies.add(new Copy(this.getid(), i));
		}
	}

	public void borrowCopy() {
		/*
		 * for (Copy copy: copies) { if (!copy.isBorrowed()) { copy.borrow();
		 * System.out.println("User 1 borrowed: Copy " + copy.getCopyId()); break; } }
		 * System.out.println("No copies are free right now!");
		 */
		int i = 0;
		while (i < copies.size() && copies.get(i).isBorrowed()) {
			i++;
		}
		copies.get(i).borrow();
		System.out.println("User 1 borrowed: Copy " + copies.get(i).getCopyId());
	}

	public void returnCopy(int copyID) {
		copies.get(copyID).returned();
	}
}
