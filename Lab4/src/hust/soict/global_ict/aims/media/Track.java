package hust.soict.global_ict.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public boolean equals(Object obj) {
		if (obj == this) return true;
		
		Track other = (Track) obj;
		
		return title.equals(other.getTitle()) && length == other.getLength();
	}
}

