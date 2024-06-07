package AimsProject.hust.soict.globalict.test.store;

import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Animation", "Aladin", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"Animation", "Aladin", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.printStore();
        store.removeMedia(dvd1);
        store.printStore();
        CompactDisc cd1 = new CompactDisc(4,"Avatar","Action",12.2f);
        store.addMedia(cd1);
        store.printStore();
        Book book1 = new Book(5,"Animation","Horror",43.2f);
        store.addMedia(book1);
        store.printStore();
    }
}
