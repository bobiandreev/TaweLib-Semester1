
/**
 * Class that creates a book object
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */
import javafx.scene.image.Image;

public class Book extends Resource {

	private String author;
	private String genre;
	private String publisher;
	private String ISBN;
	private String language;

	/**
	 * Constructor for the book object
	 * 
	 * @param author
	 *            Author of the book
	 * @param genre
	 *            Genre of the book
	 * @param publisher
	 *            Publisher of the book
	 * @param ISBN
	 *            ISBN of the boo
	 * @param language
	 *            Language of the book
	 * @param title
	 *            Title of the book
	 * @param year
	 *            Year when book was released
	 * @param thumbnailImage
	 *            Cover image of the book
	 * @param numOfCopies
	 *            Number of copies for the book
	 */
	public Book(String title, int year,Image thumbnailImage, int numOfCopies,
			String author, String publisher) {
		super(title, year, thumbnailImage, numOfCopies);
		this.author = author;
		this.publisher = publisher;
	}

	/**
	 * Getter method for author of the book
	 * 
	 * @return Author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Getter method for genre of the book
	 * 
	 * @return Genre of the book
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Setter method for book genre
	 * 
	 * @param genre
	 *            String that holds the genre of the book
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Getter method for book publisher
	 * 
	 * @return The publisher of the book
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Getter method for book ISBN
	 * 
	 * @return The ISBN of the book
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Setter method for book ISBN
	 * 
	 * @param ISBN
	 *            String that holds the book ISBN
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	/**
	 * Getter method for the language of the book
	 * 
	 * @return The language of the book
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Setter method for book language
	 * 
	 * @param language
	 *            String that holds language of the book
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}
