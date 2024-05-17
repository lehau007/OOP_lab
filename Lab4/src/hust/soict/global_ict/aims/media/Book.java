package hust.soict.global_ict.aims.media;


import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List <String> authors = new ArrayList <String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) System.out.println("The author exists");
		else {
			authors.add(authorName);
			System.out.println("Successfully added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Successfully remove");
			return;
		}
		System.out.println("The author name does not exist!");
	}

	@Override
	public String toString() {
		return "Book [id=" + this.getId() + ", title=" + this.getTitle() + ", category=" + this.getCategory() + 
				", cost=" + this.getCost() + ", authors=" + authors + "]";
	}
	
	public boolean isMatch(String title){
        return this.title.equals(title);
    }
}

