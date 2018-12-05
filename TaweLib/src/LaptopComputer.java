
/**
 * Class that creates a new Laptop computer object
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.00
 */
import java.sql.ResultSet;

public class LaptopComputer extends Resource {

	private String manufacturer;
	private String model;
	private String OS;

	/**
	 * Reader Constructor for a laptop.
	 * 
	 * @param resourceID
	 * 			  The ID this resource had.
	 * @param title
	 *            Name of computer.
	 * @param year
	 *            Year of manufacture.
	 * @param imagePath
	 *            Path of the image.
	 * @param copiesQuery
	 * 			  The SQL query to re-generate the right copies.
	 * @param numOfCopies
	 *            Total available computers in the library.
	 * @param manufacturer
	 *            Manufacturer of the computer.
	 * @param model
	 *            Model of the computer.
	 * @param OS
	 *            Operating system running on the laptop.
	 */
	public LaptopComputer(int resourceID, String title, String year, 
			String imagePath, ResultSet copiesQuery, int numOfCopies, String manufacturer, 
			String model, String OS) {
		super(resourceID, title, year, imagePath, numOfCopies, copiesQuery);
		this.manufacturer = manufacturer;
		this.model = model;
		this.OS = OS;
	}
	
	/**
	 * Constructor for a laptop.
	 * 
	 * @param title
	 *            Name of computer.
	 * @param year
	 *            Year of manufacture
	 * @param thumbnailImage
	 *            Picture of the laptop
	 * @param numOfCopies
	 *            Total available computers in the library
	 * @param manufacturer
	 *            Manufacturer of the computer
	 * @param model
	 *            Model of the computer
	 * @param OS
	 *            Operating system running on the laptop
	 */
	public LaptopComputer(String title, String year, String thumbnailImage, int numOfCopies, String manufacturer,
			String model, String OS) {
		super(title, year, thumbnailImage, numOfCopies);
		this.manufacturer = manufacturer;
		this.model = model;
		this.OS = OS;
	}

	/**
	 * Getter method for the manufacturer of the laptop
	 * 
	 * @return Manufacturer of the laptop
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Getter method for the model of the laptop
	 * 
	 * @return The model of the laptop
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Getter method for laptop OS
	 * 
	 * @return Operating system running on the laptop
	 */
	public String getOS() {
		return OS;
	}
}
