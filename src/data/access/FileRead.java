package data.access;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	private static FileReader freader;
	private static BufferedReader in;
	
	public FileRead(String filepath) throws FileNotFoundException{
		freader = new FileReader(filepath);
		in = new BufferedReader(freader);
	}
	
	public ArrayList<MusicData> getMusicData() throws IOException{
		ArrayList<MusicData> mdata = new ArrayList<MusicData>();	
		String str;
		while((str = in.readLine())!= null){
			String[] data = str.split("\t");
			mdata.add(new MusicData(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]));
		}
		return mdata;
	} 
	
	public ArrayList<ArtistData> getArtistData() throws IOException{
		ArrayList<ArtistData> adata = new ArrayList<ArtistData>();
		String str;
		while((str = in.readLine())!= null){
			String[] data = str.split("\t");
			adata.add(new ArtistData(data[0], data[1]));
		}
		return adata;
	}
	
	public void close() throws IOException{
		freader.close();
		in.close();
	}
}
