import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class ResourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Image image = null;
		Resource resource1 = new Resource("TLOTR", 2001, image, 30);
		//resource1.toString();
		
		Resource r2 = new Resource("Hobbit", 1976, image, 29);
		System.out.println(r2.getID());
		System.out.println(resource1.copies.toString());
		
	}

}
