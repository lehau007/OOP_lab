package hust.soict.global_ict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	// Constructors
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
	    super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	    super(title, category, director, length, cost);
	}
	
	// Add for the id
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
	    super(id, title, category, director, length, cost);
	}
	
	public String toString() {
        return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() 
        		+ " - " + this.getLength() + ": " + this.getCost() + " $";
    }
	
	public boolean isMatch(String title) {
		return this.title.equals(title);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}


