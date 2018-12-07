import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class Database {
	
	
	public static void storeResourceList(ArrayList<Resource> al) {
		try {
			FileOutputStream outFile = 
					new FileOutputStream("resourcelist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			System.out.println("Stored resource list in /data/resourcelist.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Resource> getResourceList() {
		ArrayList<Resource> resourceList = null;
		try {
			FileInputStream inFile = 
					new FileInputStream("resourcelist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			resourceList = (ArrayList<Resource>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return resourceList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void storeUserList(ArrayList<User> al) {
		try {
			FileOutputStream outFile = 
					new FileOutputStream("userlist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			System.out.println("Stored user list in userlist.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<User> getUserList() {
		ArrayList<User> userList = null;
		try {
			FileInputStream inFile = 
					new FileInputStream("userlist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			userList = (ArrayList<User>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return userList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void storeLibList(ArrayList<Librarian> al) {
		try {
			FileOutputStream outFile = 
					new FileOutputStream("liblist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			System.out.println("Stored librarian list in liblist.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Librarian> getLibList() {
		ArrayList<Librarian> libList = null;
		try {
			FileInputStream inFile = 
					new FileInputStream("liblist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			libList = (ArrayList<Librarian>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return libList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void saveData() {
		Database.storeResourceList(SearchBrowse.getResources());
		Database.storeUserList(Librarian.getUsersList());
		Database.storeLibList(Librarian.getLibrarianList());
	}
	
	public static void setupFiles() {
		ArrayList<Resource> newResourceList = new ArrayList<Resource>();
		ArrayList<User> newUserList = new ArrayList<User>();
		ArrayList<Librarian> newLibList = new ArrayList<Librarian>();
		Resource resource1 = new Book("TLOTR", "2001", "Avatar4.png", 3, "Tolkien", "Springer");
		Resource resource2 = new LaptopComputer("XPS", "2018", "Avatar4.png", 3, "Dell", "XPS", "Windows");
		Resource resource3 = new DVD("TLOTR", "2001", "Avatar4.png", 10, "Peter Jackson", "180");
				//("TLOTR", 2001, null, 30);
		User user1 = new User("user1", "user 1", "05454645", "56", "Bay Campus", "SA1 8PP", "Avatar5.png");
		User user2 = new User("user2", "user 1", "05454645", "56", "Bay Campus", "SA1 8PP", "Avatar5.png");
		Librarian lib1 = new Librarian("lib1", "lib 1", "54656597", "65", "Singleton Campus", "SA1 4FS", "Avatar5.png", "24/07");
		newResourceList.add(resource1);
		newResourceList.add(resource2);
		newResourceList.add(resource3);
		newUserList.add(user1);
		newUserList.add(user2);
		newLibList.add(lib1);
		
		Database.storeResourceList(newResourceList);
		Database.storeUserList(newUserList);
		Database.storeLibList(newLibList);
	}
}