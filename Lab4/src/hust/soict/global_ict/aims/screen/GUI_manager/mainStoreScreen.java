package hust.soict.global_ict.aims.screen.GUI_manager;

import java.util.ArrayList;
import java.util.List;

import hust.soict.global_ict.aims.media.Book;
import hust.soict.global_ict.aims.media.CompactDisc;
import hust.soict.global_ict.aims.media.DigitalVideoDisc;
import hust.soict.global_ict.aims.media.Track;
import hust.soict.global_ict.aims.store.Store;

public class mainStoreScreen {

	public mainStoreScreen() {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		List <String> author1 = new ArrayList<String>();
		author1.add("Munwind");
		author1.add("Lehau");
		
		List <String> author2 = new ArrayList<String>();
		author2.add("J.K. Rowling");
		
		Book book1 = new Book(3, "LeHau finds his first love", "No hope", 99.99f, author1);
		store.addMedia(book1);

		Book book2 = new Book(4, "Harry Potter", "Fantasy", 1.1f, author2);
		store.addMedia(book2);

		CompactDisc CD1 = new CompactDisc(1, "Inception", "Science Fiction", 82, "Hans Zimmer");
		store.addMedia(CD1);

		CompactDisc CD2 = new CompactDisc(1, "The Shawshank Redemption", "Drama", 65, "Thomas Newman");
		store.addMedia(CD2);

		CompactDisc CD3 = new CompactDisc(1, "Spider-Man: No Way Home", "Action", 100, "Michael Giacchino");
		store.addMedia(CD3);

		CompactDisc CD4 = new CompactDisc(1, "The Dark Knight", "Action", 98, "Hans Zimmer");
		store.addMedia(CD4);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);

		new StoreManagerScreen(store);
	}

}
