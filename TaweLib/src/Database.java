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
	
	public static void main(String args[]) {
		ArrayList<Resource> input = new ArrayList<Resource>();
		input.add(new Resource(1, null, null, null, 0, null));
		input.add(new Book(1, null, null, null, 0, null, null, null));
		
		Database.storeResourceList(input);
		
		ArrayList<Resource> fromFile = (ArrayList<Resource>) Database.getResourceList();
		System.out.println(fromFile.get(0).getID());
	}
	
	
	/*
	private static final String DB_URL = "jdbc:mysql://sql134.main-hosting.eu/u591224331_lib";
	private static final String DB_USERNAME = "u591224331_grp41";
	private static final String DB_PASS = "group41";
	
	private Connection currentConnection;
	
	Database() {
		this.currentConnection = createConnection();
	}
	
	public Connection getConnection() {
		return this.currentConnection;
	}
	
	public void setConnection(Connection con) {
		this.currentConnection = con;
	}
	
	public Connection createConnection() {
		Connection newConnection = null;
		try {
			System.out.println("Attempting to create connect to database...");
			newConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);
			System.out.println("Connection created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newConnection;
	}
	
	public void closeConnection() {
		try {
			System.out.println("Attempting to close database connection...");
			this.getConnection().close();
			System.out.println("Connection closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet select(String sqlStatement) {
		Statement statement = null;
		try {
			statement = this.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sqlStatement);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insert(String sqlStatement) {
		Statement statement = null;
		try {
			statement = this.getConnection().createStatement();
			statement.executeQuery(sqlStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Resource> getResources(){
		ArrayList<Resource> resourcesAL = new ArrayList<Resource>();
		ResultSet rs = this.select("SELECT * FROM Resource");
		
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				int year = rs.getInt("Year");
				int copies = rs.getInt("Copies");
				
				resourcesAL.add(new Resource(title, copies, null, copies));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resourcesAL;
	}
	
	public ArrayList<Book> getBooks(){
		ArrayList<Book> booksAL = new ArrayList<Book>();
		ResultSet rs = this.select("SELECT * FROM Resource NATURAL JOIN Book");
		
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				int year = rs.getInt("Year");
				int copies = rs.getInt("Copies");
				String author = rs.getString("Author");
				String publisher = rs.getString("Publisher");
				int isbn = rs.getInt("ISBN");
				String language = rs.getString("Language");
				
				booksAL.add(new Book(title, year, null, copies, author, publisher));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return booksAL;
	}
	
	public ArrayList<DVD> getDVDs(){
		ArrayList<DVD> dvdAL = new ArrayList<DVD>();
		ResultSet rs = this.select("SELECT * FROM Resource NATURAL JOIN DVD");
		
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				int year = rs.getInt("Year");
				int copies = rs.getInt("Copies");
				String director = rs.getString("Director");
				int runtime = rs.getInt("Runtime");
				String language = rs.getString("Language");
				String subs = rs.getString("Subtitles");
				
				dvdAL.add(new DVD(title, year, null, copies, director, runtime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dvdAL;
	}

	
	public ArrayList<LaptopComputer> getLaptopComputers(){
		ArrayList<LaptopComputer> lcAL = new ArrayList<LaptopComputer>();
		ResultSet rs = this.select("SELECT * FROM Resource NATURAL JOIN LaptopComputer");
		
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("Title");
				int year = rs.getInt("Year");
				int copies = rs.getInt("Copies");
				String os = rs.getString("OS");
				String manufacturer = rs.getString("Manufacturer");
				String model = rs.getString("Model");
				
				lcAL.add(new LaptopComputer(title, year, null, copies, manufacturer, model, os));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lcAL;
	}
	
	public ArrayList<Copy> getCopies(){
		ArrayList<Copy> copyAL = new ArrayList<Copy>();
		ResultSet rs = this.select("SELECT * FROM Resource NATURAL JOIN Copy");
		
		try {
			while(rs.next()) {				
				copyAL.add(new Copy());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return copyAL;
	}
	
	//Method to check database table exists and is functioning properly
	private boolean checkDatabase() {
		
		return true;
	}
	
	private void createDatabase() {
		
	}*/
}