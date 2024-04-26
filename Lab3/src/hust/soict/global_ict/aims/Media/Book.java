package Media;

public class Book extends media {
    // A book’s information includes: id, title, category, cost and list of authors. 
    private String[] authors;

    // Constructors 
    public Book(int id, String title, String category, float cost, String[] authors) {
        super(id, title, category, cost);
        this.authors = authors.clone();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(String title, String category, float cost) {
        super(1, title, category, cost);
    }

    // Get elements
    public String[] getAuthur() {
        return this.authors.clone();
    }

    // Setter()
    public void setAuthors(String[] authors) {
        this.authors = authors.clone();
    }
}
