package AimsProject.hust.soict.globalict.aims.store;

import java.util.ArrayList;

import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;

public class Store {
    public ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media item){
        if (item != null){
            if(!this.itemsInStore.contains(item)){
                this.itemsInStore.add(item);
                System.out.println("***The item has been added to the store***");
            } else {
                System.out.println("***The item exists in the store***");
            }
        } else {
            System.out.println("***The given item is not available***");
        }
    }
    public void removeMedia(Media item){
        if (item != null){
            if(itemsInStore.contains(item)){
                itemsInStore.remove(item);
                System.out.println("***The item has been removed from the store***");
            } else {
                System.out.println("***The item does not exist in the store***");
            }
        } else {
            System.out.println("***The given item is not available***");
        }
    }
    public void printStore(){
        System.out.println("***********************************Store***********************************");
        System.out.println("Ordered Items:");
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
        System.out.println("***************************************************************************");
    }
    public void init(){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Animation", "Aladin", 18.99f);
        Book book1 = new Book(4,"Kazuyuki");
        book1.addAuthor("Kien1");
        book1.addAuthor("Kien2");
        CompactDisc compactDisc = new CompactDisc(5,"Anou","Jazz","Kien",3.4f);
        Track track1 = new Track("Rick roll", 10);
        Track track2 = new Track("Lemon Tree",11);
        Track track3 = new Track("Lemon Tree", 11);
        compactDisc.addTrack(track1);
        compactDisc.addTrack(track2);
        compactDisc.addTrack(track3);
        this.addMedia(dvd1);
        this.addMedia(dvd2);
        this.addMedia(dvd3);
        this.addMedia(book1);
        this.addMedia(compactDisc);
    }
    public Media searchTitle(String title) {
        for (Media item : this.itemsInStore) {
            if (item.isMatch(title)) {
                return item;
            }
        }
        return null;
    }
}
