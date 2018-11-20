
/**
 * Class that creates a DVD object
 * @author Boris Andreev and Kyriacos Mosphilis
 */
import javafx.scene.image.Image;

public class DVD extends Resource {

	private String director;
	private int runtime;
	private String language;
	private String subtitles;

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
	 * @param language
	 *            Language of the film
	 * @param subtitles
	 *            Subtitles available for the film
	 */
	public DVD(String title, int year, Image thumbnailImage, int numOfCopies, String director, int runtime,
			String language, String subtitles) {
		super(title, year, thumbnailImage, numOfCopies);
		this.director = director;
		this.runtime = runtime;
		this.language = language;
		this.subtitles = subtitles;
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
