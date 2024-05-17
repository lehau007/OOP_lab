package hust.soict.global_ict.aims.media;

public abstract class Disc extends Media{
	protected int length;
	protected String director;
	
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

	public Disc(String title) {
		super(title);
	}
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
	    super(title, category, cost);
	    this.director = director;
	    this.length = length;
	}
	
	// Helps the CompactDisc constructors
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}

	
}

