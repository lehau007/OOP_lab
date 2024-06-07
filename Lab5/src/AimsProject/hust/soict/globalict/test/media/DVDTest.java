package AimsProject.hust.soict.globalict.test.media;

import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.exception.PlayerException;

public class DVDTest {
    public static void main(String[] args) throws PlayerException{
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Kazuyuki1");
        System.out.println(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Kazuyuki2", "Horror",9.32f);
        System.out.println(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Kazuyuki3","Horror","Kien",-120,3.2f);
        System.out.println(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"Kazuyuki4","Horror","Kien",3.4f);
        System.out.println(dvd4);
        try {
        	dvd1.play();
        	dvd3.play();
        } catch(PlayerException e) {
        	throw e;
        }
        
    }
}
