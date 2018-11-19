import javafx.scene.image.Image;

public class Resource {
	
	protected int ID;
	protected String title;
	protected int year;
	protected Image thumbnailImage;
	protected int numOfCopies;
	
	public Resource(int ID, String title, int year, Image thumbnailImage, int numOfCopies) {
		this.ID = ID;
		this.title = title;
		this.year = year;
		this.thumbnailImage = thumbnailImage;
		this.numOfCopies = numOfCopies;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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
}
