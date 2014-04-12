package data.access;

import java.util.Date;

public class ArtistData {
	private String name="";
	private String gender="";
	private Date birthday=null;
    
	public ArtistData(String name, String gender){
		this.name = name;
		this.gender = gender;
	}
	
	public ArtistData(String name, String gender, Date bd){
		this.name = name;
		this.gender = gender;
		this.birthday = bd;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGender(String g){
		this.gender = g;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public Date getBirthday(){
		return this.birthday;
	}
}
