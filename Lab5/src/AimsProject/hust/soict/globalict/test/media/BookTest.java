package AimsProject.hust.soict.globalict.test.media;

import AimsProject.hust.soict.globalict.aims.media.book.Book;

public class BookTest {
    public static void main(String[] args){
        Book book1 = new Book(1,"KAzuyuki1");
        System.out.println(book1);
        book1.addAuthor("Kien1");
        book1.addAuthor("Kien1");
        book1.addAuthor("Kien2");
        System.out.println(book1.getAuthors());
        System.out.println(book1);
        book1.removeAuthor("Kien1");
        System.out.println(book1.getAuthors());
        book1.removeAuthor("Kien1");
    }
}
