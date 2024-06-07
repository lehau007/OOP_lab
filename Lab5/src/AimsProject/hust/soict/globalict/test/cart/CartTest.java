package AimsProject.hust.soict.globalict.test.cart;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.LimitExceededException;

public class CartTest {
    public static void main(String[] args) throws LimitExceededException {
        DigitalVideoDisc disc1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc disc2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc disc3 = new DigitalVideoDisc(3,"Aladin", "Animation", 18.99f);
        Book book1 = new Book(4,"Aladin","Children Story",12.3f);
        book1.addAuthor("Kien");
        book1.addAuthor("Hoang");
        book1.addAuthor("Minh");
        book1.addAuthor("LeHau");
        Store store = new Store();
        store.addMedia(disc1);
        store.addMedia(disc2);
        store.addMedia(disc3);
        store.addMedia(book1);
        Cart cart = new Cart();
        cart.addMedia(disc1, store);
        cart.addMedia(disc2, store);
        cart.addMedia(disc3, store);
        cart.addMedia(book1, store);
        cart.addMedia(book1, store);
        System.out.println(cart.searchTitle("The Lion King"));
        System.out.println(cart.searchID(1));
        cart.sortByTitle();
        cart.printCart();
        cart.sortByCost();
        cart.printCart();
        cart.removeMedia(disc2);
    }
}

