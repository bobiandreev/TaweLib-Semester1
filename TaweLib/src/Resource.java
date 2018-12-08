
/**
 * A class that creates a new Resource object.
 * @Author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Resource implements Serializable {

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
	
	public static void setID() {
		id = SearchBrowse.getResources().size();
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

	public void addCopies(int newNumberOfCopies) {
		int copiesToAdd = newNumberOfCopies - this.numOfCopies;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText("Copies added successfuly!");
		if (!copies.isEmpty()) {
			for (int i = 0; i < copiesToAdd; i++) {
				copies.add(new Copy(this, copies.get((copies.size() - 1)).getCopyId() + 1));
				this.setNumOfCopies(newNumberOfCopies);
				alert.showAndWait();
			}
		} else {
			for (int j = 0; j < copiesToAdd; j++) {
				copies.add(new Copy(this, j + 1));
				this.setNumOfCopies(newNumberOfCopies);
				alert.showAndWait();
			}
		}
	}

	public void removeCopies(int copiesToRemove) {
		int notAvailable = 0;
		ArrayList<Copy> freeCopies = new ArrayList<>();
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setHeaderText("Success!");
		alert1.setContentText("Copies removed successfuly!");
		for (Copy copy : copies) {
			if (copy.getIsBorrowed() || copy.getIsRequested() || copy.getIsReserved()) {
				notAvailable++;
			} else {
				freeCopies.add(copy);
			}
		}
		if (copiesToRemove > notAvailable) {
			for (int i = 0; i < copiesToRemove; i++) {
				copies.remove(freeCopies.get(i));
			}
			for (int j = 0; j < copies.size(); j++) {
				copies.get(j).setCopyID(j + 1);
				this.setNumOfCopies(j + 1);
			}
			alert1.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("There are not enough free copies which can be removed!");
			alert.setContentText("Please wait until enough copies are returned so that they can be removed!");
			alert.showAndWait();
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
			if ((copies.get(index + 1).getCopyId() - copies.get(index).getCopyId()) != 1) {
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
		} while (flag);
		copies.remove(copy);
		this.numOfCopies--;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	/**
	     * ToString method to print out nicely our Object.
	     */
	public String toString() {
		String result = "ID:\t\t\t\t" + this.getID() + "\nTitle:\t\t\t\t" + this.getTitle() + "\nYear published:\t"
				+ this.getYear() + "\nNumber of Copies:\t" + this.getNumOfCopies();
		return result;
	}

}