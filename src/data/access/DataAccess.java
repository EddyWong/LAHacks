package data.access;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;

class DataAccess {
	public static void main(String[] args) throws IOException{
		ArrayList<MusicData> data;
		Connection conn=null;
		
		//Read File
		FileRead fread = new FileRead("/Users/EddyWang/Documents/JavaCodes/Hackathon/data3.txt");
		
		//Get ArrayList of data
		data = fread.getMusicData();
		//Close FileReader
		fread.close();
		
		//DAO-Database Access Opener
		DAO dao = new DAO();
		dao.open();
		//Get connection
		conn = dao.getConn();
		
		if(conn!=null){
			//Create DataHandler
			DataHandler handler = new DataHandler(conn);
			//Insert data into table MusicInfo
			handler.insertToMusicInfo(data);
		}else{
			System.out.println("Cannot connect to database.");
		}
		
		dao.close();
		
	}
}
