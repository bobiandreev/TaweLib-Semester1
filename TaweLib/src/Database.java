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
			System.out.println("Stored object in /data/resourcelist.ser");
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
			System.out.println("Stored object in userlist.ser");
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
}