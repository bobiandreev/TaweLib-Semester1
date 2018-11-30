import java.sql.*;

public class Database {
	
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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
	
	//Method to check database table exists and is functioning properly
	private boolean checkDatabase() {
		
		return true;
	}
	
	private void createDatabase() {
		
	}
	
	//Example of how to use select method and view results
	public static void main(String args[]) {
		Database newDB = new Database();
		ResultSet rs = newDB.select("SELECT * FROM test");
		try {
			while(rs.next()){
				String name = rs.getString("Name");
				
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		newDB.closeConnection();
	}
	
	
	
	/*public static void main(String args[]){
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);
			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM test";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String name = rs.getString("Name");
				
				System.out.println(name);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
	}*/
}
