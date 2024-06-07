package AimsProject.hust.soict.globalict.test.polymorphism;

import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;

import java.util.ArrayList;

public class Sample {
    public static void main(String[] args){
        ArrayList<Media> mediaList = new ArrayList<>();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1,"Kazuyuki");
        Book book = new Book(2,"Gayay");
        CompactDisc cd = new CompactDisc(1,"ABC");
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);
        for(Media media : mediaList){
            System.out.println(media);
        }
    }
}
