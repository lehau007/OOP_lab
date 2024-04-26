package Media;

import java.util.ArrayList;

public class CompactDisc extends media implements playable {
    private String artist;
    private String director;
    private ArrayList<Track> track = new ArrayList<>();

    // Constructor without track list
    public CompactDisc(int id, String title, String category, String artist, String director, float price) {
        super(id, title, category, price);
        this.artist = artist;
        this.director = director;
    }
    
    // Constructor with track list
    public CompactDisc(int id, String title, String category, String artist, String director, ArrayList<Track> track, float price) {
        this(id, title, category, artist, director, price);
        // Use a copy constructor to avoid modifying the original track list
        this.track = new ArrayList<>(track);
    }

    // Getters
    public String getArtist() {
        return this.artist;
    }

    public String getDirector() {
        return this.director;
    }

    public ArrayList<Track> getTrack() {
        // Return a new ArrayList to prevent direct modification of the internal list
        return new ArrayList<>(track);
    }

    // Setters
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTrack(ArrayList<Track> track) {
        // create a newtrack List 
        this.track = new ArrayList<>(track);
    }

    public void addTrack(Track a) {
        track.add(a);
    }

    public void removeTrack(String title) {
        boolean found = false;
        for (Track t : track) {
            if (t.getTitle().equals(title)) {
                track.remove(t);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.print("In this CD, there isn't this track");
        }
    }

    public int getLength() {
        // Calculate and return the total length of tracks
        int totalLength = 0;
        for (Track t : track) {
            totalLength += t.getLength();
        }
        return totalLength;
    } 


    // This method must to have in this class
    public void play() {
        for (Track t : track) {
            System.out.println("Playing track: " + t.getTitle());
            System.out.println("Track length: " + t.getLength());
        }
    }
}
