package hust.soict.global_ict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private ArrayList <Track> tracks = new ArrayList <Track>();
	
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(id, title, category, cost);
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track already exists!");
			return;
		}
		tracks.add(track);
		System.out.println("Successfully added!");
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Successfully removed!");
			return;
		}
		System.out.println("The track does not exist!");
		
	}
	
	public int getLength() {
		int sum = 0;
		for (Track element : tracks) sum += element.getLength();
		return sum;
	}
	
	public void play() {
		System.out.println("The artist: " + artist);
		for (Track track : tracks) track.play();	
	}
	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
}
