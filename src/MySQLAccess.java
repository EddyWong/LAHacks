import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class MySQLAccess {
	static Connection connection;
	static void Connect(){
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		connection = null;
	 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "wk523");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	static void Close(){
		try{
			connection.close();
			System.out.println("Connection closed");
		}catch( SQLException ex){
			System.out.println("cannot close jdbc connection");
		}
	}
	//logic for executing SQL statements
	static void Insert(){
		try{
			PreparedStatement pstmt =  connection.prepareStatement("Insert into user values(?, ?, ?)");			
			pstmt.setInt(1, 007);
			pstmt.setString(2,"Bo");
			pstmt.setString(3,"Wang");
			pstmt.executeUpdate();
				
		}catch(SQLException e ){
			System.out.println("Your SQL execution has exception!");
			
		}
	}
	
	static void Insert(int id, String fname, String lname){
		try{
			PreparedStatement pstmt =  connection.prepareStatement("Insert into user values(?, ?, ?)");			
			pstmt.setInt(1, id);
			pstmt.setString(2,fname);
			pstmt.setString(3,lname);
			pstmt.executeUpdate();
				
		}catch(SQLException e ){
			System.out.println("Your SQL execution has exception!");
			
		}
	}
	
	static void Select(){
		try{
			PreparedStatement pstmt =  connection.prepareStatement("Select * from user");
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ){
				String fname = rs.getString("FirstName" );
				String lname = rs.getString("LastName");
				int id = rs.getInt("ID");
				System.out.println("name :" + fname+" "+ lname + ", id: " + id);
			}
				
		}catch(SQLException e ){
			System.out.println("Selection has exception!");
			
		}
	}
	
	static void Update(){
		
		try {
			PreparedStatement pstmt =  connection.prepareStatement("Update user set FirstName = ? where id = ?");
			pstmt.setString(1,"Kang");
			pstmt.setInt(2, 001);
			pstmt.executeUpdate();
		}	catch(SQLException e ){
			System.out.println("Update has exception!");
			
		}
	}
	
	static void Delete(){
		try {
			PreparedStatement pstmt =  connection.prepareStatement("Delete from user where FirstName='Kang'");
			pstmt.executeUpdate();
		}	catch(SQLException e ){
			System.out.println("Delete has exception!");
		}
	}
		
//	public static void main(String[] args){
//		Connect();
////		Insert();		
////		Update();
//		Delete();
////		Select();
//		Close();
//
//	}
}
