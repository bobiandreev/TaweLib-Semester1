import javafx.scene.image.Image;

public class Book extends Resource {
	
	private String author;
	private String genre;
	private String publisher;
	private int ISBN;
	private String language;
	
	public Book(String author, String genre, String publisher, int ISBN, String language, String title, int year, Image thumbnailImage, int numOfCopies) {
		super( title, year, thumbnailImage, numOfCopies);
		this.author = author;
		this.genre = genre;
		this.publisher = publisher;
		this.ISBN = ISBN;
		this.language = language;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
