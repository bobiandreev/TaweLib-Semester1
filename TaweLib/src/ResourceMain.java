import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class ResourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Image image = null;
		Resource resource1 = new Resource(1,"TLOTR", 2001, image, 30);
		resource1.toString();
	}

}
