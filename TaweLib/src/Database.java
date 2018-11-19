import java.sql.*;

public class Database {
	
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql134.main-hosting.eu/u591224331_lib";
	static final String DB_USERNAME = "u591224331_grp41";
	static final String DB_PASS = "group41";
	
	public static void main(String args[]){
		
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
		
	}
}
