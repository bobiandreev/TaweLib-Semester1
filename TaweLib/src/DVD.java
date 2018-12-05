
/**
 * Class that creates a DVD object
 * @author Boris Andreev and Kyriacos Mosphilis
 */
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class DVD extends Resource {

	private String director;
	private int runtime;
	private String language;
	private String subtitles;

	/**
	 * Reader Constructor of DVD.
	 * 
	 * @param resourceID
	 * 			  The ID this resource had.
	 * @param title
	 *            Title of the DVD.
	 * @param year
	 *            Year of release.
	 * @param imagePath
	 *            Path of the image.
	 * @param numOfCopies
	 *            How many are available in the library.
	 * @param director
	 *            Director of the film.
	 * @param runtime
	 *            Runtime of film.
	 * @param copiesQuery
	 * 			  The SQL query to re-generate the right copies.
	 */
	public DVD(int resourceID, String title, int year, String imagePath, int numOfCopies,
			String director, int runtime, ResultSet copiesQuery) {
		super(resourceID, title, year, imagePath, numOfCopies, copiesQuery);
		this.director = director;
		this.runtime = runtime;
	}
	/**
	 * Constructor for DVD
	 * 
	 * @param title
	 *            Title of the DVD
	 * @param year
	 *            Year of release
	 * @param thumbnailImage
	 *            Cover Image
	 * @param numOfCopies
	 *            How many are available in the library
	 * @param director
	 *            Director of the film
	 * @param runtime
	 *            Runtime of film
	 */
	public DVD(String title, int year, String thumbnailImage, int numOfCopies,
			String director, int runtime) {
		super(title, year, thumbnailImage, numOfCopies);
		this.director = director;
		this.runtime = runtime;
		//this.language = language;
		//this.subtitles = subtitles;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Getter method for film director
	 * 
	 * @return Name of film director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Getter method for film runtime
	 * 
	 * @return The runtime of the film
	 */
	public int getRuntime() {
		return runtime;
	}

	/**
	 * Getter method for the film's language
	 * 
	 * @return The language of the film
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Getter method for film's list of subtitles
	 * 
	 * @return Subtitles available for the film
	 */
	public String getSubtitles() {
		return subtitles;
	}

	/**
	 * Setter method for the film's subtitles
	 * 
	 * @param subtitles
	 *            String that holds the available subtitles
	 */
	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

}
