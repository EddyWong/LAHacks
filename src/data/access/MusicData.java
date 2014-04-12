package data.access;

class MusicData {
	private String trackname="";
	private String artistname="";
	private int level=0;
	private String level1="";
	private String level2="";
	
	public void setTrackName(String tn){
		this.trackname = tn;
	}
	
	public void setArtistName(String an){
		this.artistname = an;
	}
	
	public void setLevel(int lvl){
		this.level = lvl;
	}
	
	public String getTrackName(){
		return this.trackname;
	}
	
	public String getArtistName(){
		return this.artistname;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public String getlevel1(){
		return this.level1;
	}
	
	public String getlevel2(){
		return this.level2;
	}
	
	public MusicData (String tn, String an, int lvl){
		this.trackname = tn;
		this.artistname = an;
		this.level = lvl;
	}
	
	public MusicData(String tn, String an){
		this.trackname = tn;
		this.artistname = an;
	}
	
	public MusicData (String tn, String an, int lvl, String lvl1, String lvl2){
		this.trackname = tn;
		this.artistname = an;
		this.level = lvl;
		this.level1 = lvl1;
		this.level2 = lvl2;
	}
	
	public MusicData(String tn, String an, String lvl1, String lvl2){
		this.trackname = tn;
		this.artistname = an;
		this.level1 = lvl1;
		this.level2 = lvl2;
	}

}
