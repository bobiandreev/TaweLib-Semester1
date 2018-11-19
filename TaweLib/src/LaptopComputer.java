import javafx.scene.image.Image;

public class LaptopComputer extends Resource {
	
	private String manufacturer;
	private String model;
	private String OS;
	
	public LaptopComputer(int ID, String title, int year, Image thumbnailImage, int numOfCopies, String manufacturer,
			String model, String oS) {
		super(ID, title, year, thumbnailImage, numOfCopies);
		this.manufacturer = manufacturer;
		this.model = model;
		OS = oS;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}
	

}
