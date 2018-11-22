
/**
 * Main method used to test Resource
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

public class ResourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Image image = null;
		Resource resource1 = new Resource("TLOTR", 2001, image, 30);
		// resource1.toString();

		Resource r2 = new Resource("Hobbit", 1976, image, 29);
		// System.out.println(r2.getid());
		// System.out.println(resource1.copies.toString());
		// r2.borrowCopy();

		User user1 = new User("user1", "user 1", 05454645, 56, "Bay Campus", "SA1 8PP", image);
		user1.requestItem(r2);
		user1.requestReturn();
		
		Librarian lib1 = new Librarian("lib1","lib 1", 54656597,65, "Singleton Campus", "SA1 4FS", image, "24/07");
		
		Resource r3 = new Book("H.P. Lovecraft", "Horror", "Vintage Classics", "9-95216-565", "English", "The Call of Cthulhu", 1926, image, 5);
		SearchBrowse.addResource(resource1);
		SearchBrowse.addResource(r2);
		SearchBrowse.addResource(r3);
		//System.out.println(SearchBrowse.getBooks().get(0).getTitle());
		//System.out.println(SearchBrowse.search("t").toString());
		
		Resource r4 = new LaptopComputer("XPS", 2018, image, 3, "Dell", "XPS", "Windows");
		Fine fine = new Fine(r3, 10);
		System.out.println(fine.getCurrentFine());
		Fine fine2 = new Fine(r4, 15);
		System.out.println(fine2.getCurrentFine());

	}

}
