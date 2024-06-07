package AimsProject.hust.soict.globalict.test.media;

import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import hust.soict.globalict.aims.exception.PlayerException;

public class CDTest {
    public static void main(String[] args) throws PlayerException{
        CompactDisc compactDisc = new CompactDisc(1,"Kazuyuki");
        System.out.println(compactDisc);
        compactDisc = new CompactDisc(2,"Kazuyuki","Jazz",3.4f);
        System.out.println(compactDisc);
        compactDisc = new CompactDisc(2,"Kazuyuki","Jazz","Kien",3.4f);
        Track track1 = new Track("Rick roll", -1);
        Track track2 = new Track("Lemon Tree",11);
        Track track3 = new Track("Lemon Tree", 11);
        compactDisc.addTrack(track1);
        compactDisc.addTrack(track2);
        compactDisc.addTrack(track3);
        System.out.println(track2.equals(track3));
        //compactDisc.removeTrack(track1);
        //compactDisc.removeTrack(track1);
        System.out.println(compactDisc);
        try {
        	compactDisc.play();
        } catch (PlayerException e) {
        	throw e;
        }
    }
}
