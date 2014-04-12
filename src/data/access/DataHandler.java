package data.access;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
class DataHandler {
	private static Connection conn;
	
	public DataHandler(Connection c){
		this.conn = c;
	}
	
	//Insert data into table MusicInfo
	public void insertToMusicInfo(ArrayList<MusicData> data){
		for(int i=0;i<data.size();i++){
			MusicData m = data.get(i);
			try{
				PreparedStatement pstmt =  conn.prepareStatement("Insert into MusicInfo values(?, ?, ?, ?, ?)");
				pstmt.setString(1, m.getTrackName());
				pstmt.setString(2, m.getArtistName());
				pstmt.setInt(3, m.getLevel());
				pstmt.setString(4, m.getlevel1());
				pstmt.setString(5, m.getlevel2());
				pstmt.executeUpdate();
					
			}catch(SQLException e ){
				System.out.println("Your SQL execution has exception!");
				
			}
		}
		System.out.println("Insert data successfully.");
	}

}
