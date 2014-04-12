package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DAO {
	private static String username="root";
	private static String passward="wk523";
	private static String port="3306";
	private static String dbname="MusicBase";
	private static Connection connection;
	private static String dbhost="jdbc:mysql://localhost:3306/MusicBase";
	
	public DAO(){
		
	}
	
	public DAO(String port, String dbname, String username, String passward){
		this.port = port;
		this.dbname = dbname;
		this.username = username;
		this.passward = passward;
	}
	
	public void open(){
		dbhost = "jdbc:mysql://localhost:"+port+"/"+dbname;
		System.out.println("-------- MySQL JDBC Connecting ------------");		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error with connecting database.");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		connection = null;
	 
		try {
			connection = DriverManager.getConnection(dbhost,username, passward);
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("Database connected!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public void close(){
		try{
			connection.close();
			System.out.println("Connection closed");
		}catch( SQLException ex){
			System.out.println("cannot close jdbc connection");
		}
	}
	
	public Connection getConn(){
		return this.connection;
	}
}
