import java.util.ArrayList;

import javafx.scene.image.Image;

public class Resource {
	
	private static int ID = 0;
	protected String title;
	protected int year;
	protected Image thumbnailImage;
	protected int numOfCopies;
	public ArrayList<Copy> copies = new ArrayList<>();
	
	public Resource(String title, int year, Image thumbnailImage, int numOfCopies) {
		ID++;
		this.title = title;
		this.year = year;
		this.thumbnailImage = thumbnailImage;
		this.numOfCopies = numOfCopies;
		generateCopies();
	}
	
	public int getID() {
		return ID;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Image getThumbnailImage() {
		return thumbnailImage;
	}

	public void setThumbnailImage(Image thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	
	public void generateCopies() {
		for (int i = 1; i <= numOfCopies; i++) {
			copies.add(new Copy(this.getID(), i));
		}
	}
}
