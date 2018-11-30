
/**
 * Main method used to test Resource
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */

import javafx.scene.image.Image;

public class ResourceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Image image = null;
		Resource resource1 = new Resource("TLOTR", 2001, image, 30);
		// resource1.toString();

		Resource r2 = new Book("Hobbit", 1976, image, 3, "Tolkien", "Who cares");
		// System.out.println(r2.getid());
		// System.out.println(resource1.copies.toString());
		// r2.borrowCopy();

		User user1 = new User("user1", "user 1", 05454645, 56, "Bay Campus", "SA1 8PP", image);
		user1.requestItem(r2);
		user1.requestItem(r2);
		user1.requestItem(r2);

		// r2.getCopies().get(0).setDueDate();
		// System.out.println(r2.getCopies().get(0).toString1());

		Librarian lib1 = new Librarian("lib1", "lib 1", 54656597, 65, "Singleton Campus", "SA1 4FS", image, "24/07");

		lib1.getUsersList().add(user1);
		lib1.approveBorrow();
		user1.requestItem(r2);
		r2.getCopies().get(0).setDueDate();
		user1.displayBorrowedItems();
		user1.requestReturn(user1.getBorrowedItems().get(0));
		lib1.approveReturn();
		System.out.println(r2.getCopies().get(0).getCopyHistory());

		Resource r3 = new Book("The Call of Cthulhu", 1926, image, 5, "H.P. Lovecraft", "Vintage Classics");
		SearchBrowse.addResource(resource1);
		SearchBrowse.addResource(r2);
		SearchBrowse.addResource(r3);
		// System.out.println(SearchBrowse.getBooks().get(0).getTitle());
		// System.out.println(SearchBrowse.search("t").toString());

		Resource r4 = new LaptopComputer("XPS", 2018, image, 3, "Dell", "XPS", "Windows");
		// Fine fine = new Fine(r3, "29/02/2020", "03/04/2020");
		// System.out.println(fine.getCurrentFine());
		// Fine fine2 = new Fine(r4, 15);
		// System.out.println(fine2.getCurrentFine());

	}

}
