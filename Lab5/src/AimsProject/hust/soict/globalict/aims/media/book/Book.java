package AimsProject.hust.soict.globalict.aims.media.book;

import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Book extends Media {
  private final ArrayList<String> authors = new ArrayList<>();

  public Book(int id, String title) {
    this.setId(id);
    this.setTitle(title);
  }

  public Book(int id, String title, String category) {
    this.setTitle(title);
    this.setId(id);
    this.setCategory(category);
  }

  public Book(int id, String title, String category, float cost) {
    this.setTitle(title);
    this.setId(id);
    this.setCategory(category);
    this.setCost(cost);
  }

  public ArrayList<String> getAuthors() {
    return authors;
  }

  public void addAuthor(String authorName) {
    if (this.authors.contains(authorName)) {
      System.out.println("***This author's name is already in the author list***");
    } else {
      this.authors.add(authorName);
      System.out.println("***This author has been added to the author list***");
    }
  }

  public void removeAuthor(String authorName) {
    if (this.authors.contains(authorName)) {
      this.authors.remove(authorName);
      System.out.println("***This author has been removed from the author list***");
    } else {
      System.out.println("***This author's name does not exist in the author list***");
    }
  }

  public String toString() {
    return "BOOK - [" + this.getId() + "] - [" + this.getTitle() + "] - [" + this.getCategory() + "] - "
        + this.getAuthors() + ":[" + this.getCost() + "]$";
  }
}
